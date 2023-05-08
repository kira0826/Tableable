package com.makers.tableable.persistence.entity;

import jakarta.persistence.*;
import org.springframework.context.MessageSource;

@Entity
@Table(name = "lines")
public class Line {

    @EmbeddedId
    private LineMessagePK lineID;

    private String text;

    @Column(name = "boxingPosition", columnDefinition = "integer[]")
    private Integer[]  boxingPosition;

    @ManyToOne
    @JoinColumn(name = "lineID.getMessageID()", insertable = false, updatable = false)
    private Message message;

    @Column(name = "confidence")
    private Double confidence;


    public LineMessagePK getLineID() {
        return lineID;
    }

    public void setLineID(LineMessagePK lineID) {
        this.lineID = lineID;
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
