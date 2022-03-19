package com.clone.netflix.msuser.business.abstracts;

import com.clone.netflix.msuser.core.results.Result;
import com.clone.netflix.msuser.entities.dtos.AddUserDto;

public interface UserService {

    Result addUser(AddUserDto addUserDto);
}
