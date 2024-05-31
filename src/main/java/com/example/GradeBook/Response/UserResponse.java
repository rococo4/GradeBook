package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    @JsonProperty("user_id")
    private Long userId;

    @NonNull
    private String username;


    @NonNull
    @JsonProperty("first_name")
    private String firstName;

    @NonNull
    @JsonProperty("last_name")
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private RoleResponse role;
}
