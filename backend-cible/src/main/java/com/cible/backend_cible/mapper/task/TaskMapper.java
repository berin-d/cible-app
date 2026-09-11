package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.task.TaskDTO;
import com.cible.backend_cible.model.task.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.name", target = "statusName")
    @Mapping(source = "priority.id", target = "priorityId")
    @Mapping(source = "priority.name", target = "priorityName")
    @Mapping(source = "goal.id", target = "goalId")
    @Mapping(source = "goal.name", target = "goalName")
    TaskDTO toDto(Task task);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "priority", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "goalId", target = "goal.id")
    Task toEntity(TaskDTO dto);
}