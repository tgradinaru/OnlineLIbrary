package com.sda.traianszabi.onlinelibrary.service;

import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.model.Category;
import com.sda.traianszabi.onlinelibrary.repository.BookRepository;
import com.sda.traianszabi.onlinelibrary.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void addBook(Book book, Category category){
        bookRepository.save(book);
        categoryRepository.save(category);
    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }
}
