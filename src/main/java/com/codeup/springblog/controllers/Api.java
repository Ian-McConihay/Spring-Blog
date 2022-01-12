package com.codeup.springblog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class Api {


	@RestController
	@RequestMapping()
	public String apiCall{

		try {

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestProperty("accept", "application/json");

		InputStream responseStream = connection.getInputStream();

		ObjectMapper mapper = new ObjectMapper();

		JsonNode root = mapper.readTree(responseStream);

		System.out.println(root.path("fact").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	URL url = new URL("https://api.api-ninjas.com/v1/facts?limit=3");

	public Api() throws MalformedURLException {
	}
}
