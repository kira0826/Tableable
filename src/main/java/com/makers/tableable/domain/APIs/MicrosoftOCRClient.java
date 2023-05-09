package com.makers.tableable.domain.APIs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

@Component
public class MicrosoftOCRClient {

    static final String  ENDPOINT = "https://mathematicalexpressionrecognizer.cognitiveservices.azure.com/vision/v3.2/read/analyze";
    static final String KEY = "f43bfd405ab54f43adb0a886a742f2e1";

    public String postImage(File file){

        HttpClient httpclient = HttpClients.createDefault();
        String  obtained = "";

        try{
            URIBuilder builder = new URIBuilder(ENDPOINT);
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            //Request Parameters:

            request.setHeader("Content-Type", "application/octet-stream"); // Set bytes conversion.
            request.setHeader("Ocp-Apim-Subscription-Key", KEY);

            //Convert File: png or jpeg

            FileInputStream fileInputStream = new FileInputStream(file);
            byte [] imageConversion = new byte[(int) file.length()];
            fileInputStream.read(imageConversion);
            fileInputStream.close();

            //Create request

            ByteArrayEntity reqEntity = new ByteArrayEntity(imageConversion);
            request.setEntity(reqEntity);

            //Execute Response
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() == 202){
                Header[] headers = response.getHeaders("Operation-Location");
                String getEndpoint = headers[0].getValue();
                 obtained =  getEndpoint;
            }else obtained = "-1";

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return obtained;
    }

    public JsonNode getImageMessage(String message){

        HttpClient httpclient = HttpClients.createDefault();
        JsonNode messageJson = null;

        try{
            URIBuilder builder = new URIBuilder(message);


            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", KEY);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() == 200){
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(EntityUtils.toString(entity));
                JsonNode linesNode = rootNode.get("analyzeResult").get("readResults").get(0).get("lines");
                messageJson = linesNode;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return messageJson;
    }
}
