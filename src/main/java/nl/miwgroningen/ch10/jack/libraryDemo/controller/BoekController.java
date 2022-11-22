package nl.miwgroningen.ch10.jack.libraryDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jack Wieringa <j.w.wieringa@st.hanze.nl>
 * <p>
 * Geeft toegang tot alle pagina's over boeken.
 */

@Controller
public class BoekController {

    @GetMapping("/books")
    protected String showBookOverview() {
        return "bookOverview";
    }

}
