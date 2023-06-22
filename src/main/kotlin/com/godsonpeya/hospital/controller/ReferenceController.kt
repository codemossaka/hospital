package com.godsonpeya.hospital.controller

import com.godsonpeya.hospital.entity.Reference
import com.godsonpeya.hospital.service.ReferenceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/references")
class ReferenceController(private val referenceService: ReferenceService) {
    @GetMapping
    fun getAllReferences(): ResponseEntity<List<Reference>> {
        val references = referenceService.getAllReferences()
        return ResponseEntity.ok(references)
    }

    @GetMapping("/{id}")
    fun getReferenceById(@PathVariable id: Long): ResponseEntity<Reference> {
        val reference = referenceService.getReferenceById(id)
        return if (reference.isPresent) {
            ResponseEntity.ok(reference.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createReference(@RequestBody reference: Reference): ResponseEntity<Reference> {
        val createdReference = referenceService.createReference(reference)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReference)
    }

    @PutMapping("/{id}")
    fun updateReference(
        @PathVariable id: Long, @RequestBody updatedReference: Reference
    ): ResponseEntity<Reference> {
        val updatedReference = referenceService.updateReference(id, updatedReference)
        return if (updatedReference != null) {
            ResponseEntity.ok(updatedReference)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteReference(@PathVariable id: Long): ResponseEntity<Void> {
        referenceService.deleteReferenceById(id)
        return ResponseEntity.noContent().build()
    }
}
