package com.flight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.exception.NullException;
import com.flight.exception.ResourceNotFound;
import com.flight.model.flight;
import com.flight.service.iflightService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	iflightService flightService;
	
	@GetMapping("/fly")
	@ResponseBody
	public ResponseEntity<List<flight>> findall()
	{List<flight> flightlist = flightService.findAllflights();
	System.out.println(flightlist);
	return new ResponseEntity<List<flight>>(flightlist, HttpStatus.OK);
	}
	
	
	@GetMapping("/flight/{id}")
	flight findByflightId(@PathVariable int id) throws ResourceNotFound, NullException
	{return flightService.getflightById(id);}
	
	@GetMapping("/flight")
	public flight getflight(@RequestParam(defaultValue="1") int id) {
		return flightService.getflight(id);
	}
		
	@DeleteMapping("/flight/{id}")
	String deleteByflightId(@PathVariable int id)
	{return flightService.deleteflight(id);}
	
	@PostMapping ("/flight")
	public int createflight (@RequestBody flight newflight) {
		return flightService.createflight(newflight);
	}
	
	@PutMapping(path="/flight/{id}")
	public flight updateFlight(@RequestBody flight fl,@PathVariable int id)
	{
		flightService.updateFlight(fl,id);
		return fl;
	}
}


	