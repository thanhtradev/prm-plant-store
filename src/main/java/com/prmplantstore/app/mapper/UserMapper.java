package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.UserDto;
import com.prmplantstore.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityDtoMapper<UserDto, User>{
}
