package com.makers.tableable.domain.repository;

import com.makers.tableable.domain.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageDomainRepository {

    List<MessageDTO> findAll();

    Optional<List<MessageDTO>> messagesWithGreatSatisfaction();

    Optional<List<MessageDTO>> messagesWithBadSatisfaction();

    MessageDTO save(MessageDTO message);

    void delete (int key);
}
