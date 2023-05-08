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
}
