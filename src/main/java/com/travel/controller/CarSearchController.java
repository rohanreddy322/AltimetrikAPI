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

import com.travel.dto.CarSearchResponse;
import com.travel.dto.RestException;
import com.travel.enums.TravelEnum;
import com.travel.generic.GenericRestClient;
import com.travel.generic.GenericRestEnum;
import com.travel.service.CarSearchService;

@RestController
@RequestMapping("/car")
public class CarSearchController {

	@Autowired
	private GenericRestClient genericRestClient;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CarSearchService carSearchService;

	@Value("${travel.api.key}")
	private String apikey;

	@RequestMapping(value = "/searchCar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CarSearchResponse searchCar(@RequestParam(name = "location", required = true) String location,
			@RequestParam(name = "pickUp", required = true) String pickUp,
			@RequestParam(name = "dropOff", required = true) String dropOff,
			@RequestParam(name = "cheapestPrice", required = false, defaultValue = "false") boolean cheapestPrice,
			@RequestParam(name = "category", required = false) String category,
			@RequestParam(name = "fastestCar", required = false) boolean fastestCar)
			throws InvalidParameterException, IOException, RestException {

		StringBuffer url = new StringBuffer();
		url.append(TravelEnum.SEARCH_CAR.getValue()).append("?apikey=").append(apikey).append("&location=")
				.append(location).append("&pick_up=").append(pickUp).append("&drop_off=").append(dropOff);
		Map<String, Object> result = genericRestClient.invokeRest(url.toString(), null, null, HttpMethod.GET);
		Object responseBody = genericRestClient.getResponseValue(result, GenericRestEnum.RESPONSE_BODY.getValue());
		objectMapper.disable(Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		int statusCode = Integer
				.valueOf(genericRestClient.getResponseValue(result, GenericRestEnum.RESPONSE_STATUS.getValue()) + "");
		if (statusCode != HttpStatus.OK.value()) {
			throw new RestException(statusCode, responseBody.toString());
		}
		CarSearchResponse carSearchResponse = objectMapper.readValue(responseBody.toString(), CarSearchResponse.class);
		if(fastestCar){
			carSearchService.filterCarByType(carSearchResponse, "sport");
		}
		if (StringUtils.isNotBlank(category)) {
			carSearchService.filterCarByCategory(carSearchResponse, category);
		}
		if (cheapestPrice) {
			carSearchService.sortCarByPrice(carSearchResponse);
		}

		return carSearchResponse;
	}
}