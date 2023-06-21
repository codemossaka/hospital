package com.godsonpeya.hospital.entity

import jakarta.persistence.*


@Entity
class Category(
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var name: String,
    )