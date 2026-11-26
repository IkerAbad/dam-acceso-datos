package org.jesuitasrioja.dao;

import org.jesuitasrioja.idao.DoctorDao;
import org.jesuitasrioja.models.Doctor;
import org.jesuitasrioja.utils.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    Connection con = null;

    @Override
    public int add(Doctor emp) {
        String query = "INSERT INTO doctors ( name, lastname, dni, salary, speciality) values (?,?,?,?,?)";
        int res = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getLastname());
            ps.setString(3, emp.getDni());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, emp.getSpeciality());
            res = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM doctors WHERE id= ?";
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
    public Doctor getDoctor(int id) {
        String query = "SELECT * FROM doctors WHERE id= ?";
        boolean check = false;
        Doctor doctor = new Doctor();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                doctor.setId(rs.getInt("id"));
                doctor.setDni(rs.getString("dni"));
                doctor.setLastname(rs.getString("lastname"));
                doctor.setName(rs.getString("name"));
                doctor.setSalary(rs.getDouble("salary"));
                doctor.setSpeciality(rs.getString("speciality"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return doctor;
        } else
            return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        String query = "SELECT * FROM doctors";
        boolean check = false;
        List<Doctor> doctors = new ArrayList<Doctor>();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));
                d.setDni(rs.getString("dni"));
                d.setLastname(rs.getString("lastname"));
                d.setName(rs.getString("name"));
                d.setSalary(rs.getDouble("salary"));
                d.setSpeciality(rs.getString("speciality"));
                doctors.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return doctors;
        } else
            return null;
    }

    public boolean ifExitsDoctor(int id) {
        String query = "SELECT * FROM doctors WHERE id= ?";
        boolean check = false;
        Doctor doctor = new Doctor();

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
    public boolean update(Doctor emp) {
        if (ifExitsDoctor(emp.getId())) {
            String query = "UPDATE `doctors` SET `name`=?,`lastname`=?,`dni`=?,`salary`=?,`speciality`=? WHERE id =?";
            int rs = 0;
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getLastname());
                ps.setString(3, emp.getDni());
                ps.setDouble(4, emp.getSalary());
                ps.setString(5, emp.getSpeciality());
                ps.setInt(6, emp.getId());
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
