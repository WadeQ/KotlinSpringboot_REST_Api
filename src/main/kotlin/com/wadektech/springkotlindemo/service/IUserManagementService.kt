package com.wadektech.springkotlindemo.service

import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse


interface IUserManagementService {

    fun findUserById(userId: Int) : UserResponse?

    fun findAllUsers() : List<UserResponse>

    fun saveUser(addUserRequest: AddUserRequest) : UserResponse

    fun updateUser(updateUserRequest: UpdateUserRequest) : UserResponse

    fun deleteUserById(userId : Int)
}