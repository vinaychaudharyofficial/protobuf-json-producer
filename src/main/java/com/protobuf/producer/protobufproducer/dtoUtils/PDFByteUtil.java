package com.protobuf.producer.protobufproducer.dtoUtils;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class PDFByteUtil {


    @Autowired
    ResourceLoader resourceLoader;

    public  String getDocumentByte() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:formdata.pdf");
        InputStream inputStream = resource.getInputStream();
        String pdfStream =  FileCopyUtils.copyToString(new InputStreamReader(inputStream));
        return  pdfStream;
    }
}
