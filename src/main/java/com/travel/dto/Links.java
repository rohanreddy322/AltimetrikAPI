
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "more_rooms_at_this_hotel" })
public class Links {

	@JsonProperty("more_rooms_at_this_hotel")
	private MoreRoomsAtThisHotel moreRoomsAtThisHotel;

	@JsonProperty("more_rooms_at_this_hotel")
	public MoreRoomsAtThisHotel getMoreRoomsAtThisHotel() {
		return moreRoomsAtThisHotel;
	}

	@JsonProperty("more_rooms_at_this_hotel")
	public void setMoreRoomsAtThisHotel(MoreRoomsAtThisHotel moreRoomsAtThisHotel) {
		this.moreRoomsAtThisHotel = moreRoomsAtThisHotel;
	}

}
