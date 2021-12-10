package com.ptithcm.apihealthcare.config.firebase;

import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FirebaseStorageFileUploadService {
    @Autowired
    private FirebaseStorageUploadService firebaseStorageUploadService;

    public static final String BASE_PACKAGE_NAME = "com.ptithcm.apihealrhcare";

    public String uploadFileToFirebaseStorage(MultipartFile multipartFile) {
        try {

            String contentType = multipartFile.getContentType();
            String storageDir;
            if (contentType.startsWith("image")) {
                storageDir = "images";
            } else {
                storageDir = "files";
            }
            String downloadUrl = firebaseStorageUploadService.upload(
                    BASE_PACKAGE_NAME + "/" + storageDir,
                    multipartFile.getOriginalFilename(), multipartFile.getBytes(), contentType);
            return downloadUrl;
        } catch (IOException e) {
            return null;
        }
    }
}
