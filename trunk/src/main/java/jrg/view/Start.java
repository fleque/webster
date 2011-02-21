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
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class Start extends Webster {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println(getPrettyMenu(request));


        if (isServerStopped()) {
            putServer(new Integer("5000"));
            out.println("Started");

        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println(getPrettyMenu(request));


        String serverPort = request.getParameter("serverPort");

        if (!isServerStopped()) {
            stopServer();

        }

        try {
            putServer(new Integer(serverPort));
            out.println("Started");
        } catch (Exception e) {

            e.printStackTrace(out);

        }


    }


}
