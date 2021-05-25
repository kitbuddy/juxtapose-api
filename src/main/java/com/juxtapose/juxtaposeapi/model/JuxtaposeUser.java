package com.juxtapose.juxtaposeapi.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JuxtaposeUser {
    Integer id;
    String first_name;
    String last_name;
    String email;
    String phone;

}
