package com.superoback.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Task {

    @Id
    private Long id;
    private String description;

}
