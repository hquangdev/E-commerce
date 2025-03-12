package com.example.webbe.DTO.user;

import com.example.webbe.Validator.DobConstraint;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @Column(name = "name", columnDefinition = "VARCHAR(500)")
    @Size(min = 5, message = "USER_NAME_FAILED")
    private String name;

    @Email(message = "USER_EMAIL_FAILED")
    private String email;

    @Size(min = 8, message = "USER_PASS_FAILED")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    message = "USER_PASS_FAILED_KITU")
    private String password;

    private String phone;
    private String address;

    private Set<String> roles;
}
