package org.jesuitasrioja.idao;


import org.jesuitasrioja.models.Patient;
import java.util.List;

public interface PatientDao {

    public int add(Patient emp);

    public boolean delete(int id);

    public Patient getPatient(int id);

    public List<Patient> getPatients();

    public boolean update(Patient emp);

}
