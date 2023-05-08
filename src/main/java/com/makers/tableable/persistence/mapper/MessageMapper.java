package com.makers.tableable.persistence.mapper;

import com.makers.tableable.domain.MessageDTO;
import com.makers.tableable.persistence.entity.Message;
import org.mapstruct.*;

import java.util.List;

// ComponentModel is used to define a connection with Spring.
@Mapper(componentModel = "spring",  uses = {LineMapper.class})
public interface MessageMapper {

//Here, we indicate how the conversions will be done.
    @Mappings({
            @Mapping(source = "messageID", target = "messageID"),
            @Mapping(source = "satisfaction", target = "satisfaction"),
            @Mapping(source = "lines", target = "lines")
    })
    MessageDTO toMessageDomain(Message message);
    List<MessageDTO> toMessageDomainList(List<Message> messageList);

    @InheritInverseConfiguration
    Message toMessage(MessageDTO messageDTO);
}
