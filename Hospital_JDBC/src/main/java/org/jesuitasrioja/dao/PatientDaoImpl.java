package org.jesuitasrioja.dao;

import org.jesuitasrioja.idao.PatientDao;
import org.jesuitasrioja.models.Doctor;
import org.jesuitasrioja.models.Patient;
import org.jesuitasrioja.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
    Connection con = null;

    @Override
    public int add(Patient emp){
        String query = "INSERT INTO patients ( name, lastname, dni, age, phone, disease) values (?,?,?,?,?,?)";
        int res = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getLastname());
            ps.setString(3, emp.getDni());
            ps.setDouble(4, emp.getAge());
            ps.setString(5, emp.getPhone());
            ps.setString(6, emp.getDisease());
            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(int id){
        String query = "DELETE FROM patients WHERE id= ?";
        int rs=0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs == 1){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Patient getPatient(int id) {
        String query = "SELECT * FROM patients WHERE id= ?";
        boolean check = false;
        Patient patient = new Patient();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                patient.setId(rs.getInt("id"));
                patient.setDni(rs.getString("dni"));
                patient.setLastname(rs.getString("lastname"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setPhone(rs.getString("phone"));
                patient.setDisease(rs.getString("disease"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return patient;
        } else
            return null;
    }

    @Override
    public List<Patient> getPatients() {
        String query = "SELECT * FROM patients";
        boolean check = false;
        List<Patient> patients = new ArrayList<Patient>();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                Patient d = new Patient();
                d.setId(rs.getInt("id"));
                d.setDni(rs.getString("dni"));
                d.setLastname(rs.getString("lastname"));
                d.setName(rs.getString("name"));
                d.setAge(rs.getInt("age"));
                d.setPhone(rs.getString("phone"));
                d.setDisease(rs.getString("disease"));
                patients.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return patients;
        } else
            return null;
    }

    public boolean ifExitsDoctor(int id) {
        String query = "SELECT * FROM patients WHERE id= ?";
        boolean check = false;
        Patient patient = new Patient();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean update(Patient emp) {
        if (ifExitsDoctor(emp.getId())) {
            String query = "UPDATE `patients` SET `name`=?,`lastname`=?,`dni`=?,`age`=?,`phone`=?,`disease`=? WHERE id =?";
            int rs = 0;
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getLastname());
                ps.setString(3, emp.getDni());
                ps.setDouble(4, emp.getAge());
                ps.setString(5, emp.getPhone());
                ps.setString(6, emp.getDisease());
                ps.setInt(7, emp.getId());
                rs = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (rs > 0) {
                return true;
            }
        }
        return false;
    }
}
