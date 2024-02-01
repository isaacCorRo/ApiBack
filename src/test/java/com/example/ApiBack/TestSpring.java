package com.example.ApiBack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import com.example.ApiBack.models.Noticas;
import com.example.ApiBack.response.NoticiasResponseRest;
import com.example.ApiBack.service.NoticiasServiceImp;


@SpringBootTest
@ComponentScan(basePackages = "com.example.ApiBack")
class TestSpring {
	@Autowired
    private NoticiasServiceImp noticiasService;

	@Test
    public void testSavefav() {       
        Noticas noticias = new Noticas();
        noticias.setId("22427");
        noticias.setTitle("New Glenn hardware assembling at Launch Complex 36");
        noticias.setUrl("https://www.nasaspaceflight.com/2024/01/new-glenn-hardware/");
        noticias.setImageurl("https://www.nasaspaceflight.com/wp-content/uploads/2024/01/new-glenn-integration-1170x843.jpeg");
        noticias.setNews_site("NASASpaceflight");
        noticias.setSummary("As the first month of 2024 closes, Blue Origin is well into production with its orbital rocket, New Glenn. The company continues to check off major milestones as high-fidelity hardware arrives at Launch Complex 36 (LC-36) ahead of a testing campaign and a NASA mission scheduled for late 2024.");
        String try1 = "2024-01-30T21:33:59Z";
        LocalDateTime published = LocalDateTime.parse(try1, DateTimeFormatter.ISO_DATE_TIME);
        noticias.setPublishedat(published);
        String try2 = "2024-01-30T21:36:56.115000Z";
        LocalDateTime updated = LocalDateTime.parse(try2, DateTimeFormatter.ISO_DATE_TIME);
        noticias.setUpdatedat(updated);        
        ResponseEntity<NoticiasResponseRest> result = noticiasService.savefav(noticias);
        assertTrue(result.getStatusCode().is2xxSuccessful()); 
        ArrayList<HashMap<String, String>> metadataList = result.getBody().getMetadata();
        if (!metadataList.isEmpty()) {
            HashMap<String, String> metadataMap = metadataList.get(0);
            String status = metadataMap.get("description"); 
            assertEquals("OK", status);
        }
    }

}
