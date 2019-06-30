package com.pojo;

import java.util.Date;

public class News_comment {
    private Integer id;

    private Integer newsid;

    private String content;

    private String author;

    private Date createdate;

    private News_detail news_detail;

    public News_detail getNews_detail() {
        return news_detail;
    }

    public void setNews_detail(News_detail news_detail) {
        this.news_detail = news_detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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