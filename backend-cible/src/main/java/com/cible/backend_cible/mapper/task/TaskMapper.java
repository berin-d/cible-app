package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.TaskDTO;
import com.cible.backend_cible.model.task.Task;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.name", target = "statusName")
    @Mapping(source = "priority.id", target = "priorityId")
    @Mapping(source = "priority.name", target = "priorityName")
    @Mapping(source = "taskGroup.id", target = "taskGroupId")
    @Mapping(source = "taskGroup.name", target = "taskGroupName")
    TaskDTO toDto(Task task);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "priority", ignore = true)
    @Mapping(target = "taskGroup", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Task toEntity(TaskDTO dto);
}