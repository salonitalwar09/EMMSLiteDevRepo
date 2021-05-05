package com.wipro.iaf.emms.emmsLite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.GenerateIdRepository;

@Service
public class GenerateIdService {

	@Autowired
	GenerateIdRepository generateidrepository;

	public int keyValue(String key){
		try {
			System.out.println("value of key from Constants :: "+key);
			int keyValue = generateidrepository.getKeyValue(key);
			System.out.println("KeyValue from DB :: "+keyValue);
			if (keyValue==0) {
				System.out.println("Generate key :: "+keyValue);
				generateidrepository.generateKeyCounter(key);
			}else{
				System.out.println("update Key:: "+keyValue);
				//generateidrepository.updateKeyCounter(key); Not Req to Set incremented Counter in DB:: Shivam
			}
			keyValue++;
			return keyValue;	

		} catch (Exception e) {
			System.out.println("Exception Occured:: "+e.getMessage());
			return 0;
		}
		
	}
	public String getPrefix(String key){
		String prefix = generateidrepository.getPrefix(key);
		System.out.println("get Prefix"+prefix);
		return prefix;
	}

}
