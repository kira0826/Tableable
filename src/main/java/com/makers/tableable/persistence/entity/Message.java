package com.makers.tableable.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Used to generate the id in an automatic way.
    @Column(name = "id")

    private int messageID;

    private int satisfaction;

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getMessageID() {
        return messageID;
    }
}
