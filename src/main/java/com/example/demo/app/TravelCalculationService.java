package com.example.demo.app;

public interface TravelCalculationService {

	/**
	 * Calculates Travel data details based on TravelRequest data
	 * @param request TravelRequest object
	 * @return TravelResponse with travel details
	 */
	TravelResponse calculateTravelData(TravelRequest request);
}
