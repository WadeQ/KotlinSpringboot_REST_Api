package com.wadektech.springkotlindemo.service

import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface IUserManagementService {

    fun findUserById(userId: Int) : UserResponse?

    fun findAllUsers(pageable: Pageable) : Page<UserResponse>

    fun saveUser(addUserRequest: AddUserRequest) : UserResponse

    fun updateUser(updateUserRequest: UpdateUserRequest) : UserResponse

    fun deleteUserById(userId : Int)
}