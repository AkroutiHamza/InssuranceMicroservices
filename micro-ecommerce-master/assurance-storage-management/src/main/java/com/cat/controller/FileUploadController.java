package com.cat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cat.storage.FileStorage;
import com.mongodb.gridfs.GridFSDBFile;


@Controller
public class FileUploadController {

    @Autowired
    private FileStorage fileStorage;

	public FileUploadController(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }


  public FileUploadController() {
	super();
	// TODO Auto-generated constructor stub
	}


	public FileStorage getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {

        HashMap<String, String> allFiles = new HashMap<>();

        fileStorage.getAll().forEach(file -> allFiles.put(file.getId().toString(), file.getFilename()));

        model.addAttribute("files", allFiles);
        return "uploadForm";
    }
  
	@RequestMapping(value = "/{fileId}")
	@ResponseBody
	public ResponseEntity<InputStreamResource> serveFile(@PathVariable String fileId) {

		Optional<GridFSDBFile> file = fileStorage.read(fileId);

		if (file.isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; fileName=\"" + file.get().getFilename() + "\"")
					.contentType(MediaType.parseMediaType("application/octet-stream"))

					.body(new InputStreamResource(file.get().getInputStream()));

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        try {
            fileStorage.save(file.getInputStream(), file.getOriginalFilename(),file.getContentType());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        try {
            fileStorage.save(file.getInputStream(), file.getOriginalFilename(),file.getContentType());
        } catch (IOException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("File was upload");
    }
}
