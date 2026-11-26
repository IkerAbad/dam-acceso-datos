package idao;

import models.City;
import models.Country;

import java.util.Set;

public interface iCityDao {

    public Set<City> listaCiudades();
    public Boolean existeCiudad(Integer codigoCiudad);
    public City getCity(Integer codigoCiudad);
    public Country getPaisDeCiudad(Integer codigoCiudad);
    public Boolean estaCiudadEnPais(Integer codigoCiudad, String codigoPais);
    public void aniadirCiudad(City nuevaCiudad);

}
