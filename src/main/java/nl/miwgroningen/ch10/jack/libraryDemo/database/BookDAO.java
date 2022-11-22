package nl.miwgroningen.ch10.jack.libraryDemo.database;

import nl.miwgroningen.ch10.jack.libraryDemo.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Jack Wieringa <j.w.wieringa@st.hanze.nl>
 * <p>
 * Haalt boeken uit de database.
 */

public class BookDAO extends AbstractDAO{

    public BookDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        String sql = "SELECT title, author FROM Book;";
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                String author = resultSet.getString(2);
                books.add(new Book(title, author));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return books;
    }
}
