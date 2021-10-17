package com.mefunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mefunny.service.S3Service;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/file")

public class S3Controller {

	@Autowired 
	S3Service s3Service;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile upload) {
    	return this.s3Service.uploadFile(upload);
    }

}
