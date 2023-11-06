/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.User;
import dal.UserDAO;
import java.util.ArrayList;

/**
 *
 * @author HoaiNam
 */
public class Validation {
     public final String REGEX_PASSWORD = "(?=.*\\d.*)(?=.*[a-zA-Z].*).{8,31}"; //(?=.*\\d.*) phải có ít nhất 1 chữ/số | ít nhất 8 kí tự và nhiều nhất 31 kí tự
     
     public Boolean checkDupEmailPhone(String email, String phone, int roleId) {
        Boolean status = true;
        if (roleId == 1 || roleId == 2) {
            status = false;
        }
        UserDAO udb = new UserDAO();
        ArrayList<User> list = udb.getAllUser();
        for (User user : list) {
            if (user.getEmail().equals(email) || user.getPhone().equals(phone)) {
                status = false;
            }
        }
        return status;
    }
}
