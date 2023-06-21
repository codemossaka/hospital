package com.godsonpeya.hospital.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import kotlin.jvm.Transient

@Entity
class Analysis(
    @Id @Column(columnDefinition = "serial") @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
    var value: Double,
    @ManyToOne var reference: Reference,
    var comment: String,

    @ManyToOne @JsonIgnore var exam: Exam? = null
) {
    @Transient
    var isGood: Boolean = false

    @Column(name = "value", insertable = false, updatable = false)
    private val calculatedValue: Double = 0.0

    @PostLoad
    fun calculateIsGood() {
        val doubleValue = calculatedValue
        isGood = doubleValue >= reference.minValue && doubleValue <= reference.maxValue
    }
}