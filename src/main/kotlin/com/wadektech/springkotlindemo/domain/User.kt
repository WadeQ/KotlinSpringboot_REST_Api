package com.wadektech.springkotlindemo.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class User(
    @Id
    @SequenceGenerator(
        name = USER_SEQUENCE ,
        sequenceName = USER_SEQUENCE,
        initialValue = 1,
        allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_SEQUENCE)
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = 562048007

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , username = $username , email = $email )"
    }
}