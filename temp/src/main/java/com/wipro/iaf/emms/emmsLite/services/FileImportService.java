package com.wipro.iaf.emms.emmsLite.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.iaf.emms.emmsLite.Repository.AssetRepository;
import com.wipro.iaf.emms.emmsLite.utility.SAXParser;

@Service
public class FileImportService {
	@Autowired
	private SAXParser sParser; 
	
	@Autowired
	AssetRepository assetRepository;

	public void parse(MultipartFile file, String contentType, String fileName) {
		if (contentType.contains("xml")) {
			InputStream inputStream;
			try {
				inputStream = new BufferedInputStream(file.getInputStream());
				sParser.readXML(inputStream, fileName, assetRepository);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (contentType.contains("zip")) {
			ArrayList<File> files = extract(file);
			for(File extractedfile : files){
				try {
					sParser.readXML(new FileInputStream(extractedfile), extractedfile.getName(), assetRepository);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private ArrayList<File> extract(MultipartFile zipFile) {
		ArrayList<File> files = new ArrayList<File>();
		byte[] buffer = new byte[(int) zipFile.getSize()];
		try {
			ZipInputStream zis = new ZipInputStream(zipFile.getInputStream());
			ZipEntry zipEntry = zis.getNextEntry();

			while (zipEntry != null) {
				File tempFile = File.createTempFile(zipEntry.getName(),"");
				if(!zipEntry.isDirectory()) {
					FileOutputStream fos = new FileOutputStream(tempFile.getAbsoluteFile());
					int len;
					
					while((len = zis.read(buffer)) > 0){
						fos.write(buffer, 0, len);
					}
					
					files.add(tempFile);
					tempFile.deleteOnExit();
					fos.close();
				} else {
					System.out.println("NO file");
				}
				zis.closeEntry();
				zipEntry = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return files;
	}
}
