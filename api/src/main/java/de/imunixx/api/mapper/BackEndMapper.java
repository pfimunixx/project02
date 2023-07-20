package de.imunixx.api.mapper;

import de.imunixx.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import de.imunixx.api.model.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BackEndMapper {

    BackEndMapper MAPPER_INSTANCE = Mappers.getMapper(BackEndMapper.class);

    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);
    List<User> toUserList(List<UserDTO> dtoList);
    List<UserDTO> toUserDtoList(List<User> entityList);
}
