package idao;

import models.City;
import models.Country;

import java.util.Set;

public interface iCountryDao {

    public Set<Country> listaPaises();
    public Boolean existePais(String codigoPais);
    public Country getCountry(String codigoPais);
    public Set<City> listaCiudades(String nombrePais);
    public Boolean aniadirPais(Country nuevoPais);

}
