package com.example.SecurityKotlin.services


import com.example.SecurityKotlin.entities.User
import com.example.SecurityKotlin.repositories.UserRepository
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder
) {

    @Transactional
    fun createUser(user: User): User? {
        println("transacton "+user)
        val found = userRepository.findByEmail(user.email)

        return if (found == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findByUUID(uuid: Long): User? =
        userRepository.findById(uuid)

    fun findAll(): List<User> =
        userRepository.findAll()
            .toList()

    fun deleteByUUID(uuid: Long): Boolean =
        userRepository.deleteById(uuid)
}