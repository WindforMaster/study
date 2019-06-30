package com.service.impl;

import com.mapper.News_commentMapper;
import com.mapper.News_detailMapper;
import com.pojo.*;
import com.service.INewsdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NewsdetailServiceImpl implements INewsdetailService {


    @Autowired
    private News_detailMapper news_detailMapper;
    @Autowired
    private News_commentMapper news_commentMapper;
    @Override
    public List<News_comment> selectNewsComment() {
      /*return news_commentMapper.selectByExample(null);*/
 return null;
    }

    @Override
    public List<News_detail> show(PageBean page) {
        News_detailExample n = new News_detailExample();
        News_detailExample.Criteria cc = n.createCriteria();

        //这里是条件分分区
        if (page.getName()!=null){
            cc.andTitleLike("%"+page.getName()+"%");
        }

        //这里处理page
        int count= (int) news_detailMapper.countByExample(n);
        int size=page.getSize();
        int totalPage=(count%size==0)?(count/size):(count/size+1);
        page.setCount(count);
        page.setTotalPage(totalPage);

        //分页
        int startRow=(page.getCurrPage()-1)*size;
        n.limit(startRow,size);

        List<News_detail> news1 = news_detailMapper.selectByExample(n);

        return news1;
    }

    @Override
    public int deleteById(int id) {
        News_commentExample nc = new News_commentExample();
        News_commentExample.Criteria cc = nc.createCriteria();
        cc.andNewsidEqualTo(id);
        news_commentMapper.deleteByExample(nc);
        return news_detailMapper.deleteByPrimaryKey(id);
    }


    //
    @Override
    public List<News_comment> selectComment(int id,PageBean page) {
        News_commentExample nc = new News_commentExample();
        News_commentExample.Criteria cc = nc.createCriteria();

        cc.andNewsidEqualTo(id);
        int count= (int) news_commentMapper.countByExample(nc);
        int size=page.getSize();
        int totalPage=(count%size==0)?(count/size):(count/size+1);
        page.setCount(count);
        page.setTotalPage(totalPage);

        //分页
        int startRow=(page.getCurrPage()-1)*size;
        nc.limit(startRow,size);

        List<News_comment> comments = news_commentMapper.selectByExample(nc);

        return comments;
    }

    @Override
    public int addComment(News_comment comment) {
        comment.setCreatedate(new Date());
        int i1 = news_commentMapper.insertSelective(comment);
        return i1;
    }
}
