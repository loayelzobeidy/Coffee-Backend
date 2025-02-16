package com.example.coffee.repositories

import com.example.coffee.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun findByEmail(email:String):User?
    fun findById(id: Long): User?
    fun deleteById(uuid: Long): Boolean

}