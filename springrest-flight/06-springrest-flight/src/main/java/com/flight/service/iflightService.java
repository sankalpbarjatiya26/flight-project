package com.flight.service;
import java.util.List;

import com.flight.exception.NullException;
import com.flight.exception.ResourceNotFound;
import com.flight.model.flight;
public interface iflightService {

	List<flight> findAllflights();
	flight getflight(int flightNo);
	
	
	String deleteflight(int flightNo);
	
	int createflight(flight newflight);
	flight getflightById(int id) throws ResourceNotFound, NullException;
	String updateFlight(flight fl, int id);
}
