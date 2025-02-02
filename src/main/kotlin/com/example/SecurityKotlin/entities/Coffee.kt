package com.example.SecurityKotlin.entities

import jakarta.persistence.*

@Table(name = "coffees")
@Entity
class Coffee (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(unique = true, length = 100, nullable = false)
    val description: String,

    @Column(length = 100, nullable = false)
    val imageUrl: String
)
{
    constructor() : this(0, "", "", "")
}