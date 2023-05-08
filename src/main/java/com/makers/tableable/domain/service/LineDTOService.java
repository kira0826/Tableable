package com.makers.tableable.domain.service;

import com.makers.tableable.domain.LineDTO;
import com.makers.tableable.domain.repository.LineDomainRepository;
import com.makers.tableable.persistence.entity.LineMessagePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineDTOService {

    private LineDomainRepository lineDomainRepository;
    @Autowired
    public LineDTOService(LineDomainRepository lineDomainRepository) {
        this.lineDomainRepository = lineDomainRepository;
    }

    public List<LineDTO> getAll(){
        return lineDomainRepository.getAll();
    }

    public Optional<List<LineDTO>> reliableLines(){
        return lineDomainRepository.reliableLines();
    }
    public Optional<List<LineDTO>> notReliableLines(){
        return lineDomainRepository.notReliableLines();
    }
    public LineDTO save(LineDTO line){
        return lineDomainRepository.save(line);
    }
    public void delete(LineMessagePK key){
        lineDomainRepository.delete(key);
    }


}
