package com.example.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

@Service
public class SMMSService {
    @Value("${smms.token}")
    private String token;

    public SMMSResult upload(InputStream fileStream, String fileName, String userAgent) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuidName = StringUtils.join(UUID.randomUUID().toString().split("-"));
        File file = new File(uuidName + suffix);
        FileCopyUtils.copy(fileStream, new FileOutputStream(file));
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("smfile", file.getName(),
                        RequestBody.create(file, MediaType.parse("multipart/form-data")))
                .build();
        Request request = new Request.Builder()
                .addHeader("User-Agent", userAgent)
                .addHeader("Authorization", token)
                .url("https://sm.ms/api/v2/upload")
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (file.exists()) {
                file.delete();
            }
            String json = Objects.requireNonNull(response.body()).string();
            JSONObject jsonObject = JSONObject.parseObject(json);
            if ("image_repeated".equals(jsonObject.getString("code"))) {
                SMMSResult result = new SMMSResult();
                result.setFilename(fileName);
                result.setUrl(jsonObject.getString("images"));
                return result;
            }else {
                return JSON.parseObject(String.valueOf(jsonObject.getJSONObject("data")), SMMSResult.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
