package com.taskmanager.service.impl;

import com.taskmanager.entities.Task;
import com.taskmanager.entities.User;
import com.taskmanager.payload.TaskDTO;
import com.taskmanager.repository.TaskRepository;
import com.taskmanager.repository.UserRepository;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskServiceImpl  implements TaskService {

    @Autowired
    private  TaskRepository taskRepository;
    @Autowired
    private  UserRepository userRepository;



    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCreatedAt(LocalDateTime.now());

        if (taskDTO.getAssignedUserId() != null) {
            User assignedUser = userRepository.findById(taskDTO.getAssignedUserId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user ID."));
            task.setAssignedUser(assignedUser);
        }

        Task savedTask = taskRepository.save(task);

        TaskDTO savedTaskDTO = new TaskDTO();
        savedTaskDTO.setId(savedTask.getId());
        savedTaskDTO.setTitle(savedTask.getTitle());
        savedTaskDTO.setDescription(savedTask.getDescription());
        savedTaskDTO.setCreatedAt(savedTask.getCreatedAt());
        if (savedTask.getAssignedUser() != null) {
            savedTaskDTO.setAssignedUserId(savedTask.getAssignedUser().getId());
        }

        return savedTaskDTO;
    }
}
