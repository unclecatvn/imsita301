/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Project {
     private int project_id;
      private Course sub_id;
      private String description;
      private String requirement;
      private String gitlab_link;

    public Project(int project_id, Course sub_id, String description, String requirement, String gitlab_link) {
        this.project_id = project_id;
        this.sub_id = sub_id;
        this.description = description;
        this.requirement = requirement;
        this.gitlab_link = gitlab_link;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public Course getSub_id() {
        return sub_id;
    }

    public void setSub_id(Course sub_id) {
        this.sub_id = sub_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getGitlab_link() {
        return gitlab_link;
    }

    public void setGitlab_link(String gitlab_link) {
        this.gitlab_link = gitlab_link;
    }

  

    @Override
    public String toString() {
        return "Project{" + "project_id=" + project_id + ", sub_id=" + sub_id + ", description=" + description + '}';
    }
      
      
}

