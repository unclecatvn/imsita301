/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import utils.SendMail;
import utils.SendPhone123;

/**
 *
 * @author HoaiNam
 */
public class CreateUserControllerPhone extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateUserController at " + request.getContextPath() + "</h1>");
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
        // Lấy thông tin từ form
        String name = request.getParameter("fullname");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        String phone = request.getParameter("phone");

        // Tạo instance của UserDAO để tương tác với cơ sở dữ liệu
        UserDAO udb = new UserDAO();
        UserService userService = new UserService();


        if (!userService.isPasswordValid(password, confirmPassword)) {
            request.setAttribute("mess", "Confirm password not match password");
            request.getRequestDispatcher("registerAccountPhone.jsp").forward(request, response);
        }
        // Tạo và gửi OTP

        if (userService.isPhoneNumberValid(phone) && userService.isPasswordValid(password, confirmPassword)) {
            String otp = SendPhone123.createCaptcha();
            // Gửi OTP qua SMS tới số điện thoại người dùng đã nhập
            SendPhone123.sendSms(phone, "Your OTP code is: " + otp);

            // Lưu thông tin đăng ký tạm thời vào session
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("gender", gender);
            session.setAttribute("password", password);
            session.setAttribute("phone", phone);
            session.setAttribute("otp", otp);
            System.out.println(otp);

            // Đặt thời gian tồn tại cho session
            session.setMaxInactiveInterval(5 * 60); // 5 phút

            // Chuyển hướng đến trang xác thực OTP
            response.sendRedirect("confirmKey.jsp");
        }

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
