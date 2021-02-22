package com.example.devops.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ViewController {

	@Value("${api.url.kontak}")
	private String apiUrl;
	
	@GetMapping("kontak")
	public String getKontakPage(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Kontak[]> response = restTemplate.getForEntity(apiUrl, Kontak[].class);
		Kontak kontaks[] = response.getBody();
		model.addAttribute("apiUrl", apiUrl+"/kontak/all");
		model.addAttribute("kontaks", kontaks);
		return "daftar_kontak";
	}
}
