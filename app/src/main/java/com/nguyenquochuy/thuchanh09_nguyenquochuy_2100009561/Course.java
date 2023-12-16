package com.nguyenquochuy.thuchanh09_nguyenquochuy_2100009561;

public class Course {
    private  int id;
    private String course_name;
    private  String course_tracks;
    private  String course_duration;
    private String course_description;

    public Course(int id, String course_name, String course_tracks, String course_duration, String course_description) {
        this.id = id;
        this.course_name = course_name;
        this.course_tracks = course_tracks;
        this.course_duration = course_duration;
        this.course_description = course_description;
    }

    public int getId() {
        return id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_tracks() {
        return course_tracks;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_tracks(String course_tracks) {
        this.course_tracks = course_tracks;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
}
