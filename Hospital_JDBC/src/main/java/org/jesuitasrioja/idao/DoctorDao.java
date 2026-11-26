package org.jesuitasrioja.idao;

import org.jesuitasrioja.models.Doctor;
import java.util.List;

public interface DoctorDao {
    public int add(Doctor emp);
    public boolean delete(int id);
    public Doctor getDoctor(int id);
    public List<Doctor> getDoctors();
    public boolean update(Doctor emp);
}

/*
public Doctor addDoctorById(int id);
public Doctor findDoctorById(int id);
public Boolean deleteDoctorById(int id);
public Doctor updateDoctor(Doctor doctor);
public List<Doctor> findAllDoctor();
 */

