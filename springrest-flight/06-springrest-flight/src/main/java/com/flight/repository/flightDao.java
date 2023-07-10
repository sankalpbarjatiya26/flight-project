package com.flight.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flight.model.flight;

@Repository

public class flightDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private org.springframework.jdbc.core.RowMapper<flight> rowMapper = (ResultSet rs, int rowNum) -> {
		flight flight = new flight();
		flight.setId(rs.getInt(1));
		flight.setFlight_name(rs.getString(2));
		flight.setDeparture_from(rs.getString(3));
		flight.setDeparture_to(rs.getString(4));
		flight.setPrice(rs.getInt(5));
		return flight;
	};

	public List<flight> getAllflights() {
		return jdbcTemplate.query("select * from flight", rowMapper);
	}

	public Optional<flight> findbyId(int id) {
		String sql = "select * from flight where id='" + id + "' ";
		return jdbcTemplate.query(sql, rowMapper).stream().findFirst();
	}

	public void deleteByflightId(int id) {
		String sql = " delete from flight where id='" + id + "' ";
		jdbcTemplate.execute(sql);
	}

	public int saveflight(flight e) {
		System.out.println(e.toString());
		String query = "insert into flight values( '" + e.getId() + "','" + e.getFlight_name() + "','"
				+ e.getDeparture_from() + "','" + e.getDeparture_to() + "','" + (int) e.getPrice() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateflight(flight flight, int id) {
		System.out.println("I am in dao");String query = "update flight set Flight_Name='" + flight.getFlight_name() + "',Departure_From='"+ flight.getDeparture_from() + "',Departure_To='" + flight.getDeparture_to() + "',Price="+ flight.getPrice() + " where id=" + id + ";";System.out.println(query);return jdbcTemplate.update(query);}
	}

