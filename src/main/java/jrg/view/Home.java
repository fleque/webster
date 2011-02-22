/*
 *
 *  * Webster - is a dummy SMTP server from the Dumbster project wrapped in a web app
 *  * Copyright 2011 Joseph Ray Greenawalt
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

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
