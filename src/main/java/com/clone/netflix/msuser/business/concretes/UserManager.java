package com.clone.netflix.msuser.business.concretes;

import com.clone.netflix.msuser.business.abstracts.UserService;
import com.clone.netflix.msuser.core.exceptions.CustomValidationException;
import com.clone.netflix.msuser.core.results.Result;
import com.clone.netflix.msuser.core.results.success.SuccessResult;
import com.clone.netflix.msuser.core.services.abstracts.PasswordService;
import com.clone.netflix.msuser.dataAccess.abstracts.UserDao;
import com.clone.netflix.msuser.entities.concretes.user.User;
import com.clone.netflix.msuser.entities.dtos.AddUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class UserManager implements UserService {

    private static final String EMAIL_NOT_UNIQUE_MESSAGE = "This Email Address Belongs to Another User!";
    private static final String PHONE_NOT_UNIQUE_MESSAGE = "This Phone Number Belongs to Another User!";
    private static final String PASSWORD_MISMATCH_MESSAGE = "Password Mismatch!";
    private static final String SUCCESSFUL_REGISTRATION_MESSAGE = "Successful Registration";

    private final UserDao userDao;
    private final PasswordService passwordService;

    @Autowired
    public UserManager(UserDao userDao, PasswordService passwordService) {
        this.userDao = userDao;
        this.passwordService = passwordService;
    }

    @Override
    public Result addUser(AddUserDto addUserDto) {
        // Check Fields is valid
        checkFieldsIsValid(addUserDto);

        //Save user to DB
        User user = new User();
        user.setName(addUserDto.getName());
        user.setSurname(addUserDto.getSurname());
        user.setEmail(addUserDto.getEmail());
        user.setPhone(addUserDto.getPhone());
        user.setKeyreg(UUID.randomUUID().toString());
        user.setPassword(passwordService.encodePassword(addUserDto.getPassword()));
        userDao.save(user);

        SuccessResult successResult = new SuccessResult(SUCCESSFUL_REGISTRATION_MESSAGE);
        log.info("TID: " + successResult.getTid() + " Message: User created, user id: " + user.getId());

        return successResult;
    }

    private void checkFieldsIsValid(AddUserDto addUserDto) {
        Map<String, String> validationErrors = new HashMap<>();

        User emailInDb = userDao.findByEmail(addUserDto.getEmail());
        User phoneInDb = userDao.findByPhone(addUserDto.getPhone());

        if (emailInDb != null) {
            validationErrors.put("email", EMAIL_NOT_UNIQUE_MESSAGE);
        }
        if (phoneInDb != null) {
            validationErrors.put("phone", PHONE_NOT_UNIQUE_MESSAGE);
        }
        if (!addUserDto.getPassword().equals(addUserDto.getPasswordRepeat())) {
            validationErrors.put("password", PASSWORD_MISMATCH_MESSAGE);
        }

        if (!validationErrors.isEmpty()) {
            throw new CustomValidationException(validationErrors);
        }
    }
}
