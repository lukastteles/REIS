package com.br.uepb.controller;

import org.springframework.stereotype.Controller;
 
@Controller
public class MyFileUploadController {
 
   /*
    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == MyUploadForm.class) {
 
            // Register to handle the conversion between the multipart object
            // and byte array.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
 
    // GET: Show upload form page.
    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model model) {
 
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
 
        // Forward to "/WEB-INF/pages/uploadOneFile.jsp".
        return "uploadOneFile";
    }
 
    // POST: Do Upload
    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
 
        return this.doUpload(request, model, myUploadForm);
 
    }
 
    // GET: Show upload form page.
    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
    public String uploadMultiFileHandler(Model model) {
 
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
 
        // Forward to "/WEB-INF/pages/uploadMultiFile.jsp".
        return "uploadMultiFile";
    }
 
    // POST: Do Upload
    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
 
        return this.doUpload(request, model, myUploadForm);
 
    }
 
    private String doUpload(HttpServletRequest request, Model model, //
            MyUploadForm myUploadForm) {
 
        String description = myUploadForm.getDescription();
        System.out.println("Description: " + description);
 
     
        String uploadRootPath = request.getContextPath();
        System.out.println("uploadRootPath=" + uploadRootPath);
 
        File uploadRootDir = new File(uploadRootPath);
        //
        // Create directory if it not exists.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = myUploadForm.getFileDatas();
        //
        List<File> uploadedFiles = new ArrayList<File>();
        for (CommonsMultipartFile fileData : fileDatas) {
 
      
            // Client File Name
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);
 
            if (name != null && name.length() > 0) {
                try {
                    // Create the file on server
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
  
                    // Stream to write data to file in server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    //
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadResult";
    }
 */
}
