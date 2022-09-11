package org.example;

import lombok.Data;

@Data
class CityData {
    private String cityName;
    private String cityDescription;

    public String getCityName() {return cityName;}
    public String getCityDescription() {return cityDescription;}

    public void setCityName (String cityName) {this.cityName = cityName;}
    public void setCityDescription (String cityDescription) {this.cityDescription = cityDescription;}

    public String toString() {
        return String.format("cityName:%s,cityDescription:%s", cityName, cityDescription);
    }
}
