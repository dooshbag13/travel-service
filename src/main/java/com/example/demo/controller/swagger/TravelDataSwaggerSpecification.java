package com.example.demo.controller.swagger;

import org.springframework.validation.Errors;

import com.example.demo.app.TravelRequest;
import com.example.demo.app.TravelResponse;
import com.example.demo.errors.ErrorDescription;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

public interface TravelDataSwaggerSpecification {

	@ApiOperation(value = "Returns travel details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 418, message = "Travel Request Exception", response = ErrorDescription.class) })
	TravelResponse calculateTravelData(@ApiParam(name = "travelRequest", value = "Initial travel data") TravelRequest travelRequest,
			@ApiIgnore Errors errors);
}
