package com.godsonpeya.hospital.service

import com.godsonpeya.hospital.entity.Reference
import com.godsonpeya.hospital.repository.ReferenceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReferenceService(private val referenceRepository: ReferenceRepository) {
    fun getAllReferences(): List<Reference> {
        return referenceRepository.findAll()
    }

    fun getReferenceById(id: Long): Optional<Reference> {
        return referenceRepository.findById(id)
    }

    fun createReference(reference: Reference): Reference {
        return referenceRepository.save(reference)
    }

    fun updateReference(id: Long, reference: Reference): Reference {
        return referenceRepository.save(reference)
    }

    fun deleteReferenceById(id: Long) {
        referenceRepository.deleteById(id)
    }
}
