package com.makers.tableable.domain;

import com.makers.tableable.persistence.entity.Line;

import java.util.List;

public class MessageDTO {

    private Integer messageID;

    private Integer satisfaction;

    private List<LineDTO> lines;

    public MessageDTO() {
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public List<LineDTO> getLines() {
        return lines;
    }

    public void setLines(List<LineDTO> lines) {
        this.lines = lines;
    }
}
