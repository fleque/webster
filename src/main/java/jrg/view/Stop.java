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
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Stop extends Webster {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println(getPrettyMenu(request));


        if (!isServerStopped()) {

            stopServer();

            out.println("<h2>Server Has Stopped.</h2>");
        }


    }
}
