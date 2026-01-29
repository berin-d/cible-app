package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.PriorityDTO;
import com.cible.backend_cible.model.task.Priority;

@Mapper
public interface PriorityMapper {

    PriorityMapper INSTANCE = Mappers.getMapper(PriorityMapper.class);

    PriorityDTO toDto(Priority priority);

    Priority toEntity(PriorityDTO dto);
}