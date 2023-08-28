package de.imunixx.api.mapper;

import de.imunixx.api.entity.*;
import de.imunixx.api.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BackEndMapper {

    BackEndMapper MAPPER_INSTANCE = Mappers.getMapper(BackEndMapper.class);

    // User
    @Mapping(target = "userData.id", source = "userDataId")
    @Mapping(target = "userActivated.id", source = "userActivatedId")
    User toEntity(UserDTO dto);
    @Mapping(target = "userActivatedId", source = "userActivated.id")
    @Mapping(target = "userDataId", source = "userData.id")
    UserDTO toDto(User entity);
    List<User> toUserList(List<UserDTO> dtoList);
    List<UserDTO> toUserDtoList(List<User> entityList);

    // UserData
    @Mapping(target = "user.id", source = "userId")
    UserData toEntity(UserDataDTO dto);
    @Mapping(target = "userId", source = "user.id")
    UserDataDTO toDto(UserData entity);

    // UserActivated
    @Mapping(target = "user.id", source = "userId")
    UserActivated toEntity(UserActivatedDTO dto);
    @Mapping(target = "userId", source = "user.id")
    UserActivatedDTO toDto(UserActivated entity);

    // Profile
    @Mapping(target = "user.id", source = "userId")
    Profile toEntity(ProfileDTO dto);
    @Mapping(target = "userId", source = "user.id")
    ProfileDTO toDto(Profile entity);
    List<Profile> toProfileList(List<ProfileDTO> dtoList);
    List<ProfileDTO> toProfileDtoList(List<Profile> entityList);

    // Movement
    @Mapping(target = "profile.id", source = "profileId")
    @Mapping(target = "dateTime", expression = "java(DateUtils.offsetDateTimeToDate(dto.getDateTime()))")
    Movement toEntity(MovementDTO dto);
    @Mapping(target = "profileId", source = "profile.id")
    @Mapping(target = "dateTime", expression = "java(DateUtils.dateToOffsetDateTime(entity.getDateTime()))")
    MovementDTO toDto(Movement entity);
    List<Movement> toMovementList(List<MovementDTO> dtoList);
    List<MovementDTO> toMovementDtoList(List<Movement> entityList);

    // FixedMovement
    @Mapping(target = "profile.id", source = "profileId")
    @Mapping(target = "startDate", source = "dto.startDate")
    @Mapping(target = "endDate", source = "dto.endDate")
    @Mapping(target = "transactionFrequency", source = "dto.transactionFrequency")
    FixedMovement toEntity(FixedMovementDTO dto);
    @Mapping(target = "profileId", source = "profile.id")
    FixedMovementDTO toDto(FixedMovement entity);
    List<FixedMovement> toFixedMovementList(List<FixedMovementDTO> dtoList);
    List<FixedMovementDTO> toFixedMovementDtoList(List<FixedMovement> entityList);

    // SpendingExpectation
    @Mapping(target = "profile.id", source = "profileId")
    SpendingExpectation toEntity(SpendingExpectationDTO dto);
    @Mapping(target = "profileId", source = "profile.id")
    SpendingExpectationDTO toDto(SpendingExpectation entity);
    List<SpendingExpectation> toSpendingExpectationList(List<SpendingExpectationDTO> dtoList);
    List<SpendingExpectationDTO> toSpendingExpectationDtoList(List<SpendingExpectation> entityList);
    
    //Email
    @Mapping(target = "userData.id", source = "userDataId")
    Email toEntity(EmailDTO dto);
    @Mapping(target = "userDataId", source = "userData.id")
    EmailDTO toDto(Email entity);
    List<Email> toEmailList(List<EmailDTO> dtoList);
    List<EmailDTO> toEmailDtoList(List<Email> entityList);

    //Phone
    @Mapping(target = "userData.id", source = "userDataId")
    @Mapping(target = "prefix.id", source = "prefixId")
    Phone toEntity(PhoneDTO dto);
    @Mapping(target = "userDataId", source = "userData.id")
    @Mapping(target = "prefixId", source = "prefix.id")
    PhoneDTO toDto(Phone entity);
    List<Phone> toPhoneList(List<PhoneDTO> dtoList);
    List<PhoneDTO> toPhoneDtoList(List<Phone> entityList);

    //Prefix
    Prefix toEntity(PrefixDTO dto);
    PrefixDTO toDto(Prefix dto);

    List<Prefix> toPrefixList(List<PrefixDTO> dtoList);
    List<PrefixDTO> toPrefixDtoList(List<Prefix> entityList);

    default Date mapOffsetDateTimeToDate(OffsetDateTime offsetDateTime) {
        return DateUtils.offsetDateTimeToDate(offsetDateTime);
    }

    default OffsetDateTime mapDateToOffsetDateTime(Date date) {
        return DateUtils.dateToOffsetDateTime(date);
    }
}
