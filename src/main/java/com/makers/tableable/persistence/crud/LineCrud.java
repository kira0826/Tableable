package com.makers.tableable.persistence.crud;

import com.makers.tableable.persistence.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LineCrud extends CrudRepository<Line, LineMessagePK> {

    //We are using optional in order to manage possible nulls responses.

    Optional<List<Line>> findByConfidenceGreaterThanEqualOrderByConfidenceAsc(double confidence);
    Optional<List<Line>> findByConfidenceLessThanOrderByConfidenceAsc(double confidence);

}
