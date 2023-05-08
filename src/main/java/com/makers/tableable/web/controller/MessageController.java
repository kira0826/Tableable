package com.makers.tableable.web.controller;

import com.makers.tableable.domain.MessageDTO;
import com.makers.tableable.domain.service.MessageDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageDTOService messageDTOService;

    @Autowired
    public MessageController(MessageDTOService messageDTOService) {
        this.messageDTOService = messageDTOService;
    }

    @GetMapping("/all")
    public List<MessageDTO> getAll(){
        return messageDTOService.getAll();
    }

    @GetMapping("/greatMessages")

    public Optional<List<MessageDTO>> getGreatMessages(){
        return messageDTOService.messagesWithGreatSatisfaction();
    }
    @GetMapping("/badMessages")

    public Optional<List<MessageDTO>> getBadMessages(){
        return messageDTOService.messagesWithBadSatisfaction();
    }
    @PostMapping("/saveMessage")
    public MessageDTO save(MessageDTO message){
        return messageDTOService.save(message);
    }
    @DeleteMapping("/deleteMessage")
    public void delete(int key){
        messageDTOService.delete(key);
    }

}
