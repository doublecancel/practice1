package entity;

public class City {
    private Long id;
    private String name;
    private String countryCode;
    private String district;
    private Long population;

    public static class Field {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String COUNTRYCODE = "countryCode";
        public static final String DISTRICT = "district";
        public static final String POPULATION = "population";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
