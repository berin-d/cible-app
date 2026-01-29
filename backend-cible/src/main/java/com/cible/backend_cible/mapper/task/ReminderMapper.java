package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.ReminderDTO;
import com.cible.backend_cible.model.task.Reminder;

@Mapper
public interface ReminderMapper {

    ReminderMapper INSTANCE = Mappers.getMapper(ReminderMapper.class);

    @Mapping(source = "task.id", target = "taskId")
    ReminderDTO toDto(Reminder reminder);

    @Mapping(target = "task", ignore = true)
    Reminder toEntity(ReminderDTO dto);
}
