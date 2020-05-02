package com.zio.wj.service;

import com.zio.wj.dao.BookDao;
import com.zio.wj.pojo.Book;
import com.zio.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired(required = false)
    private BookDao bookDao;
    @Autowired(required = false)
    private CategoryService categoryService;

    public List<Book> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return bookDao.findAll(sort);
    }

    public Book addOrUpdate(Book book) {
        return bookDao.save(book);
    }

    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }

    public List<Book> findAllByCategoryId(Integer cid) {
        Category category = categoryService.findById(cid);
        return bookDao.findAllByCategory(category);
    }
}
