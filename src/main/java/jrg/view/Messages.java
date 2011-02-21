package jrg.view;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ListIterator;


/**
 * Created by IntelliJ IDEA.
 * User: jgreenaw
 * Date: 2/21/11
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */

public class Messages extends Webster {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println(getPrettyMenu(request));


        if (!isServerStopped()) {

            ServletContext context = getServletContext();
            SimpleSmtpServer server = (SimpleSmtpServer) context.getAttribute("server");
            ListIterator<SmtpMessage> messages = server.getReceivedEmail();
            out.println("<h1>Number Of Messages: " + server.getReceivedEmailSize() + "</h1>");

            while (messages.hasPrevious()) {
                SmtpMessage msg = messages.previous();
                out.println("<p>" + msg.toWeb() + "<p>");
            }
        }


    }
}
