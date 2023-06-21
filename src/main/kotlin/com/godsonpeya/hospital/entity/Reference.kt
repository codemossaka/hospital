package com.godsonpeya.hospital.entity

import jakarta.persistence.*

@Entity
class Reference(
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @Column(unique = true)
    var name: String,
    var minValue: Double,
    var maxValue: Double,
//    @ManyToOne
//    val category: Category,
    var unit: String
)