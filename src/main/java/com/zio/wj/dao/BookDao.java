package com.zio.wj.dao;

import com.zio.wj.pojo.Book;
import com.zio.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Integer> {
    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String title, String author);
}
