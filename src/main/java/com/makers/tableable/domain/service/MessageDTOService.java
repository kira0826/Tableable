package com.makers.tableable.domain.service;

import com.makers.tableable.domain.MessageDTO;
import com.makers.tableable.domain.repository.MessageDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageDTOService {

    private MessageDomainRepository  messageDomainRepository;

    @Autowired
    public MessageDTOService(MessageDomainRepository messageDomainRepository) {
        this.messageDomainRepository = messageDomainRepository;
    }


    public List<MessageDTO> getAll(){
        return messageDomainRepository.findAll();
    }
    public Optional<List<MessageDTO>> messagesWithGreatSatisfaction(){
        return  messageDomainRepository.messagesWithGreatSatisfaction();
    }

    public Optional<List<MessageDTO>> messagesWithBadSatisfaction(){
        return  messageDomainRepository.messagesWithBadSatisfaction();
    }

    public MessageDTO save(MessageDTO message){
        return messageDomainRepository.save(message);
    }

    public void delete(int key){
        messageDomainRepository.delete(key);
    }
}
