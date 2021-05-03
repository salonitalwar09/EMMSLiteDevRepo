/**
 * 
 */
package com.wipro.iaf.emms.emmsLite.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.WoMeterRepository;
import com.wipro.iaf.emms.emmsLite.beans.WoMeterLookupResponse;
import com.wipro.iaf.emms.emmsLite.entity.WoMeterEntity;

/**
 * @author Rachit
 *
 */

@Service
public class WoMeterService {

	@Autowired
	private WoMeterRepository woMeterRepository;

	public List<WoMeterLookupResponse> getAssetLookup(){
		ArrayList<String> woMeterQueryList = new ArrayList<>();
		List<WoMeterLookupResponse> woMeterLookupResponseList =  new ArrayList<>();

		woMeterQueryList = (ArrayList<String>) woMeterRepository.getAssetLookupQuery();	
		System.out.println("Wo_meter list from db- "+woMeterQueryList.toString());

		for(String ListNumber :woMeterQueryList ){
			WoMeterLookupResponse woMeterLookupResponse=new WoMeterLookupResponse();
			int size=woMeterLookupResponseList.size();
			System.out.println("size of response array - "+size);

			String delimatedArray[]=ListNumber.split(",");
			woMeterLookupResponse.setAssetNum_meterLookup(delimatedArray[0]);
			woMeterLookupResponse.setBuildItem(delimatedArray[1]);
			woMeterLookupResponse.setSerialNum(delimatedArray[2]);
			woMeterLookupResponse.setAssetDescription_assetLookup(delimatedArray[3]);
			woMeterLookupResponse.setAssetId_assetLookup(delimatedArray[4]);
			woMeterLookupResponse.setPartNumber_meterLookup(delimatedArray[5]);
			woMeterLookupResponse.setPartDescription_meterLookup(delimatedArray[6]);
			woMeterLookupResponse.setStatusCode(200);
			woMeterLookupResponse.setStatusString("Workorder asset and_meter lookup data rendered");
			woMeterLookupResponseList.add(woMeterLookupResponse);
		}
		System.out.println("Workorder asset and_meter lookup data rendered");
		System.out.println("Asset description bean ----- "+woMeterLookupResponseList.toString());
		return woMeterLookupResponseList;
	}

	public WoMeterLookupResponse getAssetLookupById(String assetId) {
		WoMeterLookupResponse woMeterLookupResponse=new WoMeterLookupResponse();
		String woMeterQueryResultSet =  woMeterRepository.getAssetLookupQueryById(assetId);	
		System.out.println("Wo_meter resultSet from db- "+woMeterQueryResultSet);

		if(woMeterQueryResultSet!=null) {
			String delimatedArray[]=woMeterQueryResultSet.split(",");
			woMeterLookupResponse.setAssetId_assetLookup(assetId);
			woMeterLookupResponse.setAssetNum_meterLookup(delimatedArray[0]);
			woMeterLookupResponse.setBuildItem(delimatedArray[1]);
			woMeterLookupResponse.setSerialNum(delimatedArray[2]);
			woMeterLookupResponse.setAssetDescription_assetLookup(delimatedArray[3]);
			woMeterLookupResponse.setPartNumber_meterLookup(delimatedArray[4]);
			woMeterLookupResponse.setPartDescription_meterLookup(delimatedArray[5]);
			woMeterLookupResponse.setStatusCode(200);
			woMeterLookupResponse.setStatusString("Workorder asset and_meter lookup data rendered for ");
			
			System.out.println("Workorder asset and_meter lookup data rendered with data from db--"+woMeterLookupResponse.toString());
		}
		return woMeterLookupResponse;
	}

	public WoMeterLookupResponse saveMeterDetails(Long workOrderId,WoMeterEntity woMeterInput) {
		WoMeterLookupResponse woMeterLookupResponse=new WoMeterLookupResponse();
		WoMeterEntity woMeterEntity=new WoMeterEntity();
		
		woMeterEntity.setAssetId(woMeterInput.getAssetId());
		woMeterEntity.setWorkOrderId(workOrderId);
		woMeterEntity.setAssetNum(woMeterInput.getAssetNum());
		woMeterEntity.setBuildItem(woMeterInput.getBuildItem());
		woMeterEntity.setDescription(woMeterInput.getDescription());
		woMeterEntity.setFinalValue(woMeterInput.getFinalValue());
		woMeterEntity.setInitialValue(woMeterInput.getInitialValue());
		woMeterEntity.setReadingDate(woMeterInput.getReadingDate());
		woMeterEntity.setMeterName(woMeterInput.getMeterName());
		woMeterEntity.setSerialNum(woMeterInput.getSerialNum());
		woMeterEntity.setPartNum(woMeterInput.getPartNum());
		woMeterEntity.setUpdatedBy(woMeterInput.getUpdatedBy());
		woMeterEntity.setUpdatedDate(LocalDateTime.now());
		woMeterRepository.save(woMeterEntity);
		woMeterLookupResponse.setStatusCode(200);
		woMeterLookupResponse.setStatusString("Meter data saved");
		return woMeterLookupResponse;
	}

}

