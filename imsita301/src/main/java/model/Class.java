/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Class {
    private int classId;
    private String class_name;
    private Date start_Date;
    private Date end_Date;

    public Class(int classId, String class_name, Date start_Date, Date end_Date) {
        this.classId = classId;
        this.class_name = class_name;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }



    @Override
    public String toString() {
        return "Classes{" + "classId=" + classId + ", className=" + class_name + ", startDate=" + start_Date + ", endDate=" + end_Date + '}';
    }
    
    
    
    
    
}
