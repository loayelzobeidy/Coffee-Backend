package com.example.coffee.entities

import jakarta.persistence.*

@Table(name = "coffees")
@Entity
class Coffee (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    override val id: Long,
    override val name: String,
    override val price: Long,
    override val description: String,
    override val imageUrl: String

):MenuItem
{
    constructor() : this(0, "",0,"", "")
}