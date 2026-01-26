package com.cible.backend_cible.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.task.UserDTO;
import com.cible.backend_cible.model.task.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);   
}
