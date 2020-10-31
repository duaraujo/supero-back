package com.superoback.model;

import com.superoback.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public TaskDTO toDTO() {
        TaskDTO dto = new TaskDTO();
        dto.setId(this.id);
        dto.setDescription(this.description);
        dto.setTitle(this.title);
        return dto;
    }

}
