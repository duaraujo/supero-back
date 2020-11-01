package com.superoback.model;

import lombok.Getter;

public enum StatusEnum {
    TODO(0),
    DOING(1),
    DONE(2);

    @Getter
    private int value;

    StatusEnum(int value) {
        this.value = value;
    }
}
