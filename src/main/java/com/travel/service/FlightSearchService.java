package com.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.dto.FlightSearchResponse;
import com.travel.dto.Result;

@Service
public class FlightSearchService {

	public void sortFlightByDuration(FlightSearchResponse flightSearchResponse) {
		if (null != flightSearchResponse) {
			List<Result> results = flightSearchResponse.getResults();
			results.sort((Result o1, Result o2) -> o1.getItineraries().get(0).getOutbound().getDuration()
					.compareTo(o2.getItineraries().get(0).getOutbound().getDuration()));
		}
	}
}