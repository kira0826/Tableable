package com.makers.tableable.persistence.crud;

import com.makers.tableable.persistence.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageCrud extends CrudRepository<Message, Integer> {

    Optional<List<Message>> findBySatisfactionGreaterThanOrderBySatisfactionAsc(int satisfaction);
    Optional<List<Message>> findBySatisfactionLessThanOrderBySatisfactionAsc(int satisfaction);

}
