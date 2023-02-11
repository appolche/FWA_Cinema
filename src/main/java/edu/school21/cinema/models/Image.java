package edu.school21.cinema.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Image {
    Long id;
    UUID uuid;
    String original_name;
    Long size;
    String mime;
    Long userId;
    LocalDateTime date;

}

