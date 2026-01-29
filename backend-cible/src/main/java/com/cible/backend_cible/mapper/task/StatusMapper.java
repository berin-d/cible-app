package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.StatusDTO;
import com.cible.backend_cible.model.task.Status;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    StatusDTO toDto(Status status);

    Status toEntity(StatusDTO dto);
}
