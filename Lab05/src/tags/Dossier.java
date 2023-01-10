package tags;

import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class Dossier extends TagSupport {
    private String action = "";

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int doStartTag() {
        try {
            pageContext.getOut().write(String.format("<form method = 'post' action= '%s'>", this.action));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() {
        String in = "</form>";

        try {
            pageContext.getOut().write(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_PAGE;
    }
}