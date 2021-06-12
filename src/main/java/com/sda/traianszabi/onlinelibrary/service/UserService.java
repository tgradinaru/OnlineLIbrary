package com.sda.traianszabi.onlinelibrary.service;

import com.sda.traianszabi.onlinelibrary.model.LibraryAccount;
import com.sda.traianszabi.onlinelibrary.model.User;
import com.sda.traianszabi.onlinelibrary.repository.LibraryAccountRepository;
import com.sda.traianszabi.onlinelibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    private final LibraryAccountRepository libraryAccountRepository;
    private final UserRepository userRepository;

    public UserService(LibraryAccountRepository libraryAccountRepository, UserRepository userRepository) {
        this.libraryAccountRepository = libraryAccountRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public void addUser(LibraryAccount libraryAccount, User user) {
        libraryAccountRepository.save(libraryAccount);
        userRepository.save(user);
    }

    public Iterable<LibraryAccount> getUserLibraryAccounts() {
        return libraryAccountRepository.findAll();
    }

}
