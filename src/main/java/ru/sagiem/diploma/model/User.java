package ru.sagiem.diploma.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.naming.Name;


@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @Size(min = 2,max = 20,message = "Количество символов от 2 до 20")
    private String username;

    @Column(name = "password")
    @Size(min = 2,max = 20,message = "Количество символов от 2 до 20")
    private String password;

    @Column(name = "firstName")
    @Size(min = 2,max = 20,message = "Количество символов от 2 до 20")
    private String firstName;

    @Column(name = "lastName")
    @Size(min = 2,max = 20,message = "Количество символов от 2 до 20")
    private String lastName;

    @Column(name = "email")
    @Email()
    private String email;
}
