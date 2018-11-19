package com.travel.generic;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericRestClient {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	private HttpHeaders httpHeaders;

	public GenericRestClient() {

	}

	public GenericRestClient(Map<String, Object> parametersMap) throws InvalidParameterException {
		this.httpHeaders = (HttpHeaders) parametersMap.get(GenericRestEnum.HTTP_HEADER.getValue());
		if (logger.isDebugEnabled()) {
			logger.debug("=== Rest Parameters are initialized ====");
		}
		setRestTemplate();
		setObjectMapper();
	}

	public Map<String, Object> invokeRest(String url, Object data, MultiValueMap<String, String> map,
			HttpMethod httpMethod) throws InvalidParameterException, IOException {
		if (StringUtils.isBlank(url)) {
			throw new InvalidParameterException("request url is NULL.");
		}
		ResponseEntity<String> response = null;
		Map<String, Object> resultMap = null;
		if (null != httpMethod && httpMethod == HttpMethod.PATCH) {
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			this.restTemplate.setRequestFactory(requestFactory);
		}
		String request = null != data ? objectMapper.writeValueAsString(data) : null;
		HttpEntity requestEntity;
		if (null != request) {
			requestEntity = new HttpEntity<String>(request, httpHeaders);
		} else {
			requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);
		}
		try {
			logger.debug("Request URL::" + url);
			response = this.restTemplate.exchange(url, httpMethod, requestEntity, String.class);
			resultMap = getSuccessResponseMap(response);
		} catch (HttpClientErrorException ex) {
			logger.error(ex.getStatusText());
			resultMap = getFailureResponseMap(ex);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			resultMap = new HashMap<String, Object>();
			resultMap.put(GenericRestEnum.RESPONSE_STATUS.getValue(), HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultMap.put(GenericRestEnum.RESPONSE_BODY.getValue(), ex.getMessage());
		}
		return resultMap;
	}

	private Map<String, Object> getSuccessResponseMap(ResponseEntity<String> response) {
		Map<String, Object> resultMap = null;
		if (null != response) {
			resultMap = new HashMap<String, Object>();
			resultMap.put(GenericRestEnum.RESPONSE_STATUS.getValue(), response.getStatusCode());
			resultMap.put(GenericRestEnum.RESPONSE_BODY.getValue(), response.getBody());
		}
		return resultMap;
	}

	private Map<String, Object> getFailureResponseMap(HttpClientErrorException ex) {
		Map<String, Object> resultMap = null;
		if (null != ex) {
			resultMap = new HashMap<String, Object>();
			resultMap.put(GenericRestEnum.RESPONSE_STATUS.getValue(), ex.getStatusCode());
			resultMap.put(GenericRestEnum.RESPONSE_BODY.getValue(), ex.getResponseBodyAsString());
		}
		return resultMap;
	}

	private void setRestTemplate() {
		if (null == restTemplate)
			restTemplate = new RestTemplate();
	}

	private void setObjectMapper() {
		if (null == objectMapper)
			objectMapper = new ObjectMapper();
	}

	public Object getResponseValue(Map<String, Object> resultMap, String param) {
		Object retVal = null;
		if (null != resultMap && !resultMap.isEmpty() && null != param) {
			switch (param) {
			case "status":
				retVal = resultMap.get(GenericRestEnum.RESPONSE_STATUS.getValue());
				break;
			case "body":
				retVal = resultMap.get(GenericRestEnum.RESPONSE_BODY.getValue());
				break;
			default:
				break;
			}
		}
		return retVal;
	}
}
