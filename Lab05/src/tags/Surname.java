package tags;

import javax.servlet.jsp.tagext.*;

public class Surname extends TagSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() {
        try {
            pageContext.getOut().write(String.format("<input type='text' name='%s' placeholder='surname'/>", this.name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return SKIP_BODY;
    }
}