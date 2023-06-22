package com.godsonpeya.hospital.controller

import com.godsonpeya.hospital.entity.Analysis
import com.godsonpeya.hospital.service.AnalysisService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/analysis")
class AnalysisController(private val analysisService: AnalysisService) {
    @GetMapping
    fun getAllAnalysis(): ResponseEntity<List<Analysis>> {
        val analysis = analysisService.getAllAnalysis()
        return ResponseEntity.ok(analysis)
    }

    @GetMapping("/{id}")
    fun getAnalysisById(@PathVariable id: Long): ResponseEntity<Analysis> {
        val analysis = analysisService.getAnalysisById(id)
        return if (analysis != null) {
            ResponseEntity.ok(analysis)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createAnalysis(@RequestBody analysis: Analysis): ResponseEntity<Analysis> {
        val createdAnalysis = analysisService.createAnalysis(analysis)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnalysis)
    }

    @PutMapping("/{id}")
    fun updateAnalysis(
        @PathVariable id: Long,
        @RequestBody updatedAnalysis: Analysis
    ): ResponseEntity<Analysis> {
        val updatedAnalysis = analysisService.updateAnalysis(id, updatedAnalysis)
        return if (updatedAnalysis != null) {
            ResponseEntity.ok(updatedAnalysis)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteAnalysis(@PathVariable id: Long): ResponseEntity<Void> {
        analysisService.deleteAnalysis(id)
        return ResponseEntity.noContent().build()
    }
}
