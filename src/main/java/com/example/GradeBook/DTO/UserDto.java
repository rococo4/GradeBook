package com.example.GradeBook.DTO;

import com.example.GradeBook.store.entities.RoleEntitiy;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @JsonProperty("user_id")
    private Long userId;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    @JsonProperty("first_name")
    private String firstName;

    @NonNull
    @JsonProperty("last_name")
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private RoleDto role;
}
