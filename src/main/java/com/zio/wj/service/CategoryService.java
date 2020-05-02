package com.zio.wj.service;

import com.zio.wj.dao.CategoryDao;
import com.zio.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category findById(Integer id){
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
