import dao.CityDaoImpl;
import dao.CountryDaoImpl;
import dao.CountryLanguageDaoImpl;
import models.City;

/** Demostración de los tres DAO contra la base world. */
public class App {
    public static void main(String[] args) {
        CityDaoImpl cityDao = new CityDaoImpl();
        System.out.println("Existe la ciudad 12: " + cityDao.existeCiudad(12));
        System.out.println("Ciudad 12: " + cityDao.getCity(12));
        System.out.println("País de la ciudad 12: " + cityDao.getPaisDeCiudad(12));
        System.out.println("¿La ciudad 12 está en ESP?: " + cityDao.estaCiudadEnPais(12, "ESP"));
        cityDao.aniadirCiudad(new City(0, "Zaragoza", "ESP", "Aragon", 500000));

        CountryDaoImpl countryDao = new CountryDaoImpl();
        System.out.println("Países: " + countryDao.listaPaises().size());
        System.out.println("Existe ESP: " + countryDao.existePais("ESP"));
        System.out.println("ESP: " + countryDao.getCountry("ESP"));
        System.out.println("Ciudades de Spain: " + countryDao.listaCiudades("Spain").size());

        CountryLanguageDaoImpl languageDao = new CountryLanguageDaoImpl();
        System.out.println("Idiomas en total: " + languageDao.getAllLanguages().size());
        System.out.println("Idiomas de ESP: " + languageDao.listaIdiomas("ESP"));
    }
}
