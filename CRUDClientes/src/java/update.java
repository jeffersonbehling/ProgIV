/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class update extends HttpServlet {

    private Connection conexao;
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
        try {
            PrintWriter out = response.getWriter();

            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost/loja_db", "postgres", "ciet");
            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes WHERE codigo = " + request.getParameter("id"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Atualizar Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if (!rs.next()) {
                out.println("<h3 style=\"color: red\">Cliente não encontrado</h3>");
            } else {
                out.println("<form action=\"SaveUpdate?id="+request.getParameter("id")+"\" method=\"post\">");
                out.println("<label for=\"user\">Nome: </label>");
                out.println("<input type=\"text\" name=\"nome\" value='"+ rs.getString("nome") + "' required=\"required\"/><br><br>");
                out.println("<label for=\"nascimento\">Nascimento: </label>");
                out.println("<input type=\"date\" name=\"nascimento\" value='"+ rs.getDate("nascimento") + "' required=\"required\"/><br><br>");
                out.println("<label for=\"endereco\">Endereço: </label>");
                out.println("<input type=\"text\" name=\"endereco\" value='"+ rs.getString("endereco") + "' required=\"required\"/><br><br>");
                out.println("<label for=\"cidade\">Cidade: </label>");
                out.println("<input type=\"text\" name=\"cidade\" value='"+ rs.getString("cidade") + "' required=\"required\"/><br><br>");
                out.println("<label for=\"status\">Status: </label>");
                out.println("<input type=\"number\" name=\"status\" value='"+ rs.getString("status") + "' required=\"required\"/><br><br>");
                out.println("<input type=\"submit\" value=\"Salvar\"><br>");
            }
            
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            throw new UnavailableException(e.getMessage());
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
