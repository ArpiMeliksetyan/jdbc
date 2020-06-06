package am.basic.jdbcStart.filter;

import am.basic.jdbcStart.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static am.basic.jdbcStart.util.constants.Messages.SESSION_EXPIRED_MESSAGE;
import static am.basic.jdbcStart.util.constants.Pages.INDEX_PAGE;
import static am.basic.jdbcStart.util.constants.ParameterKeys.MESSAGE_ATTRIBUTE_KEY;
import static am.basic.jdbcStart.util.constants.ParameterKeys.USER_ATTRIBUTE_KEY;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Authorization filter constructed");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        User user = (User) request.getSession().getAttribute(USER_ATTRIBUTE_KEY);
        if (user == null) {
            request.setAttribute(MESSAGE_ATTRIBUTE_KEY, SESSION_EXPIRED_MESSAGE);
            request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
        }else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("Authorization filter destroyed");

    }
}
