package edu.school21.cinema.models;

import lombok.Data;

@Data
public class User {
    Long id;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
    String password;
}
