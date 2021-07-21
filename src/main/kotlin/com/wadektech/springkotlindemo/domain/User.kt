package com.wadektech.springkotlindemo.domain

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.SequenceGenerator


data class User(
    @Id
    @SequenceGenerator(
        name = USER_SEQUENCE ,
        sequenceName = USER_SEQUENCE,
        initialValue = 1,
        allocationSize = 1
    )

    @Column(name = "user_id")
    val id : Int = 1,
    @Column(name = "username")
    var username : String?,
    @Column(name = "email")
    var email : String?
) {

    companion object{
        const val USER_SEQUENCE = "USER_SEQUENCE"
    }
}