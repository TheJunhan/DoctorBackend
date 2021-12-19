package com.example.demo.Utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileRequest {
    Integer id;
    MultipartFile file;
}
