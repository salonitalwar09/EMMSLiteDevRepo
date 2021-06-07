package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.iaf.emms.emmsLite.Repository.FlbPostFlightRepository;
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
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Some Error occured while fetching sortie from repo", e);
		}
		
		System.out.println("++++++++++++++++++++end of flb post flight findByRecordId++++++++++++++++++++");
		return postFlightData;
	}

	
	public FlbPostFlightEntity createPostFlightData(String recordId, FlbPostFlightEntity newRow) {
		System.out.println("++++++++++++++++++++Inside flb post flight findByRecordId++++++++++++++++++++");
		//Code starts here
		if (newRow != null) {
			try {
				newRow.setRecordId(recordId);
				System.out.println("Inserting new row in DB");
				flbPostFlightRepository.save(newRow);
				System.out.println("New row inserted");
			}
			catch(DataIntegrityViolationException dive) {
				System.out.println("This Post flight already exist in DB");
				System.out.println(dive.getMessage());
				throw new ResponseStatusException(HttpStatus.CONFLICT,
						"This postFlight already exists or Some required data not received");
			}
			catch(Exception e) {
				System.out.println("Some Error occured");
				System.out.println(e.getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Error", e);
			}
		} else {
			System.out.println("Bad request");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		System.out.println("++++++++++++++++++++end of flb post flight findByRecordId++++++++++++++++++++");
		return newRow;
	}
	
	public void savePostFlightData(String recordId, List<FlbPostFlightEntity> postFlightList) {
		System.out.println("++++++++++++++++++++Inside flb savePostFlight Service++++++++++++++++++++");
		List<Long> unsavedIds = new ArrayList<Long>();
		if (postFlightList != null) {
			for (FlbPostFlightEntity postFlight : postFlightList) {
				try {
					System.out.println("Searching postFlight with id: " + postFlight.getPostFltId());
					Optional<FlbPostFlightEntity> row = flbPostFlightRepository.findById(postFlight.getPostFltId());
					FlbPostFlightEntity rowData = row.get();
					if (rowData != null) {
						System.out.println("Post Flight Exist");
						if (postFlight.getArrivalTime() != null) {
							rowData.setArrivalTime(postFlight.getArrivalTime());
						}
						if (postFlight.getDepartureTime() != null) {
							rowData.setDepartureTime(postFlight.getDepartureTime());
						}
						if (postFlight.getFlbStatus() != null) {
							rowData.setFlbStatus(postFlight.getFlbStatus());
						}
						if (postFlight.getFltDate() != null) {
							rowData.setFltDate(postFlight.getFltDate());
						}
						if (postFlight.getFltHours() != null) {
							rowData.setFltHours(postFlight.getFltHours());
						}
						if (postFlight.getFltType() != null) {
							rowData.setFltType(postFlight.getFltType());
						}
						System.out.println("Inserting data in table");
						flbPostFlightRepository.save(rowData);
						System.out.println("Data inserted");
					}
				} catch (Exception e) {
					unsavedIds.add(postFlight.getPostFltId());
					System.out.println(e.getMessage());
				}
			}
		}
		if (unsavedIds.size() > 0) {
			String message = "Following ids are not saved: " + unsavedIds.toString();
			throw new ResponseStatusException(HttpStatus.PARTIAL_CONTENT, message);
		}
		System.out.println("++++++++++++++++++++end of flb saveSortie Service++++++++++++++++++++");
	}

}
