package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;

@Mapper
public interface TaskGroupMapper {

    TaskGroupMapper INSTANCE = Mappers.getMapper(TaskGroupMapper.class);

    TaskGroupDTO toDTO(TaskGroup taskGroup);

}

