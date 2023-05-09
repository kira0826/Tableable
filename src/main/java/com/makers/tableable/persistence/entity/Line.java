package com.makers.tableable.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "lines")
public class Line {

    @Id
    @Column(name = "id")
    private Integer lineID;

    @Column(name = "messageID")
    private Integer messageID;
    private String text;



    @Column(name = "boxingPosition", columnDefinition = "integer[]")
    @Convert(converter = IntegerArrayConverter.class)
    private Integer[]  boxingPosition;
    @ManyToOne
    @JoinColumn(name = "messageID", insertable = false, updatable = false)
    private Message message;

    @Column(name = "confidence")
    private Double confidence;



    public Integer getLineID() {
        return lineID;
    }

    public void setLineID(Integer lineID) {
        this.lineID = lineID;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer[] getBoxingPosition() {
        return boxingPosition;
    }

    public void setBoxingPosition(Integer[] boxingPosition) {
        this.boxingPosition = boxingPosition;
    }
    public Double getConfidence() {
        return confidence;
    }
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
