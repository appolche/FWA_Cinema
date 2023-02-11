package edu.school21.cinema.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Session {
    Long id;
    String ip;
    Long userId;
    LocalDateTime date;
}
