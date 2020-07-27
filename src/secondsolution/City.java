/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondsolution;

/**
 *
 * @author Lenovo-ideaPad-15isk
 */
public class City {

    String name;
    String nameOfConutry;
    String nameOfRegionalCity;
    String geoNameId;

    public City() {
        super();

    }

    public City(String name, String nameOfCountry, String nameOfRegionalCity, String geoNameId) {
        super();
        this.name = name;
        this.nameOfConutry = nameOfCountry;
        this.nameOfRegionalCity = nameOfRegionalCity;
        this.geoNameId = geoNameId;
    }

    String getName() {

        return this.name;
    }

    String getNameOfConutry() {

        return nameOfConutry;
    }

    String getNameOfRegionalCity() {

        return nameOfRegionalCity;
    }

    String getGeoNameId() {

        return geoNameId;
    }

}
