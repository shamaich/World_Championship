package com.shamaich.worldchampionship.model;

public class Country {
    ///id	countryName	capitalCity	flag	population	votes
    private String id;
    private String countryName;
    private String capitalCity;
    private String population;
    private String flag;
    private String score;

    public Country(){}

    public Country(String id, String countryName, String capitalCity, String population, String flag, String votes) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
