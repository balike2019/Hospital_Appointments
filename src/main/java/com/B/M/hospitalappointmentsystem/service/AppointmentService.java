package com.B.M.hospitalappointmentsystem.service;

import com.B.M.hospitalappointmentsystem.DAO.AppointmentDAO;
import com.B.M.hospitalappointmentsystem.bean.AppointmentBean;
import com.B.M.hospitalappointmentsystem.exceptions.AppointmentConflictException;
import com.B.M.hospitalappointmentsystem.exceptions.AppointmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    //make appointment
    //cancel appointment
    //list of appointments

        private final AppointmentDAO appointmentRepository;

        @Autowired
        public AppointmentService(AppointmentDAO appointmentRepository) {
            this.appointmentRepository = appointmentRepository;
        }

        public List<AppointmentBean> getAllAppointments() {
            return appointmentRepository.findAll();
        }

        public Optional<AppointmentBean> getAppointmentById(Long id) {
            return appointmentRepository.findById(id);
        }

        public AppointmentBean scheduleAppointment(AppointmentBean appointment) {
            // Add validation logic if needed (e.g., checking for conflicts)
            if (isAppointmentConflict(appointment)) {
                throw new AppointmentConflictException("Appointment time conflicts with an existing appointment");
            }

            return appointmentRepository.save(appointment);
        }

        public void cancelAppointment(Long id) {
            // Check if the appointment exists before deleting
            if (appointmentRepository.existsById(id)) {
                appointmentRepository.deleteById(id);
            } else {
                // Handle not found scenario
                throw new AppointmentNotFoundException("Appointment with id " + id + " not found");
            }
        }
    private boolean isAppointmentConflict(AppointmentBean newAppointment) {
        // Custom logic to check for conflicts with existing appointments
        LocalDateTime newAppointmentDateTime = newAppointment.getAppointmentDateTime();

        // Example: Check if there's an appointment at the same time
        return appointmentRepository.existsByAppointmentDateTime(newAppointmentDateTime);
    }

    }
