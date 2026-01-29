package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.TaskAssignmentDTO;
import com.cible.backend_cible.model.task.TaskAssignment;

@Mapper
public interface TaskAssignmentMapper {

    TaskAssignmentMapper INSTANCE = Mappers.getMapper(TaskAssignmentMapper.class);

    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "assignedBy.id", target = "assignedById")
    @Mapping(source = "assignedBy.username", target = "assignedByName")
    TaskAssignmentDTO toDTO(TaskAssignment taskAssignment);

    @Mapping(target = "task", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "assignedBy", ignore = true)
    @Mapping(target = "assignedAt", ignore = true)
    TaskAssignment toEntity(TaskAssignmentDTO dto);
} 
