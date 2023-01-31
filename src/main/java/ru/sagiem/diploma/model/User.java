package ru.sagiem.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
