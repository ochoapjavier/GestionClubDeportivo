package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UploadFileResponseTest {

    @Test
    public void testConstructorYGetters() {
        UploadFileResponse response = new UploadFileResponse(
            "test.jpg",
            "/download/test.jpg",
            "image/jpeg",
            1024,
            1L
        );

        assertEquals("test.jpg", response.getFileName());
        assertEquals("/download/test.jpg", response.getFileDownloadUri());
        assertEquals("image/jpeg", response.getFileType());
        assertEquals(1024, response.getSize());
        assertEquals(1L, response.getFileID());
    }

    @Test
    public void testSetters() {
        UploadFileResponse response = new UploadFileResponse(null, null, null, 0, 0);
        
        response.setFileName("document.pdf");
        response.setFileDownloadUri("/download/doc.pdf");
        response.setFileType("application/pdf");
        response.setSize(2048);
        response.setFileID(2L);

        assertEquals("document.pdf", response.getFileName());
        assertEquals("/download/doc.pdf", response.getFileDownloadUri());
        assertEquals("application/pdf", response.getFileType());
        assertEquals(2048, response.getSize());
        assertEquals(2L, response.getFileID());
    }
}