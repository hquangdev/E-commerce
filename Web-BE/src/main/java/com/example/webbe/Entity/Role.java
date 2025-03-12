package com.example.webbe.Entity;

import com.example.webbe.Enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Role {
    @Id
    private String name;
    private String description;

    @ManyToMany
    private Set<Permission> permission;

    public Role(RoleEnum roleEnum) {
    }
}
