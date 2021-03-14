package com.mates.mates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mates.mates.model.News;
import com.mates.mates.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewsRepository repository;

	@Override
	public void save(News news) {
		repository.save(news);
	}

	@Override
	public boolean isExist(String newsTitle) {
		List<News> allNews = repository.findAll();
		for (News n: allNews) {
			if (n.getTitle().equals(newsTitle)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<News> getAllNews() {
		return repository.findAll();
	}

}
