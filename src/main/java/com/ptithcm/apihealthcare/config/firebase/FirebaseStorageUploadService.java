package com.ptithcm.apihealthcare.config.firebase;

import com.google.api.client.util.Value;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class FirebaseStorageUploadService {

    public String upload(String dir, String fileName,
                         byte[] data, String contentType) throws StorageException {
        Blob file = StorageClient.getInstance().bucket()
                .create(dir + "/" + fileName, data, contentType);
        URL url = StorageClient.getInstance().bucket().getStorage().signUrl(file, 5, TimeUnit.DAYS, Storage.SignUrlOption.withV4Signature());
        String signedPath = url.toString();

        return signedPath;
    }
}
