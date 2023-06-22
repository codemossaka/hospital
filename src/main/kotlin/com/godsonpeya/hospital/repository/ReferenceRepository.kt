package com.godsonpeya.hospital.repository

import com.godsonpeya.hospital.entity.Reference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReferenceRepository : JpaRepository<Reference, Long>