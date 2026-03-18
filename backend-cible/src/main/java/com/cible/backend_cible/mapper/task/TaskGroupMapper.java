package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface TaskGroupMapper {
    TaskGroupMapper INSTANCE = Mappers.getMapper(TaskGroupMapper.class);
    
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "tasks", target = "tasks")
    TaskGroupDTO toDTO(TaskGroup taskGroup);

    @Mapping(source = "userId", target = "user.id")
    TaskGroup toEntity(TaskGroupDTO dto);
}
