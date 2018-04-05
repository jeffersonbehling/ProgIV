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
public class index extends HttpServlet {

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
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost/loja_db", "postgres", "ciet");
        
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tabela Clientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Tabela Clientes</h3>");
            out.println("<table border=1>");
            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
            
            out.println("<thead><tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Nascimento</th>");
            out.println("<th>Endereço</th>");
            out.println("<th>Cidade</th>");
            out.println("<th>Status</th>");
            out.println("<th>Ações</th>");
            out.println("</tr></thead>");
            
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("codigo") + "</td>");
                out.println("<td>" + rs.getString("nome") + "</td>");
                out.println("<td>" + rs.getString("nascimento") + "</td>");
                out.println("<td>" + rs.getString("endereco") + "</td>");
                out.println("<td>" + rs.getString("cidade") + "</td>");
                out.println("<td>" + rs.getString("status") + "</td>");
                out.println("<td><a href=\"update?id="+rs.getString("codigo")+"\">Alterar</a>&nbsp&nbsp&nbsp"
                        + "<a href=\"delete?id="+rs.getString("codigo")+"\">Excluir</a>"
                        + "</td>");
                out.println("</tr>");
            }
            
            rs.close();
            stmt.close();
            out.println("</table>");
            out.println("<br><br>");
            out.println("<a href=\"new-client.html\">Novo Cliente</a>");
            
            out.println("</body>");
            out.println("</html>");
        
        } catch(Exception e) {
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
