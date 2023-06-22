package com.godsonpeya.hospital.repository

import com.godsonpeya.hospital.entity.Exam
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExamRepository : JpaRepository<Exam, Long>