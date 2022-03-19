package com.clone.netflix.msuser.dataAccess.abstracts;

import com.clone.netflix.msuser.entities.concretes.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByPhone(String phone);
}
