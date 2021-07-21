package com.wadektech.springkotlindemo.mapper

import com.wadektech.springkotlindemo.domain.User
import com.wadektech.springkotlindemo.dto.AddUserRequest
import org.springframework.stereotype.Component


@Component
class AddUserRequestMapper : IMapperContract<AddUserRequest , User> {

    override fun mapToDomain(entity: AddUserRequest): User {
        return User(
            username = entity.username,
            email = entity.email
        )
    }

}