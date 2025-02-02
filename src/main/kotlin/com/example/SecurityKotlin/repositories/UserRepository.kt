package com.example.SecurityKotlin.repositories

import com.example.SecurityKotlin.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, String> {
    fun findByEmail(email:String):User?
    fun findById(id: Long): User?
    fun deleteById(uuid: Long): Boolean

}