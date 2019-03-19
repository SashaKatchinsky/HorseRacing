package by.epam.java.horse_racing.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * The type Encoding filter.
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
    /**
     * The constant FILTERABLE_CONTENT_TYPE.
     */
    public static final String FILTERABLE_CONTENT_TYPE="application/x-www-form-urlencoded";

    /**
     * The constant ENCODING_DEFAULT.
     */
    public static final String ENCODING_DEFAULT = "UTF-8";

    /**
     * The constant ENCODING_INIT_PARAM_NAME.
     */
    public static final String ENCODING_INIT_PARAM_NAME = "encoding";

    /**
     * The Encoding.
     */
    public String encoding;

    public void destroy(){

    }

    /**
     * Encoding filter.
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException{
        String contentType = req.getContentType();
        if (contentType != null && contentType.startsWith(FILTERABLE_CONTENT_TYPE))
            req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException{
        encoding = config.getInitParameter(ENCODING_INIT_PARAM_NAME);
        if (encoding == null)
            encoding = ENCODING_DEFAULT;
    }
}
