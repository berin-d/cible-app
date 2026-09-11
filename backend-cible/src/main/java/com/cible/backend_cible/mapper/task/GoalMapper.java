package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.year.Year;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GoalMapper {
    GoalMapper INSTANCE = Mappers.getMapper(GoalMapper.class);


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "tasks", target = "tasks")
    @Mapping(source = "year.year", target = "year")
    GoalDTO toDTO(Goal goal);

    @Mapping(target = "year", ignore = true)
    @Mapping(source = "userId", target = "user.id")
    Goal toEntity(GoalDTO dto);

}
