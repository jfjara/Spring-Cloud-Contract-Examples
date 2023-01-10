package com.jfjara.farm.domain.dto;

public enum AnimalTypeDto {

    COW("COW"),
    CHICKEN("CHICKEN"),
    PIG("PIG");

    AnimalTypeDto(final String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

}
