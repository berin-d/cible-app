package com.cible.backend_cible.mapper.system;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.system.SettingsDTO;
import com.cible.backend_cible.model.system.Settings;

@Mapper
public interface SettingsMapper {

    SettingsMapper INSTANCE = Mappers.getMapper(SettingsMapper.class);

    @Mapping(source = "user.id", target = "userId")
    SettingsDTO toDto(Settings settings);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Settings toEntity(SettingsDTO dto);
}
