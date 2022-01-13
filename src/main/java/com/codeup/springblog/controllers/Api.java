//package com.codeup.springblog.controllers;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@RequestMapping("/facts")
//public class Api {
//
//
//
//	@GetMapping("/facts")
//	private String Facts(){
//		String url = "https://api.api-ninjas.com/v1/facts?limit=3";
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(url, String.class);
//		return result;
//	}
//
//	URL url = new URL("https://api.api-ninjas.com/v1/facts?limit=3");
//	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//connection.setRequestProperty("accept", "application/json");
//	InputStream responseStream = connection.getInputStream();
//	ObjectMapper mapper = new ObjectMapper();
//	JsonNode root = mapper.readTree(responseStream);
//System.out.println(root.path("fact").asText());
//}
