package com.godsonpeya.hospital.repository

import com.godsonpeya.hospital.entity.Analysis
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnalysisRepository : JpaRepository<Analysis, Long>