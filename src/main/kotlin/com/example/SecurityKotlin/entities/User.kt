package com.example.SecurityKotlin.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name="users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    val id: Long,
    @Column
    val email: String,
    @Column
    var password: String,
    @Column
    val role: Role,

){constructor() : this(0, "", "", Role.USER)}
