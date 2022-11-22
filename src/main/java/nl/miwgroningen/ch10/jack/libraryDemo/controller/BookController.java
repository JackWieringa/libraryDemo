package nl.miwgroningen.ch10.jack.libraryDemo.controller;

import nl.miwgroningen.ch10.jack.libraryDemo.database.BookDAO;
import nl.miwgroningen.ch10.jack.libraryDemo.database.DBaccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jack Wieringa <j.w.wieringa@st.hanze.nl>
 * <p>
 * Geeft toegang tot alle pagina's over boeken.
 */

@Controller
public class BookController {

    @GetMapping("/books")
    protected String showBookOverview(Model model) {
        DBaccess dBaccess = new DBaccess("libraryDemo",
                "userLibrary", "userLibraryPW");
        dBaccess.openConnection();
        BookDAO bookDAO = new BookDAO(dBaccess);
        model.addAttribute("allBooks", bookDAO.getAllBooks());
        dBaccess.closeConnection();

        return "bookOverview";
    }

}
