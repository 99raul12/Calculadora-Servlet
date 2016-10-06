/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   public class ServletCalc extends HttpServlet {

    int num;
    int num2;
    int op;
    float resp;
    String op2;

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) {
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


    



