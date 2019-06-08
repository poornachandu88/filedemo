package com.example.filedemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.filedemo.payload.UploadFileResponse;
import com.example.filedemo.service.FileStorageService;
import com.example.filedemo.service.UploadFileResponseService;

@Controller
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private UploadFileResponseService uploadFileResponseService;
    
    @ModelAttribute("uploadFileResponse")
    public UploadFileResponse getPerson(){
        return new UploadFileResponse();
    }
    
    @GetMapping("/")
    public ModelAndView pageload() {
    
        return new ModelAndView("index");
    }

    @PostMapping("/uploadFile")
    public ModelAndView uploadFile(
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("filecoverimage") MultipartFile filecoverimage,
    		@RequestParam("year") String year) {
        String fileNamedata = fileStorageService.storeFile(file);
        String fileNameimage = fileStorageService.storeFile(filecoverimage);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileNamedata)
                .toUriString();
        String fileCoverImageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileNameimage)
                .toUriString();
       UploadFileResponse uploadFileResponse2=new UploadFileResponse();
       uploadFileResponse2.setYear(year);
       uploadFileResponse2.setFilecoverimage(fileNameimage);
       uploadFileResponse2.setFileName(fileNamedata);
       uploadFileResponse2.setFileDownloadUri(fileDownloadUri);
       uploadFileResponse2.setFilecoverimageDownloadUri(fileCoverImageDownloadUri);
       uploadFileResponse2.setSize(file.getSize());
       uploadFileResponse2.setFileType(file.getContentType());
       
       UploadFileResponse result= uploadFileResponseService.addCustomer(uploadFileResponse2);
       ModelAndView mv=new ModelAndView("index");
       if(result.getId()!=0){
       mv.addObject("success", "Upload File Success");
       }
       else{
           mv.addObject("failure", "Upload File Failure");
           }
        return mv;
    }
    
    
    @GetMapping(value = "/listFiles")
	public String getCountries(Model model) {
 
		List<UploadFileResponse> listOfCountries = uploadFileResponseService.getAllCustomers();
		model.addAttribute("country", new UploadFileResponse());
		model.addAttribute("listOfCountries", listOfCountries);
		return "listdata";
	}
    
    

  /*  @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/

   @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
