package de.imunixx.api.mapper;

import de.imunixx.api.entity.Address;
import de.imunixx.api.entity.User;
import de.imunixx.api.entity.UserData;
import de.imunixx.api.model.AddressDTO;
import de.imunixx.api.model.UserDTO;
import de.imunixx.api.model.UserDataDTO;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BackEndMapper {

    BackEndMapper MAPPER_INSTANCE = Mappers.getMapper(BackEndMapper.class);

    @Mapping(target = "userData.id", source = "userDataId")
    User toEntity(UserDTO dto);
    
    @InheritInverseConfiguration
    UserDTO toDto(User entity);
    
    List<User> toUserList(List<UserDTO> dtoList);
    List<UserDTO> toUserDtoList(List<User> entityList);
    
    
    @Mapping(target = "user.id", source = "userId")
    UserData toEntity(UserDataDTO dto);
    
    @InheritInverseConfiguration
    UserDataDTO toDto(UserData entity);
    
    @AfterMapping
    default void backlinkJPA(@MappingTarget UserData entity) {
        entity.getAddressList().forEach(child -> child.setUserData(entity));
        entity.getEmailList().forEach(child -> child.setUserData(entity));
        entity.getPhoneList().forEach(child -> child.setUserData(entity));
    }
    
    @Mapping(target = "userData.id", source = "userDataId")
    @Mapping(target = "country.id", source = "countryId")        
    @Mapping(target = "state.id", source = "stateId")
    @Mapping(target = "city.id", source = "cityId")
    @Mapping(target = "street.id", source = "streetId")       
    Address toEntity(AddressDTO dto);
    
    @InheritInverseConfiguration
    AddressDTO toDto(Address entity);
    
    List<Address> toAddressList(List<AddressDTO> dtoList);
    List<AddressDTO> toAddressDtoList(List<Address> entityList);
    
    /*
    @Mapping(target = "street.id", source = "streetId")       
    Email toEntity(EmailDTO dto);
    
    @InheritInverseConfiguration
    EmailDTO toDto(Email entity);
    */
    
    //User toEntityFromCreateDto(UserCreateDTO createDTO);
    //UserCreateDTO toCreateDto(User entity);
    //User toEntityFromUpdateDto(UserUpdateDTO updateDTO);
    //UserUpdateDTO toUpdateDto(User entity);
    
}
