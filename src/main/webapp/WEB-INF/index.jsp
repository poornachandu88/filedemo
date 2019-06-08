<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>

<!-- <script type="text/javascript">
'use strict';

var singleUploadForm = document.querySelector('#singleUploadForm');

var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var filecoverimage = document.querySelector('#filecoverimage');
var year = document.querySelector('#year');

var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');
var filecoverimageError = document.querySelector('#filecoverimageError');
var filecoverimageSuccess = document.querySelector('#filecoverimageSuccess');
var yearError = document.querySelector('#yearError');
var yearSuccess = document.querySelector('#yearSuccess');

var multipleUploadForm = document.querySelector('#multipleUploadForm');
var multipleFileUploadInput = document.querySelector('#multipleFileUploadInput');
var multipleFileUploadError = document.querySelector('#multipleFileUploadError');
var multipleFileUploadSuccess = document.querySelector('#multipleFileUploadSuccess');

function uploadSingleFile(file1,file2) {
    var formData = new FormData();
    formData.append("file", file1);
    formData.append("filecoverimage", file2);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = 
            	"<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" 
            + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}
singleUploadForm.addEventListener('submit', function(event){
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Please select a file";
        singleFileUploadError.style.display = "block";
    }
    uploadSingleFile(files[0],files[1]);
    event.preventDefault();
}, true);

 function uploadMultipleFiles(files) {
    var formData = new FormData();
    for(var index = 0; index < files.length; index++) {
        formData.append("files", files[index]);
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadMultipleFiles");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            multipleFileUploadError.style.display = "none";
            var content = "<p>All Files Uploaded Successfully</p>";
            for(var i = 0; i < response.length; i++) {
                content += "<p>DownloadUrl : <a href='" + response[i].fileDownloadUri + "' target='_blank'>" + response[i].fileDownloadUri + "</a></p>";
            }
            multipleFileUploadSuccess.innerHTML = content;
            multipleFileUploadSuccess.style.display = "block";
        } else {
            multipleFileUploadSuccess.style.display = "none";
            multipleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
} 




 multipleUploadForm.addEventListener('submit', function(event){
    var files = multipleFileUploadInput.files;
    if(files.length === 0) {
        multipleFileUploadError.innerHTML = "Please select at least one file";
        multipleFileUploadError.style.display = "block";
    }
    uploadMultipleFiles(files);
    event.preventDefault();
}, true);
 

</script>
 -->
 
 <script type="text/javascript">
 function validate(){

	    if($('#singleFileUploadInput').val() == ''){
	        alert("File Attachment Required");
	        $('#singleFileUploadInput').focus();

	        return false;
	    }
	    if($('#filecoverimage').val() == ''){
	        alert("File Attachment Required");
	        $('#filecoverimage').focus();

	        return false;
	    }
	    if($('#year').val() == ''){
	        alert("Enter Year");
	        $('#year').focus();

	        return false;
	    }
	    
	    
	}
 
 
 
 </script>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Choose File</title>
       <!--  <link rel="stylesheet" href="/css/main.css" /> -->
    </head>
    <body>
        <noscript>
            <h2>Sorry! Your browser doesn't support Javascript</h2>
        </noscript>
     
               
                  
                    <form:form id="singleUploadForm" name="singleUploadForm" modelAttribute="uploadFileResponse"
                    method="post" action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data">
                    
                  <table>
		<tr>
			<th colspan="2">Fill the Details and UploadFile</th>
		</tr>
		<tr>
	          <form:hidden path="id" />
          <td><label > TargetFile :</label></td>
          <td>
            <input id="singleFileUploadInput" type="file" name="file" size="30" maxlength="30" />
                      <span id="singleFileUploadError"></span>
                        <span id="singleFileUploadSuccess"></span> 
          </td>
            
                      
                  
        </tr>
		<tr>
			    <td><label > CoverFile : </label></td>
          <td>   <input id="filecoverimage" type="file" name="filecoverimage"  size="30" maxlength="30"  />
            <span id="filecoverimageError"></span>
                        <span id="filecoverimageSuccess"></span> 
                    </td>
		</tr>
		<tr>
			    <td><label >  Year  :  </label></td>
          <td>      <input id="year" type="text" name="year" size="30" maxlength="30"/>
           <span id="yearError"></span>
                        <span id="yearSuccess"></span> 
                        </td>
		</tr>
		  
		
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" onclick="validate()"/></td>
		</tr>
		<tr>
		<td><span style="color: green;">${success}</span></td>
		<td><span style="color: red;">${failure}</span></td>
		
		</tr>
	
	</table>   
	
	<a href="${pageContext.request.contextPath}/listFiles">getListoffiles</a>
                    
                    </form:form>
                
              
               <!--  <div class="multiple-upload">
                    <h3>Upload Multiple Files</h3>
                    <form id="multipleUploadForm" name="multipleUploadForm">
                        <input id="multipleFileUploadInput" type="file" name="files" class="file-input" multiple required />
                        <button type="submit" class="primary submit-btn">Submit</button>
                    </form>
                    <div class="upload-response">
                        <div id="multipleFileUploadError"></div>
                        <div id="multipleFileUploadSuccess"></div>
                    </div>
                </div> -->
       
       <!--  <script src="/js/main.js" ></script> -->
    </body>
</html>