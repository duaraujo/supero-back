package com.superoback.dto;

import com.superoback.model.StatusEnum;
import com.superoback.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private StatusEnum statusEnum;

    public Task toModel() {
        Task task = new Task();
        task.setId(this.id);
        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setStatusEntity(this.statusEnum);
        return task;
    }

}
