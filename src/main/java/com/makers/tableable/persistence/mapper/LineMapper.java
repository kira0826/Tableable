package com.makers.tableable.persistence.mapper;

import com.makers.tableable.domain.LineDomain;
import com.makers.tableable.persistence.entity.Line;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LineMapper {

        //Here, we indicate how the conversions will be done.
        @Mappings({
                @Mapping(source = "boxingPosition", target = "boxingPosition"),
                @Mapping(source = "text", target = "text"),
                @Mapping(source = "confidence", target = "confidence"),
                @Mapping(source = "message", target = "message"),
        })
        LineDomain toLineDomain(Line line);

        @InheritInverseConfiguration
        @Mapping(target = "lineID", ignore = true)
        Line toMessage(LineDomain lineDomain);
}
