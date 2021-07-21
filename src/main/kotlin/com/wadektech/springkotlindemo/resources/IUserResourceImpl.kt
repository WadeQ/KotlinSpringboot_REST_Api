package com.wadektech.springkotlindemo.resources

import com.wadektech.springkotlindemo.dto.AddUserRequest
import com.wadektech.springkotlindemo.dto.UpdateUserRequest
import com.wadektech.springkotlindemo.dto.UserResponse
import com.wadektech.springkotlindemo.resources.IUserResourceImpl.Companion.BASE_URL
import com.wadektech.springkotlindemo.service.IUserManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_URL]) //specifies the path
class IUserResourceImpl(
    private val userManagementService: IUserManagementService
) : IUserResource {

    @GetMapping("/{userId}")
    override fun findUserById(@PathVariable userId: Int): ResponseEntity<UserResponse?> {
        val userResponse : UserResponse? = this.userManagementService.findUserById(userId)
        return ResponseEntity.status(HttpStatus.OK).body(userResponse)
    }

    @GetMapping
    override fun findAllUsers(pageable: Pageable): ResponseEntity<Page<UserResponse>> {
        return ResponseEntity.ok(this.userManagementService.findAllUsers(pageable))
    }

    @PostMapping
    override fun saveUser(@RequestBody addUserRequest: AddUserRequest): ResponseEntity<UserResponse?> {
        val userResponse = this.userManagementService.saveUser(addUserRequest)
        return ResponseEntity.created(URI.create(
            BASE_URL.plus("/${userResponse.id}")))
            .body(userResponse)
    }

    @PutMapping
    override fun updateUser(@RequestBody updateUserRequest: UpdateUserRequest): ResponseEntity<UserResponse?> {
        return ResponseEntity.ok(this.userManagementService.updateUser(updateUserRequest))
    }

    @DeleteMapping("/{userId}")
    override fun deleteUserById(@PathVariable userId: Int): ResponseEntity<Unit> {
        this.userManagementService.deleteUserById(userId)
        return ResponseEntity
            .noContent()
            .build()
    }

    companion object {
        const val BASE_URL = "/demo/api/v1/user"
    }
}