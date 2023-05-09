package com.makers.tableable.domain.repository;

import com.makers.tableable.domain.LineDTO;

import java.util.*;


public interface LineDomainRepository {

    List<LineDTO> getAll();

    Optional<List<LineDTO>> reliableLines();

    Optional<List<LineDTO>> notReliableLines();

    LineDTO save(LineDTO line);

    void delete (Integer key);

}
