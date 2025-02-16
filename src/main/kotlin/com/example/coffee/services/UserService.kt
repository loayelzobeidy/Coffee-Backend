package com.example.coffee.services


import com.example.coffee.entities.User
import com.example.coffee.repositories.UserRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
     val userRepository: UserRepository,
     val encoder: PasswordEncoder
) {

    @Transactional
    fun createUser(user: User): User? {
        println("transacton "+user)
        val found = userRepository.findByEmail(user.email)

        return if (found == null) {
            user.password = encoder.encode(user.password)
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