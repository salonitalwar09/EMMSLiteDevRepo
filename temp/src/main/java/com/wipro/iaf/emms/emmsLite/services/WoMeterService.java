/**
 * 
 */
package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.WoMeterRepository;
import com.wipro.iaf.emms.emmsLite.beans.WoMeterLookupResponse;

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
		//woMeterLookupResponse = (List<WoMeterLookupResponse>) woMeterRepository.getAssetLookupQuery();	

		System.out.println("Wo_meter list 0- "+woMeterQueryList.get(0));
		System.out.println("Wo_meter list 1- "+woMeterQueryList.get(1));
		
		for(String ListNumber :woMeterQueryList ){
			System.out.println("inside for loop - "+ListNumber);
			
			int size=woMeterLookupResponseList.size();
			System.out.println("size of response array - "+size);
			
			String delimatedArray[]=ListNumber.split(",");
			
			WoMeterLookupResponse woMeterLookupResponse=new WoMeterLookupResponse();
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

}
