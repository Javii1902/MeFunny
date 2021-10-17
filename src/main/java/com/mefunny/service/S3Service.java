package com.mefunny.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;


@Service
public class S3Service {
	
	
	@Autowired
	AmazonS3 s3Client;
	
    private File convertMultipartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return convertedFile;
    }
	
	public String uploadFile(MultipartFile file) {
		
		File fileObject = convertMultipartFileToFile(file);
		
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		
		s3Client.putObject( new PutObjectRequest(System.getenv("AWS_BUCKET_NAME"), filename, fileObject) );
	    
		fileObject.delete();

		return "mefunny-test-bucket.s3.amazonaws.com/" + filename;
	}
	
}
