/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Course {

    private int sub_id;
    private String sub_name;
    private String description;
    private int class_id;

    public Course() {
    }

    
    
    public Course(int sub_id, String sub_name, String description, int class_id) {
        this.sub_id = sub_id;
        this.sub_name = sub_name;
        this.description = description;
        this.class_id = class_id;
    }

        public Course(int sub_id) {
        this.sub_id = sub_id;
    }

    public Course(int sub_id, String sub_name) {
        this.sub_id = sub_id;
        this.sub_name = sub_name;
    }
    
    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }




    @Override
    public String toString() {
        return "Course{" + "sub_id=" + sub_id + ", sub_name=" + sub_name + ", description=" + description + '}';
    }

}
