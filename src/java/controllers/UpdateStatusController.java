/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ArticleDAO;
import dtos.ArticleDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author 84909
 */
public class UpdateStatusController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(UpdateStatusController.class);

    private static final String SUCCESS = "PagingController";

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
        String url = SUCCESS;
        try {
            String status = request.getParameter("status1");
            String articleID = request.getParameter("articleID");
            ArticleDAO dao = new ArticleDAO();
            boolean check = false;
            if (status.equals("Approve")) {
                check = dao.updateStatus(2, articleID);
                if (check) {
                    int page = dao.getNumberArticleByStatus("Deleted");
                    if (page % 5 == 0) {
                        request.setAttribute("FLAG", "1");
                    }
                    request.setAttribute("MESSAGE", "Approve success !");

                    url = SUCCESS;
                }
            } else {
                check = dao.updateStatus(3, articleID);
                if (check) {
                    request.setAttribute("MESSAGE", "Delete success !");
                    int page = dao.getNumberArticleByStatus("Active");
                    if (page % 5 == 0) {
                        request.setAttribute("FLAG", "1");
                    }
                    url = SUCCESS;

                }
            }
        } catch (Exception e) {
            LOGGER.debug("Error at PagingController" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
