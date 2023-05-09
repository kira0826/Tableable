package com.makers.tableable.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Used to generate the id in an automatic way.

    private Integer messageID;

    @Column(name = "satisfaction")
    private Integer satisfaction;

    @OneToMany(mappedBy = "message")
    private List<Line> lines;

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Integer getMessageID() {
        return messageID;
    }
    public List<Line> getLines() {
        return lines;
    }
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
