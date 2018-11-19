
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "start_date", "end_date", "currency_code", "price" })
public class Rate {

	@JsonProperty("start_date")
	private String startDate;
	@JsonProperty("end_date")
	private String endDate;
	@JsonProperty("currency_code")
	private String currencyCode;
	@JsonProperty("price")
	private Integer price;

	@JsonProperty("start_date")
	public String getStartDate() {
		return startDate;
	}

	@JsonProperty("start_date")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("end_date")
	public String getEndDate() {
		return endDate;
	}

	@JsonProperty("end_date")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	@JsonProperty("currency_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@JsonProperty("price")
	public Integer getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Integer price) {
		this.price = price;
	}

}
