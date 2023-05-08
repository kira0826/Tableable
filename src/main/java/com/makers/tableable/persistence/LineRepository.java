package com.makers.tableable.persistence;

import com.makers.tableable.domain.LineDTO;
import com.makers.tableable.domain.repository.LineDomainRepository;
import com.makers.tableable.persistence.crud.LineCrud;
import com.makers.tableable.persistence.entity.Line;
import com.makers.tableable.persistence.entity.LineMessagePK;
import com.makers.tableable.persistence.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Repository // Semantic purposes to identify which java class is interacting with  the DB.
public class LineRepository implements LineDomainRepository {

    private LineCrud lineCrud;
    private LineMapper mapper;

    @Autowired
    public LineRepository(LineCrud lineCrud, LineMapper mapper) {
        this.lineCrud = lineCrud;
        this.mapper = mapper;
    }

    public List<LineDTO> getAll(){

        List<Line> lines = (List<Line>) lineCrud.findAll();
        return mapper.toLinesDTO(lines) ;
    }

    public Optional<List<LineDTO>> reliableLines(){
        Optional<List<Line>> optionalLines = lineCrud.findByConfidenceGreaterThanEqualOrderByConfidenceAsc(0.8);
        return optionalLines.map(lines -> mapper.toLinesDTO(lines) );
    }
    public Optional<List<LineDTO>> notReliableLines(){
        Optional<List<Line>> optionalLines = lineCrud.findByConfidenceLessThanOrderByConfidenceAsc(0.5);
        return optionalLines.map(lines -> mapper.toLinesDTO(lines));
    }

    public LineDTO save(LineDTO line) {
        Line line1 = mapper.toLineRepository(line);
        return mapper.toLineDomain(lineCrud.save(line1));
    }
    public void delete (LineMessagePK key){
        lineCrud.deleteById(key);
    }
}
