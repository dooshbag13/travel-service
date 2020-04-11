package com.example.demo.app;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class TravelCalculationServiceImpl implements TravelCalculationService {
	private final CountriesGraph countriesGraph;

	@Override
	public TravelResponse calculateTravelData(TravelRequest request) {
		
		final int countriesNumberToVisit = countriesGraph.getCountryNeighboursCount(request.getCountry());
		final float totalBudgetInEuro = request.getCurrency().getEuroAmount(request.getTotalBudget());
		final float budgetPerCountryInEuro = request.getCurrency().getEuroAmount(request.getBudgetPerCountry());
		
		final float moneyPerOneRoundTripEuro = countriesNumberToVisit * budgetPerCountryInEuro;
		
		final int tripsAroundNeighbours = moneyPerOneRoundTripEuro != 0 ? 
				                (int) (totalBudgetInEuro / moneyPerOneRoundTripEuro) : 0;
				                
		final float moneyLeftoverEuro = totalBudgetInEuro - 
				                tripsAroundNeighbours * countriesNumberToVisit * budgetPerCountryInEuro;
		
		final float totalMoneyForCountryEuro = budgetPerCountryInEuro * tripsAroundNeighbours;
		
		final StringBuilder sb = new StringBuilder();
		sb.append(request.getCountry()).append(" has ").append(countriesNumberToVisit)
		  .append(" neighbour countries ").append(countriesGraph.getCountryNeighbours(request.getCountry()))
		  .append(" and Angel can travel around them ").append(tripsAroundNeighbours).append(" times. ")
		  .append("He will have ").append( String.format("%.2f", request.getCurrency().getLocalAmount(moneyLeftoverEuro)))
		  .append(" ").append(request.getCurrency()).append(" leftover.");
		
		if(tripsAroundNeighbours > 0) {
			countriesGraph.getCountryNeighbours(request.getCountry()).forEach(country ->{
				sb.append("For ").append(country).append(" he will need to buy ");
				sb.append( String.format("%.2f", country.getCurrency().getLocalAmount(totalMoneyForCountryEuro)))
				  .append(" ").append(country.getCurrency()).append(", ");
			});
			sb.replace(sb.length()-2, sb.length(), "");
			sb.append(".");
		}
		
		final TravelResponse response = new TravelResponse();
		response.setNeighbourCountries(countriesGraph.getCountryNeighbours(request.getCountry()));
		response.setMoneyLeftover(request.getCurrency().getLocalAmount(moneyLeftoverEuro));
		response.setRoundTravelsCount(tripsAroundNeighbours);
		response.setBottomLineMessage(sb.toString());
		
		log.debug("Responding with: " + response);
		return response;
	}
}
