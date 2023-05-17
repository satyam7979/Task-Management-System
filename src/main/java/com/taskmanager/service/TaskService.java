package com.taskmanager.service;

import com.taskmanager.payload.TaskDTO;

public interface TaskService {
    public TaskDTO createTask(TaskDTO taskDTO);
}
