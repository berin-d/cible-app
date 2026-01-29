package com.cible.backend_cible.mapper.system;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cible.backend_cible.model.dtos.system.NotificationDTO;
import com.cible.backend_cible.model.system.Notification;

@Mapper
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(source = "user.id", target = "userId")
    NotificationDTO toDto(Notification notification);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Notification toEntity(NotificationDTO dto);
}