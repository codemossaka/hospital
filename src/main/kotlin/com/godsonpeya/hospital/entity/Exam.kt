package com.godsonpeya.hospital.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp

@Entity
class Exam(
    @Id @Column(columnDefinition = "serial") @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
    var name: String,
    var dateFrom: Timestamp,
    var organisation: String="",
    var doctor: String="",
    var electronicCard: String="",
    @CreationTimestamp var created: Timestamp,
    @OneToMany(mappedBy = "exam") var analysis: List<Analysis> = mutableListOf(),
)