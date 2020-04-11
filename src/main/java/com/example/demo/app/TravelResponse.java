package com.example.demo.app;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TravelResponse {

    @ApiModelProperty(position = 1)
    private List<Country> neighbourCountries;

    @ApiModelProperty(position = 2)
    private Integer roundTravelsCount;
    
    @ApiModelProperty(position = 3)
    private Float moneyLeftover;

    @ApiModelProperty(position = 4)
    private Map<Country, Float> countryToRequiredLocalMoneyAmountMap;
    
    @ApiModelProperty(position = 5)
    private String bottomLineMessage;
}
