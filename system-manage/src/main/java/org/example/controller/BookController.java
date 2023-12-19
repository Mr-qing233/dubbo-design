package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @DubboReference
    private BookService bookService;

    /**
     * 根据bid搜索书籍信息
     * @param bid 书籍id
     */
    @GetMapping("/findBookById")
    public Book findBookById(@RequestParam("bid") String bid){
        return bookService.searchBookById(bid);
    }
}
