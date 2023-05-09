package com.makers.tableable.persistence.entity;

import jakarta.persistence.AttributeConverter;

public class IntegerArrayConverter implements AttributeConverter<Integer[],Integer[]> {

    @Override
    public Integer[] convertToDatabaseColumn(Integer[] attribute) {
        if (attribute == null) return null;
        return attribute;
    }

    @Override
    public Integer[] convertToEntityAttribute(Integer[] dbData) {
        if (dbData == null) return null;
        return dbData;
    }
}
