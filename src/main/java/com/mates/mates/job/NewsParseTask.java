package com.mates.mates.job;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mates.mates.model.News;
import com.mates.mates.service.NewsService;

@Component
public class NewsParseTask {
	@Autowired
	NewsService newsService;
	
	@Scheduled(fixedDelay = 10000)
	public void parseNews() {
		String url = "https://news.ycombinator.com/";


		try {
			Document doc = Jsoup.connect(url)
					.userAgent("Google")
					.timeout(5000)
					.referrer("https://google.com")
					.get();
			Elements news = doc.getElementsByClass("storylink");
			for (Element el: news) {
				String title = el.ownText();
				if (!newsService.isExist(title)) {
					News obj = new News();
					obj.setTitle(title);
					newsService.save(obj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
