package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Book;
import org.example.service.BookService;
import org.example.vo.ResultJson;
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
    public ResultJson<Book> findBookById(@RequestParam("bid") String bid){
        return bookService.searchBookById(bid);
    }

    @GetMapping("/findAllColumn")
    public ResultJson<List<Book>> findBooksByAllColumn(@RequestParam("contain") String contain){
        return bookService.searchBooksByAllColumn(contain);
    }

    @PostMapping("/decrease")
    public ResultJson<Boolean> decreaseStockBook(@RequestParam("bid") String bid,@RequestParam("num") Integer num){
        return bookService.decreaseStockBook(bid,num);
    }

    @PostMapping("/increase")
    public ResultJson<Boolean> increaseStockBook(@RequestParam("bid") String bid,@RequestParam("num") Integer num){
        return bookService.increaseStockBook(bid,num);
    }

    @PostMapping("/newBook/{uid}")
    public ResultJson<Boolean> newBook(@RequestBody Book book,@PathVariable("uid") String uid){
        return bookService.addNewBook(book,uid);
    }
}
