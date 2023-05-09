package com.makers.tableable.domain.service;

import com.makers.tableable.domain.APIs.MicrosoftOCRClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableableService {

    private MicrosoftOCRClient microsoftOCRClient;

    @Autowired
    public TableableService(MicrosoftOCRClient microsoftOCRClient) {
        this.microsoftOCRClient = microsoftOCRClient;
    }
    
    public MicrosoftOCRClient getMicrosoftOCRClient() {
        return microsoftOCRClient;
    }

    public void setMicrosoftOCRClient(MicrosoftOCRClient microsoftOCRClient) {
        this.microsoftOCRClient = microsoftOCRClient;
    }
}
