package com.juxtapose.juxtaposeapi.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItems {
    Integer id;
    String menuItem;

}
