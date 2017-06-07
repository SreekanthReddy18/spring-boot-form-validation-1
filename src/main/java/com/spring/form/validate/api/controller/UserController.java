package com.spring.form.validate.api.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.form.validate.api.model.User;

@Controller
public class UserController {

	@GetMapping("/")
	public String showForm(User user) {
		return "register";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid User user,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "register";
		} else {
			model.addAttribute("user", user);
			return "success";
		}
	}

}
