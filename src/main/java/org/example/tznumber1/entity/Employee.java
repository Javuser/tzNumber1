package org.example.tznumber1.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String lastName;

    private String firstName;

    private String middleName;

    private String phoneNumber;

    private String email;

    private String country;

    private String city;

    // Getters and setters
}
