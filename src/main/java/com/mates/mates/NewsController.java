package com.mates.mates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mates.mates.model.News;
import com.mates.mates.service.NewsService;

@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@GetMapping(value = "/news")
	public List<News> getNews() {
		return newsService.getAllNews();
	}
}
