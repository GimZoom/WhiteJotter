package com.zio.wj.controller;

import com.zio.wj.pojo.Book;
import com.zio.wj.service.BookService;
import com.zio.wj.utils.ResultVOUtil;
import com.zio.wj.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResultVO<List<Book>> findAll() throws Exception {
        List<Book> books = bookService.findAll();
        return ResultVOUtil.success(books);
    }

    @PostMapping("/books")
    public ResultVO<Book> addOrUpdate(@RequestBody Book book) throws Exception {
        Book b = bookService.addOrUpdate(book);
        return ResultVOUtil.success(b);
    }

    @PostMapping("/books/delete/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id) throws Exception {
        bookService.deleteById(id);
        return ResultVOUtil.success();
    }

    @GetMapping("/books/cid/{cid}")
    public ResultVO<List<Book>> findByCategoryId(@PathVariable("cid") Integer cid) throws Exception {
        List<Book> books;
        if (cid == 0) {
            books = bookService.findAll();
        } else {
            books = bookService.findAllByCategoryId(cid);
        }
        return ResultVOUtil.success(books);
    }
}
