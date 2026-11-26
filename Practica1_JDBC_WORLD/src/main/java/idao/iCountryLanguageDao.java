package idao;

import models.Countrylanguage;

import java.util.List;
import java.util.Set;

public interface iCountryLanguageDao {
    public List<Countrylanguage> getAllLanguages();
    public Set<Countrylanguage> listaIdiomas(String codigoPais);

}
