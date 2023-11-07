/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Enroll {
  private int enroll_id;
     private Project project_id;
     private  User user_id;

    public Enroll() {
    }
     
     

    public Enroll(int enroll_id, Project project_id, User user_id) {
        this.enroll_id = enroll_id;
        this.project_id = project_id;
        this.user_id = user_id;
    }

    public int getEnroll_id() {
        return enroll_id;
    }

    public void setEnroll_id(int enroll_id) {
        this.enroll_id = enroll_id;
    }

    public Project getProject_id() {
        return project_id;
    }

    public void setProject_id(Project project_id) {
        this.project_id = project_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

     
     
//    @Override
//    public String toString() {
//        return "Enroll{" + "classes=" + classes + ", course=" + course + ", teacher=" + teacher + ", totalStudent=" + totalStudent + '}';
//    }

    @Override
    public String toString() {
        return "Enroll{" + "enrollId=" + enroll_id + ", Project=" + project_id + ", User=" + user_id + '}';
    }
    
    
    
    
    
    
    
    
    
}
