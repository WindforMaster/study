package com.mapper;

import com.pojo.News_comment;
import com.pojo.News_commentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface News_commentMapper {
    long countByExample(News_commentExample example);

    int deleteByExample(News_commentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(News_comment record);

    int insertSelective(News_comment record);

    List<News_comment> selectByExample(News_commentExample example);

    News_comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") News_comment record, @Param("example") News_commentExample example);

    int updateByExample(@Param("record") News_comment record, @Param("example") News_commentExample example);

    int updateByPrimaryKeySelective(News_comment record);

    int updateByPrimaryKey(News_comment record);
}