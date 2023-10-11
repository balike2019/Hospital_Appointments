package com.B.M.hospitalappointmentsystem.service;

import com.B.M.hospitalappointmentsystem.DAO.AppointmentDAO;
import com.B.M.hospitalappointmentsystem.bean.AppointmentBean;
import com.B.M.hospitalappointmentsystem.exceptions.AppointmentConflictException;
import com.B.M.hospitalappointmentsystem.exceptions.AppointmentNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    @Transactional
    public void updateAppointment(Long id, AppointmentBean updatedAppointment) {
        // Check if the appointment with the given ID exists in the database
        AppointmentBean existingAppointment = appointmentRepository.findById(id).orElse(null);

        if (existingAppointment == null) {
            // Handle the case where the appointment is not found (e.g., throw an exception)
            throw new EntityNotFoundException("Appointment with ID " + id + " not found");
        }

        // Update the fields of the existing appointment with the new values
        existingAppointment.setId(updatedAppointment.getId());
        existingAppointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
        //existingAppointment.setDescription(updatedAppointment.getDescription());

        // Save the updated appointment back to the database
        appointmentRepository.save(existingAppointment);
    }
}







