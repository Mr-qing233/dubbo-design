package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findAllColumn")
    public List<Book> findBooksByAllColumn(@RequestParam("contain") String contain){
        return bookService.searchBooksByAllColumn(contain);
    }

    @PostMapping("/decrease")
    public boolean decreaseStockBook(@RequestParam("bid") String bid,@RequestParam("num") Integer num){
        return bookService.decreaseStockBook(bid,num);
    }

    @PostMapping("/increase")
    public boolean increaseStockBook(@RequestParam("bid") String bid,@RequestParam("num") Integer num){
        return bookService.increaseStockBook(bid,num);
    }
}
