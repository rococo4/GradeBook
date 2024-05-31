package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.RoleDto;
import com.example.GradeBook.Response.RoleResponse;
import com.example.GradeBook.store.entities.RoleEntitiy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleFactory {
    public RoleResponse makeRoleResponse(RoleEntitiy role) {
        return RoleResponse.builder()
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
