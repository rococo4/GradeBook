package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.RoleDto;
import com.example.GradeBook.store.entities.RoleEntitiy;
import org.springframework.stereotype.Component;

@Component
public class RoleFactory {
    public RoleDto makeRoleDto(RoleEntitiy role) {
        return RoleDto.builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
    }

    public RoleEntitiy makeRoleEntity(RoleDto roleDto) {
       return RoleEntitiy.builder()
                .roleId(roleDto.getRoleId())
                .roleName(roleDto.getRoleName())
                .build();
    }
}
