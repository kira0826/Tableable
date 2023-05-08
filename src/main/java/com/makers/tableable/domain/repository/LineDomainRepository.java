package com.makers.tableable.domain.repository;

import com.makers.tableable.domain.LineDomain;
import com.makers.tableable.persistence.entity.LineMessagePK;
import java.util.*;


public interface LineDomainRepository {

    List<LineDomain> getAll();

    Optional<List<LineDomain>> reliableLines();

    Optional<List<LineDomain>> notReliableLines();

    LineDomain save(LineDomain line);

    void delete (LineMessagePK key);

}
