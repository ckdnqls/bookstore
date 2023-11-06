package com.sparta.bookstore.controller;

import com.sparta.bookstore.dto.BookRequestDto;
import com.sparta.bookstore.dto.BookResponseDto;
import com.sparta.bookstore.entity.Bookstore;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BookController {
    private final Map<Long, Bookstore> bookList = new HashMap<>();
    @PostMapping("/books")
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto){
        Bookstore book = new Bookstore(requestDto);

        Long maxId = bookList.size() > 0 ? Collections.max(bookList.keySet())+1 : 1;
        book.setBookId(maxId);

        bookList.put(book.getBookId(), book);
        BookResponseDto bookResponseDto = new BookResponseDto(book);

        return bookResponseDto;
    }

    @GetMapping("/books")
    public List<BookResponseDto> getBooklist(){
        List<BookResponseDto> responseList = bookList.values().stream()
                .map(BookResponseDto::new).toList();
        return responseList;
    }
    @GetMapping("/books/{bookid}")
    public BookResponseDto getBook(@PathVariable Long bookid){

        if(bookList.containsKey(bookid)){
            List<BookResponseDto> chekList = bookList.values().stream()
                    .map(BookResponseDto::new).toList();
            int chekbookid = bookid.intValue()-1;
            return chekList.get(chekbookid);
        }else {
            throw  new IllegalArgumentException("선택한 책은 존재하지 않습니다.");
        }
    }


    @PutMapping("/books/{bookid}")
    public Long updateBook(@PathVariable Long bookid, @RequestBody BookRequestDto requestDto){
        if(bookList.containsKey(bookid)){
            Bookstore book = bookList.get(bookid);
            book.update(requestDto);
            return book.getBookId();
        }else {
            throw  new IllegalArgumentException("선택한 책은 존재하지 않습니다.");
        }
    }


    @DeleteMapping("/books/{bookid}")
    public Long deleteBook(@PathVariable Long bookid, @RequestParam Integer password){
        if(bookList.containsKey(bookid)&&password==bookList.get(bookid).getPassword()){
            bookList.remove(bookid);
            return bookid;
        }else {
            throw new IllegalArgumentException("선택한 책은 존재하지 않습니다.");
        }
    }


}
