package com.makers.tableable.web.controller;

import com.makers.tableable.domain.service.MessageDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageDTOService messageDTOService;

    @Autowired
    public MessageController(MessageDTOService messageDTOService) {
        this.messageDTOService = messageDTOService;
    }

}
