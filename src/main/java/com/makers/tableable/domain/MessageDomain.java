package com.makers.tableable.domain;

import com.makers.tableable.persistence.entity.Line;

import java.util.List;

public class MessageDomain {

    private Integer messageID;

    private Integer satisfaction;

    private List<Line> lines;

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

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
