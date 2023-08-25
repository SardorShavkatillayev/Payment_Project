package com.example.payment_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;// controller repository  service
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseModel {
    private UUID id;
    private LocalDateTime created_date;
    private LocalDateTime update_date;
}

