package de.imunixx.api.mapper;

import de.imunixx.api.entity.User;
import de.imunixx.api.model.UserCreateDTO;
import de.imunixx.api.model.UserUpdateDTO;
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
    User toEntityFromCreateDto(UserCreateDTO createDTO);
    UserCreateDTO toCreateDto(User entity);
    User toEntityFromUpdateDto(UserUpdateDTO updateDTO);
    UserUpdateDTO toUpdateDto(User entity);
    List<User> toUserList(List<UserDTO> dtoList);
    List<UserDTO> toUserDtoList(List<User> entityList);
}
