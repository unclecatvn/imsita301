/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.SendMail;
import utils.Validation;

/**
 *
 * @author HoaiNam
 */
public class UserDAO {

    //Login google
    public User loginByGoogle(String email) {
        String sql = "SELECT * FROM [User] WHERE email = ?";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9));
                return u;
            }

        } catch (Exception e) {
            System.out.println("loginByGoogle Error:" + e.getMessage());
        }
        return null;
    }

    //login
    public User login(String email, String password) {
        try {
            String sql = "SELECT * FROM [User] where email = ? and password = ?";
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9));
                return u;
            }
        } catch (Exception e) {
            System.out.println("login Error:" + e.getMessage());
        }
        return null;
    }

    public User UpDatePassWord(String password, String email) {
        try {
            String sql = "UPDATE [User]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE [email] = ?";
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updatePassword Error:" + e.getMessage());
        }
        return null;
    }

    public User getUserById(int id) {
        String sql = "SELECT *\n"
                + "FROM [User]\n"
                + "WHERE user_id = ? ";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            rs = stm.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("add Error:" + e.getMessage());
        }
        return null;
    }

    public User getUserByGmail(String gmail) {
        String sql = "SELECT *\n"
                + "FROM [User]\n"
                + "WHERE email = ? ";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, gmail);
            ResultSet rs = stm.executeQuery();
            rs = stm.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("add Error:" + e.getMessage());
        }
        return null;
    }

    public UserDAO() {
        connectDB();
    }

    Connection cnn = null; // ket noi db
    PreparedStatement stm = null; // thuc thi cac cau lenh sql
    ResultSet rs = null; // luu tru va xu ly du lieu

    private void connectDB() {
        try {
            cnn = (new DBContext().getConnection());
        } catch (Exception e) {
            System.out.println("Connect error:" + e.getMessage());
        }
    }

    public void updateUser(String user_name, String phone, boolean gender, String rollNumber, int role_id, String email) {
        String query = "update [User] "
                + "set user_name=?, "
                + "phone=?, "
                + "gender=?, "
                + "roll_number=?, "
                + "role_id=? "
                + "where email=?";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.prepareStatement(query);
            stm.setString(1, user_name);
            stm.setString(2, phone);
            stm.setBoolean(3, gender);
            stm.setString(4, rollNumber);
            stm.setInt(5, role_id);
            stm.setString(6, email);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from [User] where role_id != 1";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9));
                list.add(u);
            }

        } catch (Exception e) {
        }
        return list;
    }

    //Vanhle
    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM [User] WHERE email = ?";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            boolean exists = rs.next();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendEmailForgot(String email) {
        try {
            String forgotKey = "";
            forgotKey = new SendMail().createCaptcha();
            String sql = "UPDATE [dbo].[User]\n"
                    + "   SET [forgot_key] = ?\n"
                    + " WHERE [email] = ?";
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, forgotKey);
            stm.setString(2, email);
            stm.executeUpdate();
            new SendMail().send(email, "Forgot password", "Hi, we get a request for password change, click on the link below to confirm (1 minute period):\n"
                    + "If you don't do that, ignore it\n"
                    + "OTP CODE: " + forgotKey + "\n"
                    + "Or you can click the link below:\n"
                    + "http://localhost:8080/QuizPractice/confirmKey?email=" + email + "&forgot_key=" + forgotKey);
        } catch (Exception e) {
        }
    }

    public void removeForgotKey(String email) {
        try {
            String sql = "UPDATE [User]\n"
                    + "   SET verification_key = NULL\n"
                    + " WHERE email = ?";
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, email);
            stm.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public boolean checkForgotKeyExist(String email, String verification_key) {
        try {
            String sql = "SELECT * FROM [User] WHERE [email] = ? AND verification_key= ?";
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, verification_key);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (Exception e) {
        }
        return false;
    }

    public void changePassword(String password, String email) {
        try {
            String sql = "UPDATE [User]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE [email] = ?";
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updatePassword Error:" + e.getMessage());
        }
    }

    public int countUserByRoleId(int roleId) {
        String sql = "SELECT COUNT(*) FROM [User]\n"
                + "WHERE role_id = ?";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setInt(1, roleId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    //end Vanhle

    public ArrayList<User> search(boolean status, int role_id, String name) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from [User] where\n"
                + "status = ? and role_id = ? and user_name like ?";

        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setBoolean(1, status);
            stm.setInt(2, role_id);
            stm.setString(3, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9));
                list.add(u);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void updateUserAdmin(int id, String user_name, String email, boolean gender, String password, String phone, boolean status, int role_id, String rollNumber) {
        String query
                = "update [User] set user_name = ?, \n"
                + "email = ?, gender = ?, password = ?, phone = ?, status = ?, role_id = ?, roll_number = ?\n"
                + "where user_id = ?";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.prepareStatement(query);
            stm.setString(1, user_name);
            stm.setString(2, email);
            stm.setBoolean(3, gender);
            stm.setString(4, password);
            stm.setString(5, phone);
            stm.setBoolean(6, status);
            stm.setInt(7, role_id);
            stm.setString(8, rollNumber);
            stm.setInt(9, id);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUserByID(int id) {
        String query = "delete from [User] where user_id = ?";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void createNewProfile(String user_name, String email, boolean gender, String password, String phone, boolean status, int role_id, String rollNumber) {
        String query = "insert into [User] (user_name, email, gender, password, phone, status, role_id, roll_number)\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.prepareStatement(query);
            stm.setString(1, user_name);
            stm.setString(2, email);
            stm.setBoolean(3, gender);
            stm.setString(4, password);
            stm.setString(5, phone);
            stm.setBoolean(6, status);
            stm.setInt(7, role_id);
            stm.setString(8, rollNumber);
            stm.executeUpdate();
            new SendMail().send(email, "Your temporary password", "Hi, we send you the temporary password"
                    + "If you don't do that, ignore it\n"
                    + "Password: " + password + "\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertNewProfile(String user_name, String email, boolean gender, String password, String phone, String verification_key) {
        String query = "insert into [User] (full_name, email, gender, password, phone, status, role_id, roll_number, verification_key)\n"
                + "values(?, ?, ?, ?, ?, 'True', '1', 'Null', ?)";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.prepareStatement(query);
            stm.setString(1, user_name);
            stm.setString(2, email);
            stm.setBoolean(3, gender);
            stm.setString(4, password);
            stm.setString(5, phone);
            stm.setString(6, verification_key);
            stm.executeUpdate();
//            new SendMail().send(email, "Create new profile", "Hi, we send you otp"
//                    + "If you don't do that, ignore it\n"
//                    + "OTP: " + verification_key + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int[] getClassIDStudent(int sId) {

        String query
                = "select class_id from Enroll join [User] on student_id = user_id where student_id = ?";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.prepareStatement(query);
            stm.setInt(1, sId);
            ResultSet rs = stm.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
            }
            int[] arr = new int[i];
            while (rs.next()) {
                for (int j = 0; j < i; i++) {
                    arr[j] = rs.getInt(1);
                }
            }
            return arr;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkRollNum(String roll) {
        String sql = "SELECT * FROM [User] WHERE roll_number = ?";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            stm.setString(1, roll);
            ResultSet rs = stm.executeQuery();
            boolean exists = rs.next();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<User> getAssignedStudent() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select e.student_id from enroll e group by e.student_id";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User c = new User(rs.getInt(1));
                list.add(c);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<User> getAssignedTeacher() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select e.teacher_id from enroll e group by e.teacher_id";
        try {
            PreparedStatement stm = new DBContext().getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User c = new User(rs.getInt(1));
                list.add(c);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void importUserFromExcel(String path) {
        try {
            FileInputStream excelFile = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(excelFile);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

            DBContext db = new DBContext();
            Connection connection = db.getConnection();
            String sql = "INSERT INTO [User] (user_name, email, gender, password, phone, status, role_id, roll_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            DataFormatter formatter = new DataFormatter();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                String userName = formatter.formatCellValue(currentRow.getCell(0));
                statement.setString(1, userName);
                String email = formatter.formatCellValue(currentRow.getCell(1));
                statement.setString(2, email);
                Boolean gender = Boolean.parseBoolean(formatter.formatCellValue(currentRow.getCell(2)));
                statement.setBoolean(3, gender);
                String password = formatter.formatCellValue(currentRow.getCell(3));
                statement.setString(4, password);
                String phone = formatter.formatCellValue(currentRow.getCell(4));
                statement.setString(5, phone);
                Boolean status = Boolean.parseBoolean(formatter.formatCellValue(currentRow.getCell(5)));
                statement.setBoolean(6, status);
                int roleId = Integer.parseInt(formatter.formatCellValue(currentRow.getCell(6)));
                statement.setInt(7, roleId);
                String rollNumber = formatter.formatCellValue(currentRow.getCell(7));
                statement.setString(8, rollNumber);
                Validation valid = new Validation();
                if (!(valid.checkDupEmailPhone(email, phone, roleId))) {
                    continue;
                }
                statement.executeUpdate();
            }

            statement.close();
            connection.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        ArrayList<User> l = dao.getAssignedStudent();
        for (User user : l) {
            System.out.println(user);
        }
        //dao.updateUser("hahaha", email, phone, true, rollNumber, 0);
        //dao.updateUser("haha",  "11111", false, "h111", 2, "haha@fpt.edu.vn");
//        User u = dao.getUserById(9);
//        System.out.println(u);
//        if(dao.checkEmail("ssss")==true){
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
//        User u = dao.loginByGoogle("anhlvhe172133@fpt.edu.vn");
//        System.out.println(u.toString());
//        if(dao.checkEmail("anhlvhe172133@fpt.edu.vn")==true){
//            System.out.println("hehe");
//        } else {
//            System.out.println("Nothing");
//        }
        dao.sendEmailForgot("anhlvhe172133@fpt.edu.vn");
//        if (dao.checkForgotKeyExist("anhlvhe172133@fpt.edu.vn", "bITFj0") == true) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
//        dao.changePassword("1235", "anhlvhe172133@fpt.edu.vn");
//        System.out.println(dao.countUserByRoleId(2));
    }

}
