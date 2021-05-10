package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
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
		
		if(recordId.contains("1")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BBBBBBBBBBBBB");
		}
		
		try {
			sorties = fLBSortieARRepository.findAllByRecordId(recordId);
			System.out.println("Sorties fetched from repo" + sorties.toString());
		} catch (Exception e) {
			System.out.println("Some Error occured while fetching sortie from repo");
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Some Error occured while fetching sortie from repo", e);
		}

		System.out.println("++++++++++++++++++++end of flb findByRecordId++++++++++++++++++++");
		return sorties;
	}

	// Returns true if new row is created and false otherwise
	public FlbSortieAREntity createSortie(String recordId, FlbSortieAREntity newRow) {
		System.out.println("++++++++++++++++++++Inside flb createSortie++++++++++++++++++++");
		if (newRow != null) {
			try {
				newRow.setRecordId(recordId);
				System.out.println("Inserting new row in DB");
				fLBSortieARRepository.save(newRow);
				System.out.println("New row inserted");
			} catch (DataIntegrityViolationException dive) {
				System.out.println("This sortie already exists or Some required data not received");
				System.out.println(dive.getMessage());
				throw new ResponseStatusException(HttpStatus.CONFLICT, "This sortie already exists or Some required data not received");				
			} catch (Exception e) {
				System.out.println("Some Error occured");
				System.out.println(e.getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Erro", e);
			}
		} else {
			System.out.println("Bad request");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		System.out.println("++++++++++++++++++++end of flb createSortie++++++++++++++++++++");
		return newRow;
	}

	// Save all the sorties
	public void saveSorties(String recordId, List<FlbSortieAREntity> sortieList) {
		System.out.println("++++++++++++++++++++Inside flb saveSortie Service++++++++++++++++++++");
		List<Long> unsavedIds = new ArrayList<Long>();
		if (sortieList != null) {
			for (FlbSortieAREntity sortie : sortieList) {
				try {
					System.out.println("Searching Sortie with sortieNum: " + sortie.getSortieNum());
					Optional<FlbSortieAREntity> row = fLBSortieARRepository.findBySortieId(recordId,
							sortie.getSortieId());
					FlbSortieAREntity rowData = row.get();
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
					unsavedIds.add(sortie.getSortieId());
					System.out.println("Row with sortie id: " + sortie.getSortieId() + ", does not exist.");
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