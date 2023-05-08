package com.makers.tableable.domain.repository;

import com.makers.tableable.domain.MessageDomain;
import com.makers.tableable.persistence.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageDomainRepository {

    List<MessageDomain> findAll();

    Optional<List<MessageDomain>> messagesWithGreatSatisfaction();

    Optional<List<MessageDomain>> messagesWithBadSatisfaction();

    MessageDomain save(MessageDomain message);

    void delete (int key);
}
