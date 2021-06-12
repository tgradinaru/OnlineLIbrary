package com.sda.traianszabi.onlinelibrary;

import com.sda.traianszabi.onlinelibrary.model.*;
import com.sda.traianszabi.onlinelibrary.repository.LibraryAccountRepository;
import com.sda.traianszabi.onlinelibrary.service.BookService;
import com.sda.traianszabi.onlinelibrary.service.CategoryService;
import com.sda.traianszabi.onlinelibrary.service.OrderService;
import com.sda.traianszabi.onlinelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sda.traianszabi.onlinelibrary.repository")
@EntityScan(basePackages = "com.sda.traianszabi.onlinelibrary.model")
public class OnlineLibraryApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LibraryAccountRepository libraryAccountRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlineLibraryApplication.class, args);
    }

    //@Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.register(AppConfig.class);
        context.refresh();

        LibraryAccount libraryAccount1 = new LibraryAccount();
        libraryAccount1.setAccountId(1L);

        User user1 = new User();
        user1.setUserId(1L);

        Book book1 = new Book();
        book1.setIsbn(1L);

        Book book2 = new Book();
        book2.setIsbn(2L);

        Category category1 = new Category();
        category1.setCategoryId(1L);
        Category category2 = new Category();
        category2.setCategoryId(2L);
        book1.setCategory(category1);
        book2.setCategory(category2);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);


/*        order1.setOrderId(1L);
        order1.setUser(user1);
        order1.setBook(book1);
        order1.setOrderDate(Date.valueOf("2021-05-31"));*/

        categoryService.addCategory(category1);
        categoryService.addCategory(category2);
        userService.addUser(libraryAccount1, user1);
        bookService.addBook(book1, category1);
        bookService.addBook(book2, category2);

        Order order1 = new Order(user1, books, Date.valueOf(LocalDate.of(2021, 06, 11)));
        orderService.addOrder(order1);

    }

}
