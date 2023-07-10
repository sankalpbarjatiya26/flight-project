package com.flight.model;

public class flight {

	private int id;
	private String flight_name;
	private String departure_from;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getDeparture_from() {
		return departure_from;
	}

	public void setDeparture_from(String departure_from) {
		this.departure_from = departure_from;
	}

	public String getDeparture_to() {
		return departure_to;
	}

	public void setDeparture_to(String departure_to) {
		this.departure_to = departure_to;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private String departure_to;
	private int price;
	
	public flight(int id, String flight_name, String departure_from, String departure_to, int price) {
		super();
		this.id=id;
		this.flight_name=flight_name;
		this.departure_from=departure_from;
		this.departure_to=departure_to;
		this.price=price;
	}

	public flight() {
		// TODO Auto-generated constructor stub
	}
}
