/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import dtos.ErrorUserDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import org.apache.log4j.Logger;

/**
 *
 * @author 84909
 */
public class RegisterController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "SendEmailController";

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
        String url = ERROR;
        ErrorUserDTO error = new ErrorUserDTO();

        try {
            request.setCharacterEncoding("UTF-8");
            HttpSession session =request.getSession();
            String username = request.getParameter("username").trim();
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(username);
            boolean check = matcher.find();
            boolean check1 = true;
            if (check) {
                error.setUserIDError("Username must not have white space");
                check1 = false;
                url = ERROR;
            }

            String password = request.getParameter("password").trim();

            String confirm = request.getParameter("confirm").trim();
            if (!confirm.equals(password)) {
                error.setConfirmError("Confirm must match password");
                check1 = false;
                url = ERROR;
            }
            String hashCode = getHash(password.getBytes(), "SHA-256");
            String gender = request.getParameter("gender");
            String fullName = request.getParameter("fullname").trim();
     

       
            if (check1) {
                UserDAO dao = new UserDAO();
                UserDTO dto = new UserDTO(username,hashCode,fullName,gender,"Member","New");
                boolean flag = dao.insertUser(dto);
                if (flag) {
                    session.setAttribute("USER", dto);
                    request.setAttribute("SUCCESS", "Register success ! Please check your mail to confirm ");
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("MESSAGE", error);
            }

        } catch (Exception e) {
            LOGGER.debug("Error at RegisterController " + e.getMessage());
            if (e.toString().contains("duplicate")) {
                error.setUserIDError("Duplicate email please try again !");
                request.setAttribute("MESSAGE", error);
            }
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

    public String getHash(byte[] input, String algorithim) {
        String hashValue = "";
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithim);
            digest.update(input);
            byte[] tmp = digest.digest();
            hashValue = DatatypeConverter.printHexBinary(tmp).toLowerCase();
        } catch (Exception e) {
        }
        return hashValue;
    }

}
