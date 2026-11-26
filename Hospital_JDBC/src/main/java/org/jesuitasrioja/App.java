package org.jesuitasrioja;

import org.jesuitasrioja.dao.DoctorDaoImpl;
import org.jesuitasrioja.dao.PatientDaoImpl;
import org.jesuitasrioja.models.Doctor;
import org.jesuitasrioja.models.Patient;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLIntegrityConstraintViolationException {

        //PROBAR DOCTORES
        DoctorDaoImpl doctorDao = new DoctorDaoImpl();

        //Modificar doctor
        Doctor doctor = doctorDao.getDoctor(1);
        doctor.setLastname("ApellidoCambiado");
        System.out.println(doctor);

        //Todos los doctores
        System.out.println(doctorDao.getDoctors());

        //Actualizar a base de datos
        doctorDao.update(doctor);

        //Añadir doctor
        Doctor doctor1 = new Doctor(0,"name", "lastname", "31121123K", 1250, "speciality");
        doctorDao.add(doctor1);

        //Borrar doctor
        doctorDao.delete(10);

        //PROBAR PACIENTES
        PatientDaoImpl patientDao = new PatientDaoImpl();

        //Modificar paciente
        Patient patient = patientDao.getPatient(1);
        doctor.setLastname("ApellidoCambiado");
        System.out.println(patient);

        //Todos los doctores
        System.out.print(patientDao.getPatients());

        //Actualizar a base de datos
        patientDao.update(patient);

        //Añadir doctor
        Patient patient1 = new Patient(0,"name", "lastname", "31121112L", 26, "913512123","Migraine");
        patientDao.add(patient1);

        //Borrar doctor
        patientDao.delete(10);


    }
}
