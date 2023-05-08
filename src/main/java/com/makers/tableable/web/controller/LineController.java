package com.makers.tableable.web.controller;

import com.makers.tableable.domain.LineDTO;
import com.makers.tableable.domain.service.LineDTOService;
import com.makers.tableable.persistence.entity.LineMessagePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lines")
public class LineController {

    private LineDTOService lineDTOService;

    @Autowired
    public LineController(LineDTOService lineDTOService) {
        this.lineDTOService = lineDTOService;
    }

    @GetMapping("/all")
    public List<LineDTO> getAll(){
        return lineDTOService.getAll();
    }

    @GetMapping("/reliableLines")
    public Optional<List<LineDTO>> getReliableLines(){
        return lineDTOService.reliableLines();
    }

    @GetMapping("/faultyLines")
    public Optional<List<LineDTO>> getNotReliableLines(){
        return lineDTOService.notReliableLines();
    }
    @PostMapping("/save")
    public LineDTO save(LineDTO line){
        return lineDTOService.save(line);
    }
    @DeleteMapping("/delete")
    public void delete(LineMessagePK key){
        lineDTOService.delete(key);
    }

}
