
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "company_code", "company_name" })
public class Provider {

	@JsonProperty("company_code")
	private String companyCode;
	@JsonProperty("company_name")
	private String companyName;

	@JsonProperty("company_code")
	public String getCompanyCode() {
		return companyCode;
	}

	@JsonProperty("company_code")
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("company_name")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
