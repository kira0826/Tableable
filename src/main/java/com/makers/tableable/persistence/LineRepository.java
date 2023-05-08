package com.makers.tableable.persistence;

import com.makers.tableable.persistence.crud.LineCrud;
import com.makers.tableable.persistence.entity.Line;

import java.util.List;
import java.util.Optional;

public class LineRepository {

    private LineCrud lineCrud;

    public List<Line> getAll(){
        return (List<Line>) lineCrud.findAll();
    }

    public Optional<List<Line>> reliableLines(){
        return lineCrud.findByConfidenceGreaterThanEqualOrderByConfidenceAsc(0.8);
    }
    public Optional<List<Line>> notReliableLines(){
        return lineCrud.findByConfidenceLessThanOrderByConfidenceAsc(0.5);
    }
}
