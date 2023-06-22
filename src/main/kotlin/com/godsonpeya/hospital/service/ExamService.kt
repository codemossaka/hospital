package com.godsonpeya.hospital.service

import com.godsonpeya.hospital.entity.Exam
import com.godsonpeya.hospital.repository.ExamRepository
import org.springframework.stereotype.Service

@Service
class ExamService(private val examRepository: ExamRepository) {
    fun getAllExams(): List<Exam> {
        return examRepository.findAll()
    }

    fun getExamById(id: Long): Exam? {
        return examRepository.findById(id).orElse(null)
    }

    fun createExam(exam: Exam): Exam {
        return examRepository.save(exam)
    }

    fun updateExam(id: Long, updatedExam: Exam): Exam? {
        val existingExam = examRepository.findById(id).orElse(null)
        existingExam?.apply {
            name = updatedExam.name
            dateFrom = updatedExam.dateFrom
            organisation = updatedExam.organisation
            doctor = updatedExam.doctor
            electronicCard = updatedExam.electronicCard
        }
        return existingExam?.let { examRepository.save(it) }
    }

    fun deleteExam(id: Long) {
        examRepository.deleteById(id)
    }
}
