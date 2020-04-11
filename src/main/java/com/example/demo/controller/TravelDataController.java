package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.TravelCalculationService;
import com.example.demo.app.TravelRequest;
import com.example.demo.app.TravelResponse;
import com.example.demo.controller.swagger.TravelDataSwaggerSpecification;
import com.example.demo.errors.TravelRequestException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/travel")
public class TravelDataController implements TravelDataSwaggerSpecification {
	private final TravelCalculationService calculationService;

	@Override
	@PostMapping
	public TravelResponse calculateTravelData(@Valid @RequestBody TravelRequest request, Errors errors) {
		if (errors.hasErrors()) {
            throw new TravelRequestException(errors);
        }
		log.debug("Received request: " + request);
		
		return calculationService.calculateTravelData(request);
	}

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}
