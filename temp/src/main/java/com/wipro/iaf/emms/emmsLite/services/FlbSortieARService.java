package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.FlbSortieARRepository;
import com.wipro.iaf.emms.emmsLite.beans.CommonResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FlbSortieAREntity;

@Service
public class FlbSortieARService {

	// Auto generated value of sortie id and let user enter sortie num
	@Autowired
	private FlbSortieARRepository fLBSortieARRepository;

	// Returns a list of FLB sorties corresponding to a record ID
	public List<FlbSortieAREntity> findByRecordId(String recordId) {
		System.out.println("++++++++++++++++++++Inside flb findByRecordId++++++++++++++++++++");
		List<FlbSortieAREntity> sorties = null;

		try {
			sorties = fLBSortieARRepository.findAllByRecordId(recordId);
			System.out.println("Sorties fetched from repo");
		} catch (Exception e) {
			System.out.println("Some Error occured while fetching sortie from repo");
			System.out.println(e.getMessage());
		}

		System.out.println("++++++++++++++++++++end of flb findByRecordId++++++++++++++++++++");
		return sorties;
	}

	// Returns true if new row is created and false otherwise
	public CommonResponseBean createSortie(String recordId, FlbSortieAREntity newRow) {
		System.out.println("++++++++++++++++++++Inside flb createSortie++++++++++++++++++++");
		CommonResponseBean response = new CommonResponseBean();
		String message = "";
		if (newRow != null) {
			try {
				newRow.setRecordId(recordId);
				System.out.println("Inserting new row in DB");
				fLBSortieARRepository.save(newRow);
				response.setStatus(HttpStatus.CREATED);
				message = "Sortie added successfully";
				System.out.println("New row inserted");
			} catch (DataIntegrityViolationException dive) {
				System.out.println("This sortie already exist in DB");
				response.setStatus(HttpStatus.CONFLICT);
				message = "This sortie already exists or Some required data not received";
				System.out.println(dive.getMessage());
			} catch (Exception e) {
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
		System.out.println("++++++++++++++++++++end of flb createSortie++++++++++++++++++++");
		return response;
	}

	// Save all the sorties
	public CommonResponseBean saveSorties(String recordId, List<FlbSortieAREntity> sortieList) {
		System.out.println("++++++++++++++++++++Inside flb saveSortie Service++++++++++++++++++++");
		CommonResponseBean response = new CommonResponseBean();
		response.setStatus(HttpStatus.OK);
		String message = "Sorties Added Successfully";
		List<String> unsavedIds = new ArrayList<String>();
		if (sortieList != null) {
			for (FlbSortieAREntity sortie : sortieList) {
				try {
					System.out.println("Searching Sortie with sortieNum: " + sortie.getSortieNum());
					Optional<FlbSortieAREntity> row = fLBSortieARRepository.findBySortieNum(recordId,
							sortie.getSortieNum());
					FlbSortieAREntity rowData = row.get();
					System.out.println(rowData);
					if (rowData != null) {
						System.out.println("Sortie Exist");
						if (sortie.getDuration() != null) {
							rowData.setDuration(sortie.getDuration());
						}
						if (sortie.getEtd() != null) {
							rowData.setEtd(sortie.getEtd());
						}
						if (sortie.getEtdDate() != null) {
							rowData.setEtdDate(sortie.getEtdDate());
						}
						if (sortie.getFltType() != null) {
							rowData.setFltType(sortie.getFltType());
						}
						if (sortie.getReason() != null) {
							rowData.setReason(sortie.getReason());
						}
						if (sortie.getRemarks() != null) {
							rowData.setRemarks(sortie.getRemarks());
						}
						if (sortie.getSortieDate() != null) {
							rowData.setSortieDate(sortie.getSortieDate());
						}
						if (sortie.getStatus() != null) {
							rowData.setStatus(sortie.getStatus());
						}
						if (sortie.getStatusDate() != null) {
							rowData.setStatusDate(sortie.getStatusDate());
						}
						System.out.println("Inserting data in table");
						fLBSortieARRepository.save(rowData);
						System.out.println("Data inserted");
					}
				} catch (Exception e) {
					unsavedIds.add(sortie.getSortieNum());
					response.setStatus(HttpStatus.PARTIAL_CONTENT);
					System.out.println("Row with sortie num: " + sortie.getSortieNum() + ", does not exist.");
					System.out.println(e.getMessage());
				}
			}
		}
		if (unsavedIds.size() > 0) {
			message = "Following ids are not saved: " + unsavedIds.toString();
		}
		response.setMessage(message);
		System.out.println("++++++++++++++++++++end of flb saveSortie Service++++++++++++++++++++");
		return response;
	}

}