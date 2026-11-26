package dao;

import idao.iCountryDao;
import models.City;
import models.Country;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CountryDaoImpl implements iCountryDao {

    /** Devuelve todos los países registrados (conjunto vacío si no hay ninguno). */
    @Override
    public Set<Country> listaPaises() {
        Set<Country> countries = new HashSet<>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM country");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                countries.add(leerPais(rs));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al listar los países", e);
        }
        return countries;
    }

    /** Verdadero si hay un país con ese código. */
    @Override
    public Boolean existePais(String codigoPais) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT 1 FROM country WHERE code = ?")) {
            ps.setString(1, codigoPais);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al comprobar el país " + codigoPais, e);
        }
    }

    /** Devuelve el país con ese código, o null si no existe. */
    @Override
    public Country getCountry(String codigoPais) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM country WHERE code = ?")) {
            ps.setString(1, codigoPais);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? leerPais(rs) : null;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al consultar el país " + codigoPais, e);
        }
    }

    /** Ciudades del país cuyo nombre se pasa como parámetro (conjunto vacío si no hay). */
    @Override
    public Set<City> listaCiudades(String nombrePais) {
        String query = "SELECT c.* FROM city c JOIN country co ON c.countrycode = co.code WHERE co.name = ?";
        Set<City> cities = new HashSet<>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombrePais);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City c = new City();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    c.setCountrycode(rs.getString("countrycode"));
                    c.setDistrict(rs.getString("district"));
                    c.setPopulation(rs.getInt("population"));
                    cities.add(c);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al listar las ciudades de " + nombrePais, e);
        }
        return cities;
    }

    /** Añade el país si no existe ya. Devuelve verdadero si se insertó. */
    @Override
    public Boolean aniadirPais(Country nuevoPais) {
        if (existePais(nuevoPais.getCode())) {
            return false;
        }
        String query = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, "
                + "lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nuevoPais.getCode());
            ps.setString(2, nuevoPais.getName());
            ps.setString(3, nuevoPais.getContinent());
            ps.setString(4, nuevoPais.getRegion());
            ps.setInt(5, nuevoPais.getSurfacearea());
            ps.setInt(6, nuevoPais.getIndepyear());
            ps.setInt(7, nuevoPais.getPopulation());
            ps.setDouble(8, nuevoPais.getLifeexpentancy());
            ps.setDouble(9, nuevoPais.getGnp());
            ps.setInt(10, nuevoPais.getGnpold());
            ps.setString(11, nuevoPais.getLocalname());
            ps.setString(12, nuevoPais.getGovernmentform());
            ps.setString(13, nuevoPais.getHeadofstate());
            ps.setInt(14, nuevoPais.getCapital());
            ps.setString(15, nuevoPais.getCode2());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Error al añadir el país " + nuevoPais.getCode(), e);
        }
    }

    private Country leerPais(ResultSet rs) throws SQLException {
        Country c = new Country();
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
        return c;
    }
}
