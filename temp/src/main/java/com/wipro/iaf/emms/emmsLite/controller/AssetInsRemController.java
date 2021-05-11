package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.AlndomainEntity;
import com.wipro.iaf.emms.emmsLite.entity.AssetInsRemEntity;
import com.wipro.iaf.emms.emmsLite.services.AlndomainService;
import com.wipro.iaf.emms.emmsLite.services.AssetInsRemService;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Asset Install Remove Controller
 *
 */
@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssetInsRemController {

	@Autowired
	WorkOrderResponseBean workorderResponseBean;
	@Autowired
	AssetInsRemEntity assetInsRemEntity;
	@Autowired
	AssetInsRemService assetInsRemService;
	@Autowired
	AlndomainService alndomainService;


	@GetMapping("/viewAssetInsRem/{workorderId}")
	public List<AssetInsRemEntity>getAssetRemByWoId(@PathVariable("workorderId") Long workorderId){
		System.out.println("Asset remove List based on WOID:: "+workorderId);
		return assetInsRemService.assetRemSet(workorderId);
	}
	@GetMapping("/viewRemReason")
	public List<AlndomainEntity>getRemReason(){
		System.out.println("Removal Reason List ");
		return alndomainService.RemReasonSet();
	}
	/*Not Required to be fetch from DB, We will fetch Hardcoded values:: Shivam
	 * 
	 * @GetMapping("/viewJobType")
	public List<AlndomainEntity>getJobType(){
		System.out.println("JobType List ");
		return alndomainService.jobTypeSet();
	}

	@GetMapping("/viewRemType")
	public List<AlndomainEntity>getRemType(){
		System.out.println("Removal Type List ");
		return alndomainService.remTypeSet();
	}*/
	@PostMapping("/createInsRemRow/{workorderId}")
	public ResponseEntity<WorkOrderResponseBean> createInsRemRow(@RequestBody AssetInsRemEntity assetInsRemEntity, @PathVariable("workorderId") Long workorderId ){
		try {
			System.out.println("Create Install / Remove Asset row for WoID:: "+workorderId+"Asset InstallRemove Enitity:: "+assetInsRemEntity.toString());
			assetInsRemService.createInsRemRow(workorderId, assetInsRemEntity);
			return new ResponseEntity<>(workorderResponseBean,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);	
		}
	}
	@PutMapping("/assetInsRem/{workorderId}/{insRemId}")
	public ResponseEntity<String> assetInsRemFunction(@PathVariable Long workorderId, @PathVariable Long insRemId){
		try {
			System.out.println("WorkorderId from Path Variable:: "+workorderId );
			System.out.println("Install/Remove RecordId from Path Variable:: "+insRemId);
			return  new ResponseEntity<>("Asset Instal/ Remove Successfull",HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
		}
	}
}
