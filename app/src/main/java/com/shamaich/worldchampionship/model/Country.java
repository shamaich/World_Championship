package com.shamaich.worldchampionship.model;

public class Country {
    ///id	countryName	capitalCity	flag	population	votes
    private String countryName;
    private String capitalCity;
    private String population;
    private String flag;
    private long score;

    public Country(){}

    public Country(String countryName, String capitalCity, String population, String flag, long votes) {
        this.countryName = countryName;
        this.capitalCity = capitalCity;
        this.population = population;
        this.flag = flag;
        this.score = votes;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
