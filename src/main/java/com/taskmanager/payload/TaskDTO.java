package com.taskmanager.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Long assignedUserId;


}

