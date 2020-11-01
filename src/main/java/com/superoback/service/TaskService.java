package com.superoback.service;

import com.superoback.dto.TaskDTO;
import com.superoback.model.StatusEnum;
import com.superoback.model.Task;
import com.superoback.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public List<TaskDTO> findAll() {
        return StreamSupport.stream(taskRepository.findAll(Sort.by("title")).spliterator(), false).map(Task::toDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO findOne(Long id) {
        return taskRepository.getOne(id).toDTOEdit();
    }

    public TaskDTO save(Task task) {
        task.setStatusEntity(task.getStatusEntity() != null ? task.getStatusEntity() : StatusEnum.TODO );
        return taskRepository.save(task).toDTO();
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
