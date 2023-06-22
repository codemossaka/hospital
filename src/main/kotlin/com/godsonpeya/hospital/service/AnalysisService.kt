package com.godsonpeya.hospital.service

import com.godsonpeya.hospital.entity.Analysis
import com.godsonpeya.hospital.repository.AnalysisRepository
import org.springframework.stereotype.Service

@Service
class AnalysisService(private val analysisRepository: AnalysisRepository) {
    fun getAllAnalysis(): List<Analysis> {
        return analysisRepository.findAll()
    }

    fun getAnalysisById(id: Long): Analysis? {
        return analysisRepository.findById(id).orElse(null)
    }

    fun createAnalysis(analysis: Analysis): Analysis {
        return analysisRepository.save(analysis)
    }

    fun updateAnalysis(id: Long, updatedAnalysis: Analysis): Analysis? {
        val existingAnalysis = analysisRepository.findById(id).orElse(null)
        existingAnalysis?.apply {
            value = updatedAnalysis.value
            reference = updatedAnalysis.reference
            comment = updatedAnalysis.comment
            exam = updatedAnalysis.exam
        }
        return existingAnalysis?.let { analysisRepository.save(it) }
    }

    fun deleteAnalysis(id: Long) {
        analysisRepository.deleteById(id)
    }
}
