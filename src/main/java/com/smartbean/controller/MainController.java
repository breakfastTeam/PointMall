package com.smartbean.controller;

import com.smartbean.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/")
public class MainController {
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("**************************");
		return "index";
	}
}
