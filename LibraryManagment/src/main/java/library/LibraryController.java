package library;

import dto.Books;
import dto.Categories;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.impl.BooksServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;


public class LibraryController implements Initializable {

    ObservableList<Books> bookList;
    @FXML
    private TableView<Books> list;
    @FXML
    private TableColumn id = new TableColumn();
    @FXML
    private TableColumn name = new TableColumn();
    @FXML
    private TableColumn author = new TableColumn();
    @FXML
    private TableColumn categoriesName = new TableColumn();
    @FXML
    private TextField bookName;
    private TextField categoryId;
    @FXML
    private TextField authorName;
    @FXML
    private Button Add;
    private final BooksServiceImpl service = new BooksServiceImpl();
    @FXML
    private ComboBox<String> categories;

    @FXML
    private TextField search;
    @FXML
    private AnchorPane root;
    @FXML
    private Button Add1;

//    Indicam variabilele si metodele la startul aplicatie

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        Chemam metoda pentru intitializarea comboboxului cu categorii
        initializeCategoryComboBox();

//       Intierea liste
        service.add(new Books(UUID.randomUUID(), "Harry Potter", "abc", "Author"));
        service.add(new Books(UUID.randomUUID(), "Java", "abc", "Some Author"));

//        se indica denumirile petru coloanele tabelului
        id.setCellValueFactory(
                new PropertyValueFactory<Books, String>("id"));
        name.setCellValueFactory(
                new PropertyValueFactory<Books, String>("name"));
        author.setCellValueFactory(
                new PropertyValueFactory<Books, String>("author"));
        categoriesName.setCellValueFactory(
                new PropertyValueFactory<Books, String>("categoryName"));

//  citirea si afisarea coloanelor
       // list.getColumns().addAll(id, name, author, categoriesName);

        refreshList();

    }

    private void refreshList() {
        ObservableList<Books> items = FXCollections.observableArrayList(service.booksList);
        FilteredList<Books> filtredList = new FilteredList<>(items, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filtredList.setPredicate(book -> {
//                daca valoarea filtrata nu este indicata returnam lista initiala
                if (newValue.isEmpty() || newValue == null) {
                    return true;
//                    filtur dupa volori
                } else if (book.getName().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (book.getAuthor().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else return book.getCategoryName().toLowerCase().contains(newValue.toLowerCase());
            });

        });
        list.setItems(filtredList);
    }

    @FXML
    public void addBook(ActionEvent event) {
        String name = bookName.getText();
        String author = authorName.getText();
        service.add(new Books(UUID.randomUUID(), name, categories.getValue(), author));
        bookName.clear();
        authorName.clear();
        refreshList();
    }

    @FXML
    public void deleteBook(ActionEvent event) {
        UUID id = list.getSelectionModel().getSelectedItem().getId();
        service.delete(id);
        refreshList();
    }

    private void initializeCategoryComboBox() {
//       creare categorii
        Categories cat1 = new Categories(UUID.randomUUID(), "Literature");
        Categories cat2 = new Categories(UUID.randomUUID(), "History");
        Categories cat3 = new Categories(UUID.randomUUID(), "Fiction");
        Categories cat4 = new Categories(UUID.randomUUID(), "Bibliography");
        Categories cat5 = new Categories(UUID.randomUUID(), "Art");
        Categories cat6 = new Categories(UUID.randomUUID(), "Philology");


//        adaugam in combobox
        categories.getItems().addAll(cat1.getName(), cat2.getName(), cat3.getName(), cat4.getName(), cat5.getName(), cat6.getName());
    }

}
