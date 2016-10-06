/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author Alumno
 */
public class ServletCalculadora extends HttpServlet {

    int num;
    int num2;
    int op;
    float resp;
    String op2;

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) {
        num = Integer.parseInt(peticion.getParameter("numero1"));
        num2 = Integer.parseInt(peticion.getParameter("numero2"));
        op = Integer.parseInt(peticion.getParameter("operacion"));
        if (op == 1) {
            resp = num + num2;
            op2 = "suma";
        } else if (op == 2) {
            resp = num - num2;
            op2 = "resta";
        } else if (op == 3) {
            resp = num * num2;
            op2 = "multiplicaion";
        } else if (num == 4) {
            resp = num / num2;
            op2 = "division";
        }
        try {
            PrintWriter out = new PrintWriter(respuesta.getOutputStream());
            out.println("<html>");
            out.println("<head><title>Respuesta a la calculadora del Servlet</title></head>");
            out.println("<body>");
            out.println("<p><h1><center>Su " + op2 + " es:<B>" + resp + "</B> </center></h1></p>");
            out.println("</body></html>");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
