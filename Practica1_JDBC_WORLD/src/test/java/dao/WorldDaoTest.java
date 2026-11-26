package dao;

import models.City;
import models.Country;
import models.Countrylanguage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/** Pruebas de los DAO contra H2 en modo MySQL con el mismo esquema que la base world. */
public class WorldDaoTest {
    private static final String URL = "jdbc:h2:mem:world;MODE=MySQL;DATABASE_TO_LOWER=TRUE;DB_CLOSE_DELAY=-1";

    @BeforeClass
    public static void configurar() {
        System.setProperty("DB_URL", URL);
        System.setProperty("DB_USER", "sa");
        System.setProperty("DB_PASS", "");
    }

    @Before
    public void cargarDatos() throws Exception {
        try (Connection con = DriverManager.getConnection(URL, "sa", "");
             Statement st = con.createStatement()) {
            st.execute("DROP TABLE IF EXISTS countrylanguage");
            st.execute("DROP TABLE IF EXISTS city");
            st.execute("DROP TABLE IF EXISTS country");
            st.execute("CREATE TABLE country (Code CHAR(3) PRIMARY KEY, Name VARCHAR(52), Continent VARCHAR(30), "
                    + "Region VARCHAR(26), SurfaceArea DOUBLE, IndepYear SMALLINT, Population INT, "
                    + "LifeExpectancy DOUBLE, GNP DOUBLE, GNPOld DOUBLE, LocalName VARCHAR(45), "
                    + "GovernmentForm VARCHAR(45), HeadOfState VARCHAR(60), Capital INT, Code2 CHAR(2))");
            st.execute("CREATE TABLE city (ID INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(35), "
                    + "CountryCode CHAR(3), District VARCHAR(20), Population INT)");
            st.execute("CREATE TABLE countrylanguage (CountryCode CHAR(3), Language VARCHAR(30), "
                    + "IsOfficial VARCHAR(1), Percentage DOUBLE)");
            st.execute("INSERT INTO country VALUES ('ESP','Spain','Europe','Southern Europe',505992,1492,39441700,"
                    + "78.8,553233,532031,'España','Constitutional Monarchy','Felipe VI',653,'ES')");
            st.execute("INSERT INTO country VALUES ('FRA','France','Europe','Western Europe',551500,843,59225700,"
                    + "78.8,1424285,1392448,'France','Republic','Jacques Chirac',2974,'FR')");
            st.execute("INSERT INTO city (Name, CountryCode, District, Population) VALUES ('Madrid','ESP','Madrid',2879052)");
            st.execute("INSERT INTO city (Name, CountryCode, District, Population) VALUES ('Barcelona','ESP','Katalonia',1503451)");
            st.execute("INSERT INTO city (Name, CountryCode, District, Population) VALUES ('Paris','FRA','Île-de-France',2125246)");
            st.execute("INSERT INTO countrylanguage VALUES ('ESP','Spanish','T',74.4)");
            st.execute("INSERT INTO countrylanguage VALUES ('ESP','Catalan','F',16.9)");
            st.execute("INSERT INTO countrylanguage VALUES ('FRA','French','T',93.6)");
        }
    }

    @Test
    public void listaPaises() {
        assertEquals(2, new CountryDaoImpl().listaPaises().size());
    }

    @Test
    public void existePaisBuscaPorCodigo() {
        CountryDaoImpl dao = new CountryDaoImpl();
        assertTrue(dao.existePais("ESP"));
        assertFalse(dao.existePais("XXX"));
    }

    @Test
    public void getCountryDevuelvePaisOCNull() {
        CountryDaoImpl dao = new CountryDaoImpl();
        Country es = dao.getCountry("ESP");
        assertEquals("Spain", es.getName());
        assertEquals(78.8, es.getLifeexpentancy(), 1e-9);
        assertNull(dao.getCountry("XXX"));
    }

    @Test
    public void listaCiudadesPorNombreDePais() {
        Set<City> ciudades = new CountryDaoImpl().listaCiudades("Spain");
        assertEquals(2, ciudades.size());
        assertTrue(new CountryDaoImpl().listaCiudades("Atlantis").isEmpty());
    }

    @Test
    public void aniadirPaisNoDuplica() {
        CountryDaoImpl dao = new CountryDaoImpl();
        Country pt = new Country("PRT", "Portugal", "Europe", "Southern Europe", 91982, 1143, 9997600,
                75.8, 105954, 102133, "Portugal", "Republic", "Jorge Sampaio", 2914, "PT");
        assertTrue(dao.aniadirPais(pt));
        assertFalse(dao.aniadirPais(pt));
        assertEquals(3, dao.listaPaises().size());
    }

    @Test
    public void idiomas() {
        CountryLanguageDaoImpl dao = new CountryLanguageDaoImpl();
        List<Countrylanguage> todos = dao.getAllLanguages();
        assertEquals(3, todos.size());
        assertEquals(2, dao.listaIdiomas("ESP").size());
        assertTrue(dao.listaIdiomas("XXX").isEmpty());
    }

    @Test
    public void ciudades() {
        CityDaoImpl dao = new CityDaoImpl();
        assertEquals(3, dao.listaCiudades().size());
        assertTrue(dao.existeCiudad(1));
        assertEquals("Madrid", dao.getCity(1).getName());
        assertEquals("Spain", dao.getPaisDeCiudad(1).getName());
        assertTrue(dao.estaCiudadEnPais(1, "ESP"));
        assertFalse(dao.estaCiudadEnPais(1, "FRA"));
        dao.aniadirCiudad(new City(0, "Zaragoza", "ESP", "Aragon", 500000));
        assertEquals(4, dao.listaCiudades().size());
    }
}
