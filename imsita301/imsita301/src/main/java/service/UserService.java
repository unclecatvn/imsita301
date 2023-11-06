/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.UserDAO;

/**
 *
 * @author HoaiNam
 */
public class UserService {

    UserDAO userDAO = new UserDAO();

    public boolean isEmailValid(String email) {
        if (email != null && email.endsWith("@fpt.edu.vn")) {
            return true;
        }

        // Trường hợp email không hợp lệ
        return false;
    }

    public boolean isPhoneNumberValid(String phone) {
        if (phone == null) {
            return false;
        }

        // Loại bỏ tất cả dấu cách và ký tự khoảng trắng
        phone = phone.replaceAll("\\s", "");

        // Kiểm tra độ dài của số điện thoại
        if (phone.length() == 10 && phone.startsWith("0") && phone.substring(1).matches("\\d+")) {
            return true;
        }

        if (phone.length() == 12 && phone.startsWith("+84") && phone.substring(3).matches("\\d+")) {
            return true;
        }

        return false;
    }

    public boolean isPasswordValid(String password, String confirmPassword) {
//       Check password is match with confirmPassword
        if (password == null || !password.equals(confirmPassword)) {
            return false;
        }

        // Kiểm tra độ dài của mật khẩu
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Kiểm tra xem mật khẩu có ít nhất 1 chữ cái viết hoa và 1 số không
        boolean containsUpperCase = false;
        boolean containsDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            }

            if (containsUpperCase && containsDigit) {
                // Nếu đã tìm thấy ít nhất 1 chữ cái viết hoa và 1 số, thoát vòng lặp
                break;
            }
        }

        return containsUpperCase && containsDigit;
    }

    public static void main(String[] args) {
        UserService u = new UserService();
//        System.out.println(u.isEmailValid("anhlvhe172133@fpt.edu.vn"));
//        System.out.println(u.isPasswordValid("", ""));
//        System.out.println(u.isPhoneNumberValid("0377212003"));
    }
}