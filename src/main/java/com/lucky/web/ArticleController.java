package com.lucky.web;

import com.github.pagehelper.PageInfo;
import com.lucky.domain.Article;
import com.lucky.service.ArticleService;
import com.lucky.utils.JsonView;
import com.lucky.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lucky on 12/28/16.
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, value = {"/{id}", "/front/{id}"})
    public JsonView getById(@PathVariable long id) {
        Article article = articleService.findById(id);
        return JsonView.success(article);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"", "/front"})
    public JsonView getAll(PageRequest pageRequest) {
        PageInfo pageInfo = articleService.findAll(pageRequest);
        return JsonView.success(pageInfo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public JsonView delete(@PathVariable long id) {
        articleService.updateToDeleted(id);
        return JsonView.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public JsonView save(@RequestBody Article article) {
        articleService.save(article);
        return JsonView.success();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public JsonView update(@RequestBody Article article) {
        articleService.update(article);
        return JsonView.success();
    }

}
