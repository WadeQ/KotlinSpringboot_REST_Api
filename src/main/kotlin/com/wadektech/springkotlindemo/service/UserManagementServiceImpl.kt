package com.wadektech.springkotlindemo.service

import com.wadektech.springkotlindemo.dao.IPersonDao
import com.wadektech.springkotlindemo.domain.User
import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse
import com.wadektech.springkotlindemo.mapper.AddUserRequestMapper
import com.wadektech.springkotlindemo.utils.toUserResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserManagementServiceImpl(
    private val userDao: IPersonDao,
    private val addUserRequestMapper: AddUserRequestMapper
) : IUserManagementService {

    override fun findUserById(userId: Int): UserResponse? {
       return this.getUserById(userId).toUserResponse()
    }

    override fun findAllUsers(): List<UserResponse> {
       return this.userDao.findAll().map(User?::toUserResponse)
    }

    override fun saveUser(addUserRequest: AddUserRequest): UserResponse {
        return this.saveOrUpdateUser(
            addUserRequestMapper.mapToDomain(addUserRequest)
        )
    }

    override fun updateUser(updateUserRequest: UpdateUserRequest): UserResponse {
       val updatedUser : User = (this.getUserById(updateUserRequest.id) ?: throw IllegalStateException(
           "${updateUserRequest.id} not found!"
       ))

       return this.saveOrUpdateUser(
            updatedUser.apply {
                this.email = updateUserRequest.email
                this.username = updateUserRequest.username
            }
        )
    }

    override fun deleteUserById(userId: Int) = this.userDao.deleteById(userId)

    private fun getUserById(userId: Int?) : User? = this.userDao.findByIdOrNull(userId)

    private fun saveOrUpdateUser(user: User) : UserResponse = this.userDao.save(user).toUserResponse()
}