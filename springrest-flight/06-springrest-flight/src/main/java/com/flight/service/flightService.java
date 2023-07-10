package com.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.exception.NullException;
import com.flight.exception.ResourceNotFound;
import com.flight.model.flight;
import com.flight.repository.flightDao;

@Service
public class flightService implements iflightService {
	ArrayList<flight> flights = new ArrayList<flight>();

	@Autowired
	flightDao pd;
	

	public List<flight> findAllflights() {
		return pd.getAllflights();
	}
	
	@Override
	public flight getflightById(int id) throws ResourceNotFound, NullException {
		flight updatedflight = pd.findbyId(id).orElseThrow(()-> new ResourceNotFound ("flight is not available:"+id));
				return updatedflight;
	}
	
	
	public String deleteflight(int id) {
		try {
			pd.deleteByflightId(id);
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Something went wrong";
		}
		
		return "Deletion successful :)";
	}

	@Override
	public flight getflight(int flightNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createflight(flight newflight) {
		// TODO Auto-generated method stub
		return pd.saveflight(newflight);
	}

	@Override
	public String updateFlight(flight fl, int id) {
		// TODO Auto-generated method stub
		if (pd.updateflight(fl, id) == 1)return "Flight Updated Successfully";else
			return "Error can't update flight";}
	}
	
	


