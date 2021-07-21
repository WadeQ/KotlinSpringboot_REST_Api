package com.wadektech.springkotlindemo.resources

import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface IUserResource {

    /*
    * The ResponseEntity is a spring framework object that allows us to modify the http calls by the headers etc
    * in the controller.
    * */

    fun findUserById(userId: Int) : ResponseEntity<UserResponse?>

    fun findAllUsers(pageable: Pageable) : ResponseEntity<Page<UserResponse>>

    fun saveUser(addUserRequest: AddUserRequest) : ResponseEntity<UserResponse?>

    fun updateUser(updateUserRequest: UpdateUserRequest) : ResponseEntity<UserResponse?>

    fun deleteUserById(userId : Int) : ResponseEntity<Unit>
}