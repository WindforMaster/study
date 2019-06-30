package com.controller;

import com.pojo.News_comment;
import com.pojo.News_detail;
import com.pojo.PageBean;
import com.service.INewsdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class Controller1 {


    @Autowired
    private INewsdetailService service;


     @RequestMapping("/toComment1/{id}")
    public String toComment1(@PathVariable String id , Model model){
         model.addAttribute("id",id);

           return "addComment";
    }

    @RequestMapping("/toComment")
    public String toComment(News_comment comment){

       int j= service.addComment(comment);

        return "redirect:/news/show";


    }

     @RequestMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable String id)  {

        int i= service.deleteById(Integer.parseInt(id));

         return "redirect:/news/show";


    }


    //这个就是去查询comment这个表然后展示  但是查看的是这条新闻下面的所有评论
@RequestMapping("/lookComment/{id}")
    public ModelAndView toComment(@PathVariable String id,ModelAndView mav,PageBean page){
    //这个是新闻的id
         int i = Integer.parseInt(id);

         List<News_comment>  comments=service.selectComment(i,page);
    //System.out.println(comments);
       mav.addObject("comments",comments);
       mav.addObject("page",page);
       mav.setViewName("showComment");
         return mav;
}


    @RequestMapping("/show")
    public ModelAndView show(PageBean page, ModelAndView mav){
        //这是查询第二张表的,如果数据关联的有显示的话需要使用
      //  List<News_comment> newsComment= service.selectNewsComment();


        //这是主数据第一张表的查询结果
        List<News_detail> news1=service.show(page);

        //把查到的第一张表 ,第二张表  和page 存入域中
     // mav.addObject("newsComment",newsComment);
      mav.addObject("news1",news1);
      mav.addObject("page",page);

      mav.setViewName("show");

      return mav;
    }
}
