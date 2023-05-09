package com.makers.tableable.domain.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.makers.tableable.domain.APIs.MicrosoftOCRClient;
import com.makers.tableable.domain.LineDTO;
import com.makers.tableable.domain.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class TableableService {
    private MicrosoftOCRClient microsoftOCRClient;

    @Autowired
    public TableableService(MicrosoftOCRClient microsoftOCRClient) {
        this.microsoftOCRClient = microsoftOCRClient;
    }

    public String getTableFormat(File image){
        String endPoint = microsoftOCRClient.postImage(image);

        if (!(endPoint.equals("-1"))){

            JsonNode jsonMessage = microsoftOCRClient.getImageMessage(endPoint);

            return null;

        }else return "Can not create table format, please try again.";
    }

    public String createMessageDTO(JsonNode jsonMessage){

        JsonNode linesNode = jsonMessage.get("analyzeResult").get("readResults").get(0).get("lines");
        MessageDTO messageDTO = new MessageDTO();
        List<LineDTO> linesDTO = new ArrayList<>();

        for (JsonNode insideNode: linesNode
             ) {
            LineDTO temLineDTO = new LineDTO();

            Integer []  numericCoordinates = null;

            //BoundingBox deserializer.

            temLineDTO.setBoxingPosition(boundingBoxDeserializer(linesNode.get("boundingBox")));

            //Confidence deserializer.
            temLineDTO.setConfidence(confidenceDeserializer(linesNode.get("words")));

            //Text deserializer.
            temLineDTO.setText(insideNode.get("boundingBox").get("text").asText());

            linesDTO.add(temLineDTO);
        }

        messageDTO.setLines(linesDTO);

        return createReport(linesDTO);
    }

    private Integer[] boundingBoxDeserializer(JsonNode node){

        Integer [] numericCoordinates = null;
        if (node.isArray()){

            String coordinates = node.asText();
            coordinates.replace("[","");
            coordinates.replace("]","");

            String [] coordinatesArray = coordinates.split(",");
            numericCoordinates = new Integer[coordinatesArray.length];

            for (int i = 0; i < coordinatesArray.length; i++) numericCoordinates[i] = Integer.parseInt(coordinatesArray[0]);
        }
        return numericCoordinates;
    }

    private Double confidenceDeserializer(JsonNode node){
        Double confidence = null;
        int counter = 0;
        for (JsonNode wordNode: node
        ) {
            confidence+=wordNode.get("confidence").asDouble();
            counter++;
        }
        confidence = counter!= 0? confidence / counter: null;
        return confidence;
    }

    private String createReport(List<LineDTO> linesDTO){

        String report = "";

        for (LineDTO lineDTO: linesDTO
             ) {
            report += lineDTO.getText() + "\n";
        }

        return report;
    }

    public MicrosoftOCRClient getMicrosoftOCRClient() {
        return microsoftOCRClient;
    }

    public void setMicrosoftOCRClient(MicrosoftOCRClient microsoftOCRClient) {
        this.microsoftOCRClient = microsoftOCRClient;
    }
}
