package br.com.arcelino.webfluxcourse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.arcelino.webfluxcourse.entity.User;
import br.com.arcelino.webfluxcourse.model.request.UserRequest;
import br.com.arcelino.webfluxcourse.model.response.UserResponse;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest userRequest);

    UserResponse toResponse(final User user);
}
