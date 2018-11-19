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

import com.travel.dto.HotelSearchResponse;
import com.travel.dto.RestException;
import com.travel.enums.TravelEnum;
import com.travel.generic.GenericRestClient;
import com.travel.generic.GenericRestEnum;

@RestController
@RequestMapping("/hotel")
public class HotelSearchController {

	@Autowired
	private GenericRestClient genericRestClient;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${travel.api.key}")
	private String apikey;

	@RequestMapping(value = "/searchHotel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelSearchResponse searchHotel(@RequestParam(name = "location", required = true) String location,
			@RequestParam(name = "checkIn", required = true) String checkIn,
			@RequestParam(name = "checkOut", required = true) String checkOut,
			@RequestParam(name = "radius", required = false) String radius,
			@RequestParam(name = "amenity", required = false) String amenity,
			@RequestParam(name = "numberOfResults", required = false) String numberOfResults)
			throws InvalidParameterException, IOException, RestException {

		StringBuffer url = new StringBuffer();
		url.append(TravelEnum.SEARCH_HOTEL.getValue()).append("?apikey=").append(apikey).append("&location=")
				.append(location).append("&check_in=").append(checkIn).append("&check_out=").append(checkOut);
		if (StringUtils.isNotBlank(radius)) {
			url.append("&radius=").append(radius);
		}
		if (StringUtils.isNotBlank(amenity)) {
			String[] amenityArr = StringUtils.split(amenity, ",");
			if (null != amenityArr && amenityArr.length > 0) {
				for (String eachAmenity : amenityArr) {
					if (StringUtils.isNotBlank(eachAmenity)) {
						url.append("&amenity=").append(eachAmenity);
					}
				}
			}
		}
		if (StringUtils.isNotBlank(numberOfResults)) {
			url.append("&number_of_results=").append(numberOfResults);
		}
		Map<String, Object> result = genericRestClient.invokeRest(url.toString(), null, null, HttpMethod.GET);
		Object responseBody = genericRestClient.getResponseValue(result, GenericRestEnum.RESPONSE_BODY.getValue());
		objectMapper.disable(Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		int statusCode = Integer
				.valueOf(genericRestClient.getResponseValue(result, GenericRestEnum.RESPONSE_STATUS.getValue()) + "");
		if (statusCode != HttpStatus.OK.value()) {
			throw new RestException(statusCode, responseBody.toString());
		}
		HotelSearchResponse hotelSearchResponse = objectMapper.readValue(responseBody.toString(),
				HotelSearchResponse.class);
		return hotelSearchResponse;
	}
}