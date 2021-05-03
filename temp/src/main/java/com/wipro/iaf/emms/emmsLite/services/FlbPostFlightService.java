package com.wipro.iaf.emms.emmsLite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.FlbPostFlightRepository;
import com.wipro.iaf.emms.emmsLite.beans.CommonResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FlbPostFlightEntity;

@Service
public class FlbPostFlightService {
	
	@Autowired
	FlbPostFlightRepository flbPostFlightRepository;

	// Returns a list of post flight entity with the given record ID
	public List<FlbPostFlightEntity> findByRecordId(String recordId) {
		System.out.println("++++++++++++++++++++Inside flb post flight findByRecordId++++++++++++++++++++");
		List<FlbPostFlightEntity> postFlightData = null;
		
		try {
			postFlightData = flbPostFlightRepository.findAllByRecordId(recordId);
			System.out.println("Post Flight data fetched from repo");
		}
		catch(Exception e) {
			System.out.println("Some Error occured while fetching post flight data from repo");
			System.out.println(e.getMessage());
		}
		
		System.out.println("++++++++++++++++++++end of flb post flight findByRecordId++++++++++++++++++++");
		return postFlightData;
	}

	
	public CommonResponseBean createPostFlightData(String recordId, FlbPostFlightEntity newRow) {
		System.out.println("++++++++++++++++++++Inside flb post flight findByRecordId++++++++++++++++++++");
		
		//Code starts here
		CommonResponseBean response = new CommonResponseBean();
		String message = "";
		if (newRow != null) {
			try {
				newRow.setRecordId(recordId);
				System.out.println("Inserting new row in DB");
				flbPostFlightRepository.save(newRow);
				response.setStatus(HttpStatus.CREATED);
				message = "Post Flight added successfully";
				System.out.println("New row inserted");
			}
			catch(DataIntegrityViolationException dive) {
				System.out.println("This Post flight already exist in DB");
				response.setStatus(HttpStatus.CONFLICT);
				message = "This sortie already exists or Some required data not received";
				System.out.println(dive.getMessage());
			}
			catch(Exception e) {
				System.out.println("Some Error occured");
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
				message = "Some error occurred";
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Bad request");
			message = "Bad request";
			response.setStatus(HttpStatus.BAD_REQUEST);
		}
		response.setMessage(message);
		
		
		System.out.println("++++++++++++++++++++end of flb post flight findByRecordId++++++++++++++++++++");
		return response;
	}

}
