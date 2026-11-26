package dao;

import idao.iCountryLanguageDao;
import models.Countrylanguage;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountryLanguageDaoImpl implements iCountryLanguageDao {

    /** Todos los idiomas registrados (lista vacía si no hay ninguno). */
    @Override
    public List<Countrylanguage> getAllLanguages() {
        List<Countrylanguage> languages = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM countrylanguage");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                languages.add(leer(rs));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al listar los idiomas", e);
        }
        return languages;
    }

    /** Idiomas del país con ese código (conjunto vacío si no hay). */
    @Override
    public Set<Countrylanguage> listaIdiomas(String codigoPais) {
        Set<Countrylanguage> languages = new HashSet<>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM countrylanguage WHERE countrycode = ?")) {
            ps.setString(1, codigoPais);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    languages.add(leer(rs));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al listar los idiomas de " + codigoPais, e);
        }
        return languages;
    }

    private Countrylanguage leer(ResultSet rs) throws SQLException {
        Countrylanguage c = new Countrylanguage();
        c.setCountrycode(rs.getString("countrycode"));
        c.setLanguage(rs.getString("language"));
        c.setIsofficial(rs.getString("isofficial"));
        c.setPercentage(rs.getDouble("percentage"));
        return c;
    }
}
