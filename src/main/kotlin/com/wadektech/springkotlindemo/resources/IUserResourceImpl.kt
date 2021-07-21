package com.wadektech.springkotlindemo.resources

import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse
import com.wadektech.springkotlindemo.resources.IUserResourceImpl.Companion.BASE_URL
import com.wadektech.springkotlindemo.service.IUserManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [BASE_URL]) //specifies the path
class IUserResourceImpl(
    private val userManagementService: IUserManagementService
) : IUserResource {
    override fun findUserById(userId: Int): ResponseEntity<UserResponse?> {
        TODO("Not yet implemented")
    }

    override fun findAllUsers(): ResponseEntity<List<UserResponse>> {
        TODO("Not yet implemented")
    }

    override fun saveUser(addUserRequest: AddUserRequest): ResponseEntity<UserResponse?> {
        TODO("Not yet implemented")
    }

    override fun updateUser(updateUserRequest: UpdateUserRequest): ResponseEntity<UserResponse?> {
        TODO("Not yet implemented")
    }

    override fun deleteUserById(userId: Int): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    companion object {
        const val BASE_URL = "/demo/api/v1/user"
    }
}