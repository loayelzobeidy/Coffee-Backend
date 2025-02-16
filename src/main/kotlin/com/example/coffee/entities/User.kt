package com.example.coffee.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

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
    val name: String,
    @Column
    var password: String,
    @Column
    val role: Role,

){constructor() : this(0, "", "","", Role.USER)}
