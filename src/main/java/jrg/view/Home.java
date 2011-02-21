package jrg.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: jgreenaw
 * Date: 2/21/11
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Home extends Webster {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println(getPrettyMenu(request));

        out.println("" +
                "<form method='post' action='"+request.getContextPath()+"/Start'>\n"+
                "<table>\n" +
                "<tr>\n" +
                "<td>Start:</td>\n" +
                "<td><input name=\"serverPort\" id=\"serverPort\" type=\"text\"</td>\n" +
                "<td><input type=\"submit\" value=\"START\"</td>\n" +
                "<tr>\n" +
                "</form>" +
                "</table>"+
                "");



    }
}
