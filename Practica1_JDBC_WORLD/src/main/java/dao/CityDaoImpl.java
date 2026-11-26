package dao;

import models.City;
import models.Country;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CityDaoImpl {
    Connection con = null;

    public Set<City> listaCiudades() {
        //Devolverá la lista completa de ciudades registradas en la base de datos.
        String query = "SELECT * FROM city";
        boolean check = false;
        Set<City> cities = new HashSet<>();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                City c = new City();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setCountrycode(rs.getString("countrycode"));
                c.setDistrict(rs.getString("district"));
                c.setPopulation(rs.getInt("population"));
                cities.add(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return cities;
        } else
            return null;
    }

    public Boolean existeCiudad(Integer codigoCiudad) {
        //Devuelve verdadero en caso de que la ciudad esté registrada y falso en caso contrario.
        String query = "SELECT * FROM city WHERE id= ?";
        boolean check = false;
        City city = new City();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoCiudad);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public City getCity(Integer codigoCiudad) {
        //Devuelve un objeto de tipo City con información de la ciudad con código codigoCiudad
        String query = "SELECT * FROM city WHERE id= ?";
        boolean check = false;
        City c = new City();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoCiudad);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setCountrycode(rs.getString("countrycode"));
                c.setDistrict(rs.getString("district"));
                c.setPopulation(rs.getInt("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return c;
        } else
            return null;
    }


    public Country getPaisDeCiudad(Integer codigoCiudad) {
        //Devuelve el país al que pertenece la ciudad cuyo código se pasa como parámetro.
        String query = "SELECT co.* FROM country co JOIN city c on co.Code = c.CountryCode AND c.ID=?";
        boolean check = false;
        Country c = new Country();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoCiudad);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                c.setCode(rs.getString("code"));
                c.setName(rs.getString("name"));
                c.setContinent(rs.getString("continent"));
                c.setRegion(rs.getString("region"));
                c.setSurfacearea(rs.getInt("surfacearea"));
                c.setIndepyear(rs.getInt("indepyear"));
                c.setPopulation(rs.getInt("population"));
                c.setLifeexpentancy(rs.getDouble("lifeexpectancy"));
                c.setGnp(rs.getDouble("gnp"));
                c.setGnpold(rs.getInt("gnpold"));
                c.setLocalname(rs.getString("localname"));
                c.setGovernmentform(rs.getString("governmentform"));
                c.setHeadofstate(rs.getString("headofstate"));
                c.setCapital(rs.getInt("capital"));
                c.setCode2(rs.getString("code2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return c;
        } else
            return null;
    }

    public Boolean estaCiudadEnPais(Integer codigoCiudad, String codigoPais) {
        //Devuelve verdadero en caso de que la ciudad con código codigoCiudad pertenezca al país con código codigoPais, o falso en caso contrario.
        String query = "SELECT 1 FROM city WHERE id = ? AND countrycode = ?";
        boolean check = false;

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigoCiudad);
            ps.setString(2, codigoPais);
            ResultSet rs = ps.executeQuery();
            check = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public Boolean cambiarNombreCiudad(Integer codigoCiudad, String nuevoNombre) {
        //Cambiará el nombre de la ciudad con código codigoCiudad por nuevoNombre.
        String query = "UPDATE city SET name = ? WHERE id = ?";
        int rs = 0;

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nuevoNombre);
            ps.setInt(2, codigoCiudad);
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs > 0;
    }

    public void aniadirCiudad(City nuevaCiudad) {
        //Añadir una nueva ciudad a la base de datos.
        /*Comprobar si el país asociado existe. Si no existe, añadirlo.
         *Cuando el país sea añadido, insertar la ciudad en caso de que no exista en BBDD.*/
        String query = "INSERT INTO city (name, countrycode, district, population) values (?,?,?,?)";
        int res = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nuevaCiudad.getName());
            ps.setString(2, nuevaCiudad.getCountrycode());
            ps.setString(3, nuevaCiudad.getDistrict());
            ps.setInt(4, nuevaCiudad.getPopulation());
            res = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();}
    }

    public boolean ifExitsCity(int id) {
        String query = "SELECT * FROM city WHERE id= ?";
        boolean check = false;
        City city = new City();

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


}