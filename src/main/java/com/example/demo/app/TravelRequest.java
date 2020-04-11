package com.example.demo.app;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TravelRequest {
	
	@NotNull
	@ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, required = true, position = 1)
    private Country country;
	
	@NotNull
	@ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, required = true, position = 2)
	private Float budgetPerCountry;
	
	@NotNull
	@ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, required = true, position = 3)
	private Float totalBudget;
	
	@NotNull
	@ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, required = true, position = 4)
	private Currency currency;
}
