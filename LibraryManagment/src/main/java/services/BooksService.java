package services;

import dto.Books;

import java.util.ArrayList;
import java.util.UUID;

public interface BooksService {
    ArrayList<Books> list();

    Books getByName(String name);

    UUID add(Books book);

    void delete(UUID bookId);
}
