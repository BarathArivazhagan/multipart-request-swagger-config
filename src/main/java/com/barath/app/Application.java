package com.barath.app;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostMapping(value="/upload",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value="File upload ",consumes="multipart/form-data")
	@ApiImplicitParam( name = "file",paramType = "form",allowMultiple = false,required = true)
	public ResponseEntity<String> uploadFile( MultipartHttpServletRequest request) throws IOException {
		
		ResponseEntity<String> response=null;
		Map<String, MultipartFile> fileMap=request.getFileMap();
		MultipartFile file=fileMap.entrySet().stream().findFirst().get().getValue();
		if(log.isInfoEnabled()){
			log.info("request received {}",file);
		}
		
		
		if(file !=null && !file.isEmpty()){			
			response=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);	
			
		}else{
			response=new ResponseEntity<String>("FAILURE",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		 return response;
	}
	
	@PostMapping(value="/uploadFiles",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadMultipartFiles( MultipartFile[] files) throws IOException {
		
		ResponseEntity<String> response=null;
		
		if(log.isInfoEnabled()){
			log.info("request received {}",files[0]);
		}
		
		MultipartFile file=files[0];
		if(file !=null && !file.isEmpty()){			
			response=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);	
			
		}else{
			response=new ResponseEntity<String>("FAILURE",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		 return response;
	}
	
	@PostMapping(value="/uploadFile",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadMultipartFile( MultipartFile file,MultipartHttpServletRequest request) throws IOException {
		
		ResponseEntity<String> response=null;
		
		if(log.isInfoEnabled()){
			log.info("request received {}",file);
		}
		
		
		if(file !=null && !file.isEmpty()){			
			response=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);	
			
		}else{
			response=new ResponseEntity<String>("FAILURE",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		 return response;
	}
	
	@PostMapping(value="/uploadMap",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadMultipartMap( MultiValueMap<String, MultipartFile> fileMap) throws IOException {
		
		
		ResponseEntity<String> response=null;
		MultipartFile file=fileMap.entrySet().stream().findFirst().get().getValue().get(0);
		if(log.isInfoEnabled()){
			log.info("request received {}",file);
		}
		
		
		if(file !=null && !file.isEmpty()){			
			response=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);	
			
		}else{
			response=new ResponseEntity<String>("FAILURE",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		 return response;
	}
}
