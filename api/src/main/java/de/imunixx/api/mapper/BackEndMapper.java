package de.imunixx.api.mapper;

import de.imunixx.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import de.imunixx.api.model.UserDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BackEndMapper {

    BackEndMapper MAPPER_INSTANCE = Mappers.getMapper(BackEndMapper.class);

    User toEntity(UserDTO dto);
    User toDto(User entity);
}
