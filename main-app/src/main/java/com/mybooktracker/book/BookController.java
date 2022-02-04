package com.mybooktracker.book;


import java.util.Optional;

import com.mybooktracker.userbooks.UserBooks;
import com.mybooktracker.userbooks.UserBooksPrimaryKey;
import com.mybooktracker.userbooks.UserBooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Responsible for /book/id requests
@Controller
public class BookController {

    private final String COVER_IMAGE_ROOT = "http://covers.openlibrary.org/b/id/";

    @Autowired BookRepository bookRepository;

    @Autowired UserBooksRepository userBooksRepository;




    @GetMapping(value = "/books/{bookId}")
    public String getBook(@PathVariable String bookId, Model model, @AuthenticationPrincipal OAuth2User prinicpal){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            String coverImageUrl = "/images/no_image.jpg";
            if(book.getCoverIds() != null && book.getCoverIds().size() > 0){
                coverImageUrl = COVER_IMAGE_ROOT + book.getCoverIds().get(0) + "-L.jpg";
            } 
            model.addAttribute("coverImage", coverImageUrl);
            model.addAttribute("book", book);
            

            //if the user is authenticated add the login id into the model
            if(prinicpal != null && prinicpal.getAttribute("login") != null){
                String userId  = prinicpal.getAttribute("login");
                model.addAttribute("loginId", userId);

                //checks if there is book in userbook repository
                UserBooksPrimaryKey key = new UserBooksPrimaryKey();
                key.setBookId(bookId);
                key.setUserId(userId);

                Optional<UserBooks> userBooks = userBooksRepository.findById(key);

                if(userBooks.isPresent()){
                    model.addAttribute("userBooks", userBooks.get());
                }else{
                    model.addAttribute("userBooks",new UserBooks());
                }
            }

            return "book";
        }
        return "book-not-found";
    }
}
