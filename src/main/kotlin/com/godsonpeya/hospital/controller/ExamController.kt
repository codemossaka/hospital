package com.godsonpeya.hospital.controller

import com.godsonpeya.hospital.entity.Exam
import com.godsonpeya.hospital.service.ExamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/exams")
class ExamController(private val examService: ExamService) {
    @GetMapping
    fun getAllExams(): ResponseEntity<List<Exam>> {
        val exams = examService.getAllExams()
        return ResponseEntity.ok(exams)
    }

    @GetMapping("/{id}")
    fun getExamById(@PathVariable id: Long): ResponseEntity<Exam> {
        val exam = examService.getExamById(id)
        return if (exam != null) {
            ResponseEntity.ok(exam)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createExam(@RequestBody exam: Exam): ResponseEntity<Exam> {
        val createdExam = examService.createExam(exam)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExam)
    }

    @PutMapping("/{id}")
    fun updateExam(
        @PathVariable id: Long,
        @RequestBody updatedExam: Exam
    ): ResponseEntity<Exam> {
        val updatedExam = examService.updateExam(id, updatedExam)
        return if (updatedExam != null) {
            ResponseEntity.ok(updatedExam)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteExam(@PathVariable id: Long): ResponseEntity<Void> {
        examService.deleteExam(id)
        return ResponseEntity.noContent().build()
    }
}
