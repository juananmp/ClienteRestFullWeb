/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Objetos.ListaContacto;
import Objetos.PersonaObj;
import Servicios.UpdateServicio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author janto
 */
public class AplicarUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaObj p = new PersonaObj();
        UpdateServicio up = new UpdateServicio();
        try (PrintWriter out = response.getWriter()) {
            HttpSession cliente = request.getSession();
             String token = (String)cliente.getAttribute("Token");

            
            
         // out.println("<h1>El usuario: " + name+"Se ha creado correctamente"+ "</h1>");
           
        
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AplicarUpdate</title>");            
            out.println("</head>");
            out.println("<body>");
                       
            String name = request.getParameter("nombre");
           
        String email = request.getParameter("correo");
        
        int telephone = Integer.parseInt((String) request.getParameter("telefono"));
         String id = request.getParameter("id");
        p.setName(name);
        p.setEmail(email);
        p.setTelephone(telephone);
            ListaContacto lo = new ListaContacto();
            lo.getIdContacto().add(id);
            lo.getPersona().add(p);
            up.putXml(lo, token);
            out.println("<h1> Se ha actualizado correctamente el contecto");
            out.println("<form action='/ClienteRestFullWeb/MenuAgenda' method='POST'>");
             

          out.println("<input type='submit' value='Volver Página inicial'>");
            out.println("</form>");
            out.println("<h1>Servlet AplicarUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
