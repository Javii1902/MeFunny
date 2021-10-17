package com.mefunny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {

	private String awsAccessKeyId = System.getenv("AWS_ACCESS_KEY_ID");
	private String awsSecretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY");
	private String awsRegion = System.getenv("AWS_REGION");
	
	@Bean
	public AmazonS3 generateS3client() {
		AWSCredentials s3Credentials = 
				new BasicAWSCredentials(awsAccessKeyId,awsSecretAccessKey);
		
		return AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(s3Credentials))
			.withRegion(awsRegion)
			.build();
			
	}
}
