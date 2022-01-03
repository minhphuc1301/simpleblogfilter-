/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import daos.UserDAO;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import utils.SendMail;

/**
 *
 * @author 84909
 */
public class SendEmailController extends HttpServlet {

   

    private static final String SUCCESS = "confirm.jsp";
    private String host;
    private String port;
    private String userID;
    private String pass;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        userID = context.getInitParameter("user");
        pass = context.getInitParameter("password");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String url = SUCCESS;
        System.out.println(userID + pass);
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("USER");
        String recipient = user.getUserID();
        String subject = "Verification Mail by Admin ";
        String code=getRandom();
        UserDAO dao=new UserDAO();
        user.setActiveCode(code);
        try {
            dao.updateActiveCode(user.getUserID(), code);
        } catch (Exception e) {
        }
       
//        OrderDTO order = (OrderDTO) session.getAttribute("ORDER_INFOR");
        String content = "Registered successfully.Please verify your account by using this code: " + user.getActiveCode();
//                + order.getOrderId() + "\nYour order date: " + order.getDate()
//                + "\nYour Total Price: $" + order.getTotalPrice();

        try {

            SendMail.send(host, port, recipient, subject,
                    content, userID, pass);
            url = SUCCESS;
            session.setAttribute("USER", user);
            request.setAttribute("SUCCESS", "Registered successfully.We have send a code to verify your account . Please check your mail !");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    public String getRandom()
    {
        Random rnd=new Random();
        int number=rnd.nextInt(999999);
        return String.format("%06d",number);
    }
}
