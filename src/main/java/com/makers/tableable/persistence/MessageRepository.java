package com.makers.tableable.persistence;

import com.makers.tableable.persistence.crud.MessageCrud;
import com.makers.tableable.persistence.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository // Semantic purposes to identify which java class is interacting with  the DB.
public class MessageRepository {

    private MessageCrud messageCrud;

    public List<Message> findAll(){
        return (List<Message>) messageCrud.findAll();
    }

    Optional<List<Message>> messagesWithGreatSatisfaction(){
        return messageCrud.findBySatisfactionGreaterThanOrderBySatisfactionAsc(3);
    }
    Optional<List<Message>> messagesWithBadSatisfaction(){
        return messageCrud.findBySatisfactionLessThanOrderBySatisfactionAsc(4);
    }


}
