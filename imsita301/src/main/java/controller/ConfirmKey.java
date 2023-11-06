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

/**
 *
 * @author ADMIN
 */
public class ConfirmKey extends HttpServlet {

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
            out.println("<title>Servlet ConfirmKey</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmKey at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();

        // Kiểm tra xem session có tồn tại email không
        String sessionEmail = (String) session.getAttribute("email");
        if (sessionEmail == null) {
            request.setAttribute("mess", "Your session has expired. Please start the registration process again.");
            request.getRequestDispatcher("registerAccountEmail.jsp").forward(request, response);
        } else {
            // Nếu email tồn tại, chuyển hướng đến trang xác thực OTP
            response.sendRedirect("confirmKey.jsp");
        }
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
        // Lấy OTP từ form xác thực
        String inputOtp = request.getParameter("otp");
        System.out.println(inputOtp);

        // Lấy thông tin từ session
        HttpSession session = request.getSession();
        String sessionOtp = (String) session.getAttribute("otp");
        System.out.println(sessionOtp);

        // So sánh OTP người dùng nhập và OTP trong session
        if (sessionOtp != null && sessionOtp.equals(inputOtp)) {
            // OTP khớp, tiến hành lưu thông tin người dùng vào cơ sở dữ liệu
            UserDAO udb = new UserDAO();
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            boolean gender = (Boolean) session.getAttribute("gender");
            String password = (String) session.getAttribute("password");
            String phone = (String) session.getAttribute("phone");

            // Lưu thông tin người dùng vào cơ sở dữ liệu
            udb.insertNewProfile(name, email, gender, password, phone, null);

            // Đăng nhập người dùng (nếu cần) và chuyển hướng đến trang home
            // ... Đăng nhập người dùng ...
            response.sendRedirect("home.jsp"); // Giả sử đường dẫn trang chủ là home.jsp
        } else {
            // OTP không khớp hoặc đã hết hạn
            request.setAttribute("mess", "Invalid or expired OTP.");
            request.getRequestDispatcher("confirmKey.jsp").forward(request, response);
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
