package com.makers.tableable.domain.repository;

import com.makers.tableable.domain.LineDTO;
import com.makers.tableable.persistence.entity.LineMessagePK;
import java.util.*;


public interface LineDomainRepository {

    List<LineDTO> getAll();

    Optional<List<LineDTO>> reliableLines();

    Optional<List<LineDTO>> notReliableLines();

    LineDTO save(LineDTO line);

    void delete (LineMessagePK key);

}
