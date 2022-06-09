package com.example.recuperaciom8.Api.Model;

import java.io.Serializable;

public class UbicacioApi implements Serializable {

        public String city;
        public String weather;
        public String temperature;

        public String getCity() {
            return city;
        }

        public String getWeather() {
            return weather;
        }

        public String getTemperature() {
            return temperature;
        }
    }
