package com.makers.tableable.persistence.mapper;

import com.makers.tableable.domain.LineDTO;
import com.makers.tableable.persistence.entity.Line;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LineMapper {

        //Here, we indicate how the conversions will be done.
        @Mappings({
                @Mapping(source = "boxingPosition", target = "boxingPosition"),
                @Mapping(source = "text", target = "text"),
                @Mapping(source = "confidence", target = "confidence"),
                @Mapping(source = "message", target = "message"),
                @Mapping(source = "lineID", target = "lineID")

        })
        LineDTO toLineDomain(Line line);
        List<LineDTO> toLinesDTO(List<Line> lines);

        @InheritInverseConfiguration
        Line toLineRepository(LineDTO lineDTO);
}
