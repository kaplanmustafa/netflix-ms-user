package com.clone.netflix.msuser.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserDto {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "{netflix-ms-user.constraint.name.Pattern.message}")
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "{netflix-ms-user.constraint.surname.Pattern.message}")
    @Size(min = 2, max = 255)
    private String surname;

    @NotNull(message = "{netflix-ms-user.constraints.email.NotNull.message}")
    @Email(message = "{netflix-ms-user.constraint.email.Valid.message}")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 10, message = "{netflix-ms-user.constraint.phone.Valid.message}")
    @Pattern(regexp = "[0-9\\\\s]{10}", message = "{netflix-ms-user.constraint.phone.Pattern.message}")
    private String phone;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{netflix-ms-user.constraints.password.Pattern.message}")
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{netflix-ms-user.constraints.password.Pattern.message}")
    private String passwordRepeat;
}
