package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.ActivityDTO;
import com.cible.backend_cible.model.task.Activity;

@Mapper
public interface ActivityMapper {

    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);

    @Mapping(source = "user.id", target = "userId")
    ActivityDTO toDto(Activity activity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Activity toEntity(ActivityDTO dto);
}