package com.example.demo.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CountriesGraph {

	private final Map<Country, List<Country>> countryNeighbours;

	public CountriesGraph() {
		countryNeighbours = new HashMap<>();

		countryNeighbours.put(Country.BULGARIA, new LinkedList<>());
		countryNeighbours.get(Country.BULGARIA).add(Country.GREECE);
		countryNeighbours.get(Country.BULGARIA).add(Country.ROMANIA);
		countryNeighbours.get(Country.BULGARIA).add(Country.SERBIA);
		countryNeighbours.get(Country.BULGARIA).add(Country.MACEDONIA);
		countryNeighbours.get(Country.BULGARIA).add(Country.TURKEY);
	}

	public List<Country> getCountryNeighbours(Country country) {
		return countryNeighbours.get(country) != null ? countryNeighbours.get(country) : new ArrayList<>();
	}
	
	public int getCountryNeighboursCount(Country country) {
		return countryNeighbours.get(country) != null ? countryNeighbours.get(country).size() : 0;
	}
}
