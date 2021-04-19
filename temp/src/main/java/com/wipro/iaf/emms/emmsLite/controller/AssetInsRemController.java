package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.AssetInsRemEntity;
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


	@GetMapping("/viewAssetInsRem/{workorderId}")
	public List<AssetInsRemEntity>getAssetRemByWoId(@PathVariable("workorderId") Long workorderId){
		System.out.println("Asset remove List based on WOID:: "+workorderId);
		return assetInsRemService.assetRemSet(workorderId);
	}
	@PostMapping("/createRemRow/{workorderId}")
	public ResponseEntity<WorkOrderResponseBean> createRemRow(@RequestBody AssetInsRemEntity assetInsRemEntity, @PathVariable("workorderId") Long workorderId ){
		try {
			System.out.println("Create Remove Asset row for WoID:: "+workorderId+"Asset Remove Enitity:: "+assetInsRemEntity.toString());
			assetInsRemService.createRemRow(workorderId, assetInsRemEntity);
			return new ResponseEntity<>(workorderResponseBean,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);		}
	}
}
