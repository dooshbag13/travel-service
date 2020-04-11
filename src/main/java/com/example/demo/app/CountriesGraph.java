package com.example.demo.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
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
		
		countryNeighbours.put(Country.GREECE, new LinkedList<>());
		countryNeighbours.get(Country.GREECE).add(Country.BULGARIA);
		countryNeighbours.get(Country.GREECE).add(Country.TURKEY);
		countryNeighbours.get(Country.GREECE).add(Country.MACEDONIA);
		countryNeighbours.get(Country.GREECE).add(Country.ALBANIA);
		
		countryNeighbours.put(Country.TURKEY, new LinkedList<>());
		countryNeighbours.get(Country.TURKEY).add(Country.BULGARIA);
		countryNeighbours.get(Country.TURKEY).add(Country.GREECE);
		
		countryNeighbours.put(Country.MACEDONIA, new LinkedList<>());
		countryNeighbours.get(Country.MACEDONIA).add(Country.BULGARIA);
		countryNeighbours.get(Country.MACEDONIA).add(Country.GREECE);
		countryNeighbours.get(Country.MACEDONIA).add(Country.ALBANIA);
		countryNeighbours.get(Country.MACEDONIA).add(Country.SERBIA);
		
		countryNeighbours.put(Country.SERBIA, new LinkedList<>());
		countryNeighbours.get(Country.SERBIA).add(Country.BULGARIA);
		countryNeighbours.get(Country.SERBIA).add(Country.MACEDONIA);
		countryNeighbours.get(Country.SERBIA).add(Country.ROMANIA);
		
		countryNeighbours.put(Country.ROMANIA, new LinkedList<>());
		countryNeighbours.get(Country.ROMANIA).add(Country.BULGARIA);
		countryNeighbours.get(Country.ROMANIA).add(Country.SERBIA);
		
		countryNeighbours.put(Country.ALBANIA, new LinkedList<>());
		countryNeighbours.get(Country.ALBANIA).add(Country.GREECE);
		countryNeighbours.get(Country.ALBANIA).add(Country.MACEDONIA);
		
	}

	public List<Country> getCountryNeighbours(Country country) {
		return countryNeighbours.get(country) != null ? countryNeighbours.get(country) : new ArrayList<>();
	}
	
	public int getCountryNeighboursCount(Country country) {
		return countryNeighbours.get(country) != null ? countryNeighbours.get(country).size() : 0;
	}
}
