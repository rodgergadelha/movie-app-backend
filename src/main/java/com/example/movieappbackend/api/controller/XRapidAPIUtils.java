package com.example.movieappbackend.api.controller;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class XRapidAPIUtils {
	
	private static String xrapidApiKey = System.getenv("XRAPID_API_KEY");
	
	protected static String getBaseURL() {
		return "https://streaming-availability.p.rapidapi.com/v2";
	}
	
	protected static HttpHeaders getBasicHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("X-RapidAPI-Key", xrapidApiKey);
		headers.set("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com");
		return headers;
	}
}
