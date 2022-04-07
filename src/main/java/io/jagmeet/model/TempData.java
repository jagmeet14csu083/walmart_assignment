package io.jagmeet.model;

import java.util.Date;

public class TempData {

	private Long id;
	private String temperature;
	private String humidity;
	private String location;
	private Date timeStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date date) {
		this.timeStamp = date;
	}

	@Override
	public String toString() {
		return "XmlData [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + ", location="
				+ location + "]";
	}

	public TempData() {
		super();
		// TODO Auto-generated constructor stub
	}

}
