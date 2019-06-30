package com.service;

import com.pojo.News_comment;
import com.pojo.News_detail;
import com.pojo.PageBean;

import java.util.List;

public interface INewsdetailService {
    List<News_comment> selectNewsComment();

    List<News_detail> show(PageBean page);

    int deleteById(int parseInt);

    List<News_comment> selectComment(int id,PageBean page);

    int addComment(News_comment comment);

}
