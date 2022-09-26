package service.impl;

import dto.Books;
import services.BooksService;

import java.util.ArrayList;
import java.util.UUID;

public class BooksServiceImpl implements BooksService {
    public ArrayList<Books> booksList = new ArrayList<>();

    @Override
    public ArrayList<Books> list() {
        return booksList;
    }

    @Override
    public Books getByName(String name) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getName().equals(name)) {
                return booksList.get(i);
            }
        }
        return new Books();
    }

    @Override
    public UUID add(Books book) {
        booksList.add(book);
        return book.getId();
    }

    @Override
    public void delete(UUID bookId) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getId().equals(bookId)) {
                booksList.remove(i);
            }
        }

    }
}



