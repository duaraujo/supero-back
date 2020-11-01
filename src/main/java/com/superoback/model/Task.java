package com.superoback.model;

import com.superoback.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    protected StatusEnum statusEntity;

    public TaskDTO toDTO() {
        TaskDTO dto = new TaskDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setStatusEnum(statusEntity);
        return dto;
    }

    public TaskDTO toDTOEdit() {
        TaskDTO dto = new TaskDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setStatusEnum(statusEntity);
        dto.setDescription(description);
        return dto;
    }

}
