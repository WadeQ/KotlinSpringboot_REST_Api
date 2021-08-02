package com.wadektech.springkotlindemo.service

import com.wadektech.springkotlindemo.dao.IUserDao
import com.wadektech.springkotlindemo.domain.User
import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse
import com.wadektech.springkotlindemo.mapper.AddUserRequestMapper
import com.wadektech.springkotlindemo.utils.toUserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserManagementServiceImpl(
    private val userDao: IUserDao,
    private val addUserRequestMapper: AddUserRequestMapper
) : IUserManagementService {

    override fun findUserById(userId: Int): UserResponse? {
       return getUserById(userId).toUserResponse()
    }

    override fun findAllUsers(pageable: Pageable): Page<UserResponse> {
        return userDao.findAll(pageable).map(User?::toUserResponse)
    }

    override fun saveUser(addUserRequest: AddUserRequest): UserResponse {
        return this.saveOrUpdateUser(
            addUserRequestMapper.mapToDomain(addUserRequest)
        )
    }

    override fun updateUser(updateUserRequest: UpdateUserRequest): UserResponse {
       val updatedUser : User = (getUserById(updateUserRequest.id) ?: throw IllegalStateException(
           "${updateUserRequest.id} not found!"))

       return this.saveOrUpdateUser(
            updatedUser.apply {
                email = updateUserRequest.email
                username = updateUserRequest.username
            }
        )
    }

    override fun deleteUserById(userId: Int) = userDao.deleteById(userId)

    private fun getUserById(userId: Int?) : User? = userDao.findByIdOrNull(userId)

    private fun saveOrUpdateUser(user: User) : UserResponse = userDao.save(user).toUserResponse()
}