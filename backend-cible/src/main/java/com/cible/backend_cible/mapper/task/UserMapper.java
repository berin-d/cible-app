package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.task.UserDTO;
import com.cible.backend_cible.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);   
}
