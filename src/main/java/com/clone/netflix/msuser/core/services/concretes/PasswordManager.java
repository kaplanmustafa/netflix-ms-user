package com.clone.netflix.msuser.core.services.concretes;

import com.clone.netflix.msuser.core.services.abstracts.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordManager implements PasswordService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordManager(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encodePassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }
}
