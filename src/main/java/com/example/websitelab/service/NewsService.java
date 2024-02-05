package com.example.websitelab.service;

import com.example.websitelab.dto.NewsDto;
import com.example.websitelab.entity.News;

import java.util.List;

public interface NewsService {
    News createNews(NewsDto newsDto);

    List<News> getAllNews();

    News deleteNews(Long newsId);

    News updateNews(Long newsId, NewsDto updatedNewsDto);
}
