[Home](http://code.google.com/p/webster/) | [About](About.md) | [News](News.md)

# Introduction #

Webster is a web wrapper around the the Dumbster Project: http://quintanasoft.com/dumbster/.

# Motivation #
There were quite a few of dummy smtp servers out there, but my specific problem was that testers outside of the administration and development group needed to see the emails being sent in testing environments.  This app hopes to provide a way to host a dummy smtp server with universal access.  After I reach a certain amount of stability and feature richness, I suspect this project will go cold as far as I'm concerned, its goals aren't lofty; but if you want to send suggestions and time willing I can apply them I will try, feel free to contact me and share your ideas.  If you want to be a contributor to the project, let me know as well.


# Help #


**Requirements**

  * [Java JDK 6+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Maven](http://maven.apache.org/download.html)
  * Servlet Container, e.g. [Tomcat](http://tomcat.apache.org/download-70.cgi)

**Building And Installing**

  * Building - Webster is a maven2 project, so you should be able to simply check out the code and run: ` mvn package `.  This will create a webster.war file in the target directory.    Its a pretty simple app so I don't expect too many problems.  The development environment is: Mac OS X, IntelliJ, Tomcat 7.

  * Installing - Simply deploy the webster.war file to your servlet container.  e.g. In tomcat drop it in  your /webapps folder.  In tomcaat if you keep the webstar.war file name the context should be /webster.  Changing the context **SHOULDN'T** break it, if you need another name.

**Menu Items**
  * Home - Takes you to the Home page where you can start the server.  When you start a server you should enter a port number to run the SMTP server on.  Whatever that port number is, you aren't going to be able to start it if the privileges running your servlet container do not have the privileges to open up a server to listen on said port.  Only one SMTP server runs at a time.  If you start a server when one is already running, it will stop the running server (erase the messages) and start a new one.  If you don't enter a port, the default port is 5000.

  * Messages - This displays the list of messages sent to the server, most recent first.  They are stored in memory, so stopping the server and/or starting the server again will erase the messages.  This is a good way to clear them.

  * Stop - Simply stops the server.

  * Help - Takes you here.

**Testing**
  * In the [Downloads](http://code.google.com/p/webster/downloads/list) section there is a ` MailSend.groovy ` that will send a test message.  Its pretty raw, but its a nice template to test that webster is running correctly.  Adjust accordingly to the settings you need.  I got most if not all of it from the web somewhere.  I'll give credit, but I can't find it now.