package com.travel.controller;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.dto.FlightSearchResponse;
import com.travel.dto.RestException;
import com.travel.enums.TravelEnum;
import com.travel.generic.GenericRestClient;
import com.travel.generic.GenericRestEnum;
import com.travel.service.FlightSearchService;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {

	@Autowired
	private GenericRestClient genericRestClient;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private FlightSearchService flightSearchService;

	@Value("${travel.api.key}")
	private String apikey;

	@RequestMapping(value = "/searchFlight", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightSearchResponse searchFlight(@RequestParam(name = "origin", required = true) String origin,
			@RequestParam(name = "destination", required = true) String destination,
			@RequestParam(name = "departureDate", required = true) String departureDate,
			@RequestParam(name = "returnDate", required = false) String returnDate,
			@RequestParam(name = "numberOfResults", required = false) String numberOfResults,
			@RequestParam(name = "fastestFlight", required = false, defaultValue = "false") boolean fastestFlight,
			@RequestParam(name = "nonstop", required = false, defaultValue = "false") boolean nonstop)
			throws InvalidParameterException, IOException, RestException {

		StringBuffer url = new StringBuffer();
		url.append(TravelEnum.SEARCH_FLIGHT.getValue()).append("?apikey=").append(apikey).append("&origin=")
				.append(origin).append("&destination=").append(destination).append("&departure_date=")
				.append(departureDate);
		if (StringUtils.isNotBlank(returnDate)) {
			url.append("&return_date=").append(returnDate);
		}
		if (StringUtils.isNotBlank(numberOfResults)) {
			url.append("&number_of_results=").append(numberOfResults);
		}
		url.append("&nonstop=").append(nonstop);
		Map<String, Object> result = genericRestClient.invokeRest(url.toString(), null, null, HttpMethod.GET);
		Object responseBody = genericRestClient.getResponseValue(result, GenericRestEnum.RESPONSE_BODY.getValue());
		objectMapper.disable(Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		int statusCode = Integer
				.valueOf(genericRestClient.getResponseValue(result, GenericRestEnum.RESPONSE_STATUS.getValue()) + "");
		if (statusCode != HttpStatus.OK.value()) {
			throw new RestException(statusCode, responseBody.toString());
		}
		FlightSearchResponse flightSearchResponse = objectMapper.readValue(responseBody.toString(),
				FlightSearchResponse.class);
		if (fastestFlight) {
			flightSearchService.sortFlightByDuration(flightSearchResponse);
		}
		return flightSearchResponse;
	}
}