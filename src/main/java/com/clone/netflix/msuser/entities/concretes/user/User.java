package com.clone.netflix.msuser.entities.concretes.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String password;

    private Boolean isVerifiedEmail = Boolean.FALSE;

    private String keyreg;
}
