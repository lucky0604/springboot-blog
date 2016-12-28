package com.lucky.web;

import com.github.pagehelper.PageInfo;
import com.lucky.domain.Category;
import com.lucky.service.CategoryService;
import com.lucky.utils.JsonView;
import com.lucky.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lucky on 12/28/16.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public JsonView getAll(PageRequest pageRequest) {
        PageInfo pageInfo = categoryService.findAll(pageRequest);
        return JsonView.success(pageInfo);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/all", "/front/all"})
    public JsonView getAll() {
        List<Category> categories = categoryService.findAll();
        return JsonView.success(categories);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public JsonView getOne(@PathVariable long id) {
        Category category = categoryService.getOne(id);
        return JsonView.success(category);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public JsonView save(@RequestBody Category category) {
        categoryService.save(category);
        return JsonView.success();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public JsonView delete(@PathVariable long id) {
        categoryService.delete(id);
        return JsonView.success();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public JsonView update(@RequestBody Category category) {
        categoryService.update(category);
        return JsonView.success();
    }

}
