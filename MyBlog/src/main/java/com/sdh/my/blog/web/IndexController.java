package com.sdh.my.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sdh.my.blog.exception.NotFoundException;

@Controller
public class IndexController {

	@GetMapping("/{username}/{password}")
	public String resp(@PathVariable String username,@PathVariable String password) {
//		int i = 1/0;
//		String blog = null;
//		if(blog == null) {
//			throw new NotFoundException("博客不存在");
//		}
		System.out.println("------------index------------");
		return "index";
	}
}
