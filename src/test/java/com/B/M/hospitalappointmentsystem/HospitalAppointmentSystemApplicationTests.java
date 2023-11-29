package com.B.M.hospitalappointmentsystem;

import com.B.M.hospitalappointmentsystem.DAO.PatientDAO;
import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import com.B.M.hospitalappointmentsystem.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;





@SpringBootTest
class HospitalAppointmentSystemApplicationTests {


	@Mock
		private PatientDAO patientDAO;

		@InjectMocks
		private PatientService patientService;

		@BeforeEach
		public void init() {
			MockitoAnnotations.initMocks(this);
		}

		@Test
		public void testGetAllPatients() {
			// Prepare mock data
			List<PatientBean> patients = new ArrayList<>();
			patients.add(new PatientBean(1L, "John"));
			patients.add(new PatientBean(2L, "Alice"));

			when(patientDAO.findAll()).thenReturn(patients);

			// Perform the method call
			List<PatientBean> result = patientService.getAllPatients();

			// Verify the result
			assertEquals(2, result.size());
		}

		// Other test methods for getPatientById(), createPatient(), updatePatient(), deletePatient()...
	}



