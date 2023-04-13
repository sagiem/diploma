package ru.sagiem.diploma.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="text")
    private String text;

    @Column(name="userId")
    private long userId;

    //TODO: add logic to work with Date type in ajax methods
    @Column(name="date")
    private Date date;
}
