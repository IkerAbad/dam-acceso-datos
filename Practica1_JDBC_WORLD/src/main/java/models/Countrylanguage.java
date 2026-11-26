package models;

public class Countrylanguage {
    private String countrycode;
    private String language;
    private char isofficial;
    private double percentage;

    public Countrylanguage(){}

    public Countrylanguage(String countrycode, String language, char isofficial, double percentage) {
        this.countrycode = countrycode;
        this.language = language;
        this.isofficial = isofficial;
        this.percentage = percentage;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public char getIsofficial() {
        return isofficial;
    }

    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial.charAt(0);
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Countrylanguage{" +
                "countrycode='" + countrycode + '\'' +
                ", language='" + language + '\'' +
                ", isofficial=" + isofficial +
                ", percentage=" + percentage +
                '}';
    }
}
