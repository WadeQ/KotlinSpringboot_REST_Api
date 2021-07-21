package com.wadektech.springkotlindemo.utils

import com.wadektech.springkotlindemo.domain.User
import com.wadektech.springkotlindemo.dto.UserResponse

fun User?.toUserResponse() : UserResponse{
    return UserResponse(
        id = this?.id ?: 1,
        username = this?.username ?: "John Doe",
        email = this?.email ?: "jdoe@gmail.com"
    )
}