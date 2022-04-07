package io.jagmeet.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import io.jagmeet.model.TempData;

@Service
public class DataService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private XmlMapper xmlMapper;

	private static List<TempData> data = new ArrayList<>();

	public TempData getDataFromEndPoint() {
		try {
			String xmlData = restTemplate.getForObject("https://whispering-temple-65255.herokuapp.com/xmlTelemetry",
					String.class);
			TempData xml = xmlMapper.readValue(xmlData, TempData.class);
			return xml;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Scheduled(cron = "0 * * * * *")
	public void readData() {
		System.out.println("Reading date from API");
		TempData xml = getDataFromEndPoint();
		if (xml != null) {
			xml.setTimeStamp(new Date());
		}
		System.out.println(xml);
		data.add(xml);

	}

	@Scheduled(cron = "0 0/5 * * * ?")
	public void writeData() {
		System.out.println("Writing json data into file");
		// Write JSON file
		try (FileWriter file = new FileWriter("temp_data.json")) {
			String json = new Gson().toJson(data);
			file.write(json);
			file.flush();
			data.clear();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
