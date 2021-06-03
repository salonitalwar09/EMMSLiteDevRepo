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
import com.wipro.iaf.emms.emmsLite.beans.IMeterQueryResponseBean;
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



	public List<WoMeterLookupResponse> getAssetLookup(int flag){
		ArrayList<String> woMeterQueryList = new ArrayList<>();
		List<WoMeterLookupResponse> woMeterLookupResponseList =  new ArrayList<>();
		
		if(flag==0)
		woMeterQueryList = (ArrayList<String>) woMeterRepository.getAssetLookupQuery();	//for asset and remove buildItem query
		else 
			woMeterQueryList = (ArrayList<String>) woMeterRepository.getInstallBuildItemLookup();	//for remove builtItem query
		System.out.println("Wo_meter list from db- "+woMeterQueryList.toString());

		for(String ListNumber :woMeterQueryList ){
			WoMeterLookupResponse woMeterLookupResponse=new WoMeterLookupResponse();
			int size=woMeterLookupResponseList.size();
			System.out.println("size of response array - "+size);

			String delimatedArray[]=ListNumber.split(",");
			woMeterLookupResponse.setAssetNum_meterLookup(delimatedArray[0]);
			woMeterLookupResponse.setBuildItem(delimatedArray[1]);
			woMeterLookupResponse.setPosition(delimatedArray[2]);
			woMeterLookupResponse.setLcn(delimatedArray[3]);
			woMeterLookupResponse.setSerialNum(delimatedArray[4]);
			woMeterLookupResponse.setAssetDescription_assetLookup(delimatedArray[5]);
			woMeterLookupResponse.setAssetId_assetLookup(delimatedArray[6]);
			woMeterLookupResponse.setPartNumber_meterLookup(delimatedArray[7]);
			woMeterLookupResponse.setPartDescription_meterLookup(delimatedArray[8]);
			woMeterLookupResponse.setStatusCode(200);
			woMeterLookupResponse.setStatusString("Workorder asset and meter lookup data rendered");
			woMeterLookupResponseList.add(woMeterLookupResponse);
		}
		System.out.println("Workorder asset and_meter lookup data rendered");
		System.out.println("Asset description bean ----- "+woMeterLookupResponseList.toString());
		return woMeterLookupResponseList;
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

	public List<IMeterQueryResponseBean> getMeterLookupById(String assetNum) {
		List<IMeterQueryResponseBean> bean  =  woMeterRepository.getMeterLookupQueryById(assetNum);
		System.out.println("response bean from db query-- "+bean.toString());
		return bean;
	}

	public List<WoMeterEntity> getMeterById(Long workOrderId) {
		List<WoMeterEntity> WoMeterList =woMeterRepository.findMeterDetailsById(workOrderId);
		if(!WoMeterList.isEmpty())
			WoMeterList.get(0).setStatusCode(200);
		return WoMeterList;
	}

	public WoMeterLookupResponse deleteMeterDetails(int woMeterId) {
		WoMeterLookupResponse woMeterLookupResponse=new WoMeterLookupResponse();
		if(woMeterRepository.findById(woMeterId)!=null) {
			woMeterRepository.deleteById(woMeterId);
			woMeterLookupResponse.setStatusCode(200);
		}
		else {
			woMeterLookupResponse.setStatusCode(500);
		}
		return woMeterLookupResponse;
	}
}

