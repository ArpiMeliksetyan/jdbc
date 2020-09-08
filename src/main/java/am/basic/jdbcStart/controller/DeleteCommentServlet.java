package am.basic.jdbcStart.controller;

import am.basic.jdbcStart.model.Comment;
import am.basic.jdbcStart.model.exceptions.InternalServerException;
import am.basic.jdbcStart.service.CommentService;
import am.basic.jdbcStart.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static am.basic.jdbcStart.util.constants.Pages.HOME_PAGE;
import static am.basic.jdbcStart.util.constants.ParameterKeys.ID_PARAM_KEY;
import static am.basic.jdbcStart.util.constants.ParameterKeys.MESSAGE_ATTRIBUTE_KEY;

//public class DeleteCommentServlet extends HttpServlet {
//


//    private CommentService commentService = ServiceFactory.getCommentService();
//    private Comment comment;
//
//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String idString = request.getParameter(ID_PARAM_KEY);
//        int i = Integer.parseInt (idString);
//        try {
//            Comment comment= new Comment();
//            comment.setId(i);
//            commentService.delete(comment);
//
//            response.sendRedirect(HOME_PAGE);
//        } catch (RuntimeException e) {
//            request.setAttribute(MESSAGE_ATTRIBUTE_KEY, e.getMessage());
//            request.getRequestDispatcher(HOME_PAGE).forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
