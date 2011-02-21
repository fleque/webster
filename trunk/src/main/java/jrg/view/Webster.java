package jrg.view;

import com.dumbster.smtp.SimpleSmtpServer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: jgreenaw
 * Date: 2/21/11
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Webster extends HttpServlet {


    protected boolean isServerStopped() {

        SimpleSmtpServer server = getServer();

        if (server == null) {
            return true;
        } else {
            if (server.isStopped()) {
                return true;
            }
        }
        return false;


    }

    protected int getRunPort() {

        if (!isServerStopped()) {

            SimpleSmtpServer server = getServer();
            return server.getPort();
        } else {
            return 0;
        }

    }

    protected SimpleSmtpServer getServer() {
        ServletContext context = getServletContext();

        return (SimpleSmtpServer) context.getAttribute("server");

    }

    protected void stopServer(){
        SimpleSmtpServer server = getServer();
        server.stop();
    }

    protected void putServer(Integer port) {
        ServletContext context = getServletContext();
        SimpleSmtpServer server;
        if (getRunPort() == 0) {
            server = new SimpleSmtpServer(port);
        } else {
            server = getServer();
            server.stop();
        }
        context.setAttribute("server", server.start(port.intValue()));

    }

    protected String getPrettyMenu(HttpServletRequest request) {
        String status;
        if (getRunPort() > 0) {
            status = "SERVER RUNNING ON PORT: " + getRunPort();
        } else {
            status = "SERVER NOT RUNNING";
        }
        return "<h3><a href='"+request.getContextPath()+"/Home'>Home</a> | <a href='"+request.getContextPath()+"/Messages'>Messages</a> | <a href='"+request.getContextPath()+"/Stop'>Stop</a>" + "<br/>"+ status + "</h3>";
    }


}
