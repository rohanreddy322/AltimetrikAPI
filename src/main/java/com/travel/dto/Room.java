
package com.travel.dto;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "booking_code", "room_type_code", "rate_plan_code", "total_amount", "rates", "descriptions",
		"room_type_info", "rate_type_code" })
public class Room {

	@JsonProperty("booking_code")
	private String bookingCode;
	@JsonProperty("room_type_code")
	private String roomTypeCode;
	@JsonProperty("rate_plan_code")
	private String ratePlanCode;
	@JsonProperty("total_amount")
	private TotalAmount totalAmount;
	@JsonProperty("rates")
	private List<Rate> rates = null;
	@JsonProperty("descriptions")
	private List<String> descriptions = null;
	@JsonProperty("room_type_info")
	private RoomTypeInfo roomTypeInfo;
	@JsonProperty("rate_type_code")
	private String rateTypeCode;

	@JsonProperty("booking_code")
	public String getBookingCode() {
		return bookingCode;
	}

	@JsonProperty("booking_code")
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	@JsonProperty("room_type_code")
	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	@JsonProperty("room_type_code")
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	@JsonProperty("rate_plan_code")
	public String getRatePlanCode() {
		return ratePlanCode;
	}

	@JsonProperty("rate_plan_code")
	public void setRatePlanCode(String ratePlanCode) {
		this.ratePlanCode = ratePlanCode;
	}

	@JsonProperty("total_amount")
	public TotalAmount getTotalAmount() {
		return totalAmount;
	}

	@JsonProperty("total_amount")
	public void setTotalAmount(TotalAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	@JsonProperty("rates")
	public List<Rate> getRates() {
		return rates;
	}

	@JsonProperty("rates")
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	@JsonProperty("descriptions")
	public List<String> getDescriptions() {
		return descriptions;
	}

	@JsonProperty("descriptions")
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	@JsonProperty("room_type_info")
	public RoomTypeInfo getRoomTypeInfo() {
		return roomTypeInfo;
	}

	@JsonProperty("room_type_info")
	public void setRoomTypeInfo(RoomTypeInfo roomTypeInfo) {
		this.roomTypeInfo = roomTypeInfo;
	}

	@JsonProperty("rate_type_code")
	public String getRateTypeCode() {
		return rateTypeCode;
	}

	@JsonProperty("rate_type_code")
	public void setRateTypeCode(String rateTypeCode) {
		this.rateTypeCode = rateTypeCode;
	}

}
