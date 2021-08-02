package com.wadektech.springkotlindemo.dao

import com.wadektech.springkotlindemo.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserDao : JpaRepository<User, Int> {
}