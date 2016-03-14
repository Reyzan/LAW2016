/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address_book;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ari
 */
@WebServlet(name = "addAuthor", urlPatterns = {"/addAuthor"})
public class addAuthor extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {

            String nama = request.getParameter("nama");
            String telepon = request.getParameter("telepon");
            String email = request.getParameter("email");
            String alamat = request.getParameter("alamat");
            String kota = request.getParameter("kota");
            String provinsi = request.getParameter("provinsi");
            String kode_pos = request.getParameter("kode_pos");
            String nama_socmed1 = request.getParameter("nama_socmed1");
            int jenis_socmed1 = Integer.parseInt(request.getParameter("jenis_socmed1"));
            String nama_socmed2 = request.getParameter("nama_socmed2");
            int jenis_socmed2 = Integer.parseInt(request.getParameter("jenis_socmed2"));
            int negara = Integer.parseInt(request.getParameter("negara"));

            User newUser = new User(0, nama, Integer.parseInt(telepon), email, alamat, kota, provinsi, kode_pos);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Quiz2PU");
            EntityManager em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();
            Negara n = em.find(Negara.class, negara);
            newUser.setNegara(n);
            tx.begin();
            em.persist(newUser);
            tx.commit();
            MediaSosial m1 = em.find(MediaSosial.class, jenis_socmed1);
            MediaSosial m2 = em.find(MediaSosial.class, jenis_socmed2);
            UserMediaSosialPK uM1 = new UserMediaSosialPK(newUser.getId(), jenis_socmed1);
            UserMediaSosialPK uM2 = new UserMediaSosialPK(newUser.getId(), jenis_socmed2);
            UserMediaSosial uMS1 = new UserMediaSosial(uM1, nama_socmed1);
            UserMediaSosial uMS2 = new UserMediaSosial(uM2, nama_socmed2);
            tx.begin();
            em.persist(uMS1);
            em.persist(uMS2);
            tx.commit();
            response.sendRedirect("index.jsp");
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        } catch (RollbackException e) {
            response.sendRedirect("error.jsp");
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
