package com.cible.backend_cible.mapper.year;

import com.cible.backend_cible.model.dtos.year.YearDTO;
import com.cible.backend_cible.model.year.Year;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface YearMapper {
    YearMapper INSTANCE = Mappers.getMapper(YearMapper.class);
    @Mapping(source = "user.id", target = "userId")
    YearDTO toDTO(Year year);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    Year toEntity(YearDTO dto);
}
