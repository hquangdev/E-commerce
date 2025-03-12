package com.example.webbe.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;


@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @Column(name = "email", columnDefinition = "VARCHAR(500)")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(200)")
    private String password;

    @Column(name = "phone", columnDefinition = "VARCHAR(15)")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phone;

    @Column(name = "address", columnDefinition = "VARCHAR(500)")
    @Size(max = 500, message = "Address cannot be longer than 500 characters")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Getter
    @ManyToMany
    private Set<Role> roles;

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
