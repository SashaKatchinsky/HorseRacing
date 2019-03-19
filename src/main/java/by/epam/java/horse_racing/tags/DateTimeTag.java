package by.epam.java.horse_racing.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTag extends SimpleTagSupport {
    private static final String PATTERN = "dd MMMM YYYY hh:mm:ss";
    String locale;

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (locale.equals("ru")) {
            SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            out.print(sdfDate.format(date));
        } else {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            out.print(sdfDate.format(date));
        }
    }
}
