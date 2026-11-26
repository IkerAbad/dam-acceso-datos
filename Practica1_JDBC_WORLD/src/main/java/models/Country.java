package models;

public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private int surfacearea;
    private int indepyear;
    private int population;
    private double lifeexpentancy;
    private double gnp;
    private int gnpold;
    private String localname;
    private String governmentform;
    private String headofstate;
    private int capital;
    private String code2;

    public Country(){}

    public Country(String code, String name, String continent, String region, int surfacearea, int indepyear, int population, double lifeexpentancy, double gnp, int gnpold, String localname, String governmentform, String headofstate, int capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfacearea = surfacearea;
        this.indepyear = indepyear;
        this.population = population;
        this.lifeexpentancy = lifeexpentancy;
        this.gnp = gnp;
        this.gnpold = gnpold;
        this.localname = localname;
        this.governmentform = governmentform;
        this.headofstate = headofstate;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSurfacearea() {
        return surfacearea;
    }

    public void setSurfacearea(int surfacearea) {
        this.surfacearea = surfacearea;
    }

    public int getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(int indepyear) {
        this.indepyear = indepyear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLifeexpentancy() {
        return lifeexpentancy;
    }

    public void setLifeexpentancy(double lifeexpentancy) {
        this.lifeexpentancy = lifeexpentancy;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public int getGnpold() {
        return gnpold;
    }

    public void setGnpold(int gnpold) {
        this.gnpold = gnpold;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public String getGovernmentform() {
        return governmentform;
    }

    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfacearea=" + surfacearea +
                ", indepyear=" + indepyear +
                ", population=" + population +
                ", lifeexpentancy=" + lifeexpentancy +
                ", gnp=" + gnp +
                ", gnpold=" + gnpold +
                ", localname='" + localname + '\'' +
                ", govermentform='" + governmentform + '\'' +
                ", headofstate='" + headofstate + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
