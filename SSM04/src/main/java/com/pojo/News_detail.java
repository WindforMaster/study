package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class News_detail {
    private Integer id;

    private String title;

    private String summary;

    private String author;
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdate;

    private News_comment news_comment;

    public News_comment getNews_comment() {
        return news_comment;
    }

    public void setNews_comment(News_comment news_comment) {
        this.news_comment = news_comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}