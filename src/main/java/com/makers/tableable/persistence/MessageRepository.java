package com.makers.tableable.persistence;

import com.makers.tableable.domain.MessageDTO;
import com.makers.tableable.domain.repository.MessageDomainRepository;
import com.makers.tableable.persistence.crud.MessageCrud;
import com.makers.tableable.persistence.entity.Message;
import com.makers.tableable.persistence.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository // Semantic purposes to identify which java class is interacting with  the DB.
public class MessageRepository implements MessageDomainRepository {

    private MessageCrud messageCrud;
    private MessageMapper mapper;

    @Autowired
    public MessageRepository(MessageCrud messageCrud, MessageMapper mapper) {
        this.messageCrud = messageCrud;
        this.mapper = mapper;
    }

    public List<MessageDTO> findAll(){

        return mapper.toMessageDomainList( (List<Message>) messageCrud.findAll());
    }

    public Optional<List<MessageDTO>> messagesWithGreatSatisfaction(){
        Optional<List<Message>> messageList = messageCrud.findBySatisfactionGreaterThanOrderBySatisfactionAsc(3);
        return messageList.map(messageList1 -> mapper.toMessageDomainList(messageList1));

    }
    public Optional<List<MessageDTO>> messagesWithBadSatisfaction(){
        Optional<List<Message>> messageList =messageCrud.findBySatisfactionLessThanOrderBySatisfactionAsc(4);
        return messageList.map(messageList1 -> mapper.toMessageDomainList(messageList1));
    }


    @Override
    public MessageDTO save(MessageDTO message) {
        Message messageRepository = mapper.toMessage(message);
        return mapper.toMessageDomain(messageCrud.save(messageRepository));
    }

    public void delete (int key){
        messageCrud.deleteById(key);
    }


}
