package com.sbs.starter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.starter.dto.Article;
import com.sbs.starter.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j //이걸 해야 log.info(..)가 가능, 디버깅 용도
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/list")
	public String showList(Model aModel) {
		List<Article> list = articleService.getList();
		int totalCount = articleService.getTotalCount();
		
		log.info("list : " + list);
		aModel.addAttribute("list", list);
		aModel.addAttribute("totalCount", totalCount);
		// request.getAttribute("list", list); 와 똑같은 표현!
		
		return "article/list";
	}
	
	@RequestMapping("/article/add")
	public String showAdd() {
		return "article/add";
	}
	
	@RequestMapping("/article/doAdd")
	@ResponseBody
	public String doAdd(@RequestParam Map<String, Object> param) {
		long newId = articleService.add(param);
		
		String msg = newId+ "번 게시물이 추가되었습니다.";
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./detail?id=" + newId + "');");
		
		sb.insert(0, "<script>");
		sb.append("</script>");
		
		return sb.toString();
	}
}