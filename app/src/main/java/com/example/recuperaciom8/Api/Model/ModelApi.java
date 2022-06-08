package com.example.recuperaciom8.Api.Model;

import java.util.ArrayList;

public class ModelApi {

        public Coord coord;
        public String name;
        public ArrayList<Weather> weather;

        public String getName() { return name; }
        public Coord getCoord() { return coord; }
        public ArrayList<Weather> getWeather() { return weather; }

}
