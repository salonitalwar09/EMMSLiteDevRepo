package com.wipro.iaf.emms.emmsLite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.iaf.emms.emmsLite.beans.XmlResponseBean;
import com.wipro.iaf.emms.emmsLite.services.FileImportService;

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileImportController {
	
	@Autowired
	FileImportService fileImportService;
	@Autowired
	XmlResponseBean response; 
	
	@PostMapping("/importXml")
	public XmlResponseBean importXML(@RequestParam("files") MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String contentType = file.getContentType();
		
		response = new XmlResponseBean(fileName, contentType);

		System.out.println(fileName + " " + contentType);
		
		fileImportService.parse(file, contentType, fileName);
		
		return response;
	}
}
