package com.example.websitelab.service.Impl;

import com.example.websitelab.dto.NewsDto;
import com.example.websitelab.entity.News;
import com.example.websitelab.repository.NewsRepository;
import com.example.websitelab.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    @Override
    public News createNews(NewsDto newsDto){
        if (Objects.isNull(newsDto)){
            System.out.println("Null");
        }
        News news = new News();
        news.setText(newsDto.getText());

        return newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

    @Override
    public News deleteNews(Long newsId) {
        if (Objects.isNull(newsId)) {
            System.out.println("Null");
        }
        Optional<News> optionalNews = newsRepository.findById(newsId);
        return optionalNews.map(news -> {
            newsRepository.delete(news);
            return news;
        }).orElse(null);
    }
    @Override
    public News updateNews(Long newsId, NewsDto updatedNewsDto) {
        if (Objects.isNull(newsId) || Objects.isNull(updatedNewsDto)) {
            System.out.println("Null");
        }
        Optional<News> optionalNews = newsRepository.findById(newsId);
        return optionalNews.map(news -> {
            news.setText(updatedNewsDto.getText());
            return newsRepository.save(news);
        }).orElse(null);
    }

}
