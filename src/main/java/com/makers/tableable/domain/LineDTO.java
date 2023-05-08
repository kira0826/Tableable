package com.makers.tableable.domain;

import com.makers.tableable.persistence.entity.LineMessagePK;
import com.makers.tableable.persistence.entity.Message;

public class LineDTO {

    private Integer[]  boxingPosition;

    private String text;

    private Double confidence;

    private Message message;

    private LineMessagePK lineID;

    public Integer[] getBoxingPosition() {
        return boxingPosition;
    }

    public void setBoxingPosition(Integer[] boxingPosition) {
        this.boxingPosition = boxingPosition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public LineMessagePK getLineID() {
        return lineID;
    }

    public void setLineID(LineMessagePK lineID) {
        this.lineID = lineID;
    }
}
