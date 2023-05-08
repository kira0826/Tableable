package com.makers.tableable.persistence.entity;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.List;

@Entity
@Table(name = "messages")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Used to generate the id in an automatic way.
    @Column(name = "id")

    private Integer messageID;

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
}
