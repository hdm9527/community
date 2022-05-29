package com.example.controller;

import com.example.dto.FileDTO;
import com.example.provider.SMMSResult;
import com.example.provider.SMMSService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class FileController {
    @Resource
    private SMMSService smmsService;

    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("editormd-image-file");
        String userAgent  = request.getHeader("User-Agent");
        try {
            assert multipartFile != null;
            if (multipartFile.getSize() > 5242880) {
                FileDTO fileDTO = new FileDTO();
                fileDTO.setSuccess(0);
                fileDTO.setMessage("图片上传大小限制5MB");
                return fileDTO;
            }
            SMMSResult smmsResult = smmsService.upload(multipartFile.getInputStream(), Objects.requireNonNull(multipartFile.getOriginalFilename()), userAgent);
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(1);
            fileDTO.setUrl(smmsResult.getUrl());
            return fileDTO;
        } catch (Exception e) {
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            return fileDTO;
        }
    }
}
