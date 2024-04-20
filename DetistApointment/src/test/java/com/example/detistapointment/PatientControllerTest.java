package com.example.detistapointment;
import com.example.detistapointment.controller.PatientController;
import com.example.detistapointment.dto.AddressDto;
import com.example.detistapointment.dto.PatientDto;
import com.example.detistapointment.service.AddressService;
import com.example.detistapointment.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPatients_ReturnsPatientsList() {
        // Arrange
        List<PatientDto> patients = new ArrayList<>();
        var patient = new PatientDto();
        patient.setPatientId(100);
        patient.setLastName("John");
        patient.setFirstName("Lam");
        patients.add(patient);

        when(patientService.getAllPatientsWithAddress()).thenReturn(patients);

        // Act
        ResponseEntity<List<PatientDto>> response = patientController.getAllPatients();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testGetAllPatients_ReturnsEmptyList_WhenNoPatientsExist() {
        // Arrange
        when(patientService.getAllPatientsWithAddress()).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<List<PatientDto>> response = patientController.getAllPatients();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }

}
