package com.example.detistapointment;

import com.example.detistapointment.common.exception.NotFoundException;
import com.example.detistapointment.dto.PatientDto;
import com.example.detistapointment.model.Patient;
import com.example.detistapointment.repository.PatientRepository;
import com.example.detistapointment.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PatientServiceIntegrationTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindPatientById_WhenIdExists_ReturnsPatientDto() {
        // Arrange
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patientRepository.save(patient);

        // Act
        var result = patientService.getPatientById(patient.getPatientId());

        // Assert
        assertEquals(patient.getPatientId(), result.getPatientId());
        assertEquals(patient.getLastName(), result.getLastName());
    }

    @Test
    public void testFindPatientById_WhenIdDoesNotExist_ThrowsNotFoundException() {
        // Arrange
        Long nonExistentId = 3000L;
        var result = patientService.getPatientById(nonExistentId);
        // Act and Assert
        assertEquals( result, null);
    }
}
