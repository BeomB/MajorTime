package com.example.majortime.VO;

import java.io.Serializable;

public class Schedule_VO implements Serializable {
    String subject;
    String classroom;
    String professor;
    String day;
    String hour_start;
    String min_start;
    String hour_end;
    String min_end;
    String total_minute;
    String colorfill;
    String gyosi;
    String colorvalue;

    public void setColorvalue(String colorvalue) {
        this.colorvalue = colorvalue;
    }

    public String getColorvalue() {
        return colorvalue;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getProfessor() {
        return professor;
    }

    public String getDay() {
        return day;
    }

    public String getHour_start() {
        return hour_start;
    }

    public String getMin_start() {
        return min_start;
    }

    public String getHour_end() {
        return hour_end;
    }

    public String getMin_end() {
        return min_end;
    }

    public String getTotal_minute() {
        return total_minute;
    }

    public String getColorfill() {
        return colorfill;
    }

    public String getGyosi() {
        return gyosi;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHour_start(String hour_start) {
        this.hour_start = hour_start;
    }

    public void setMin_start(String min_start) {
        this.min_start = min_start;
    }

    public void setHour_end(String hour_end) {
        this.hour_end = hour_end;
    }

    public void setMin_end(String min_end) {
        this.min_end = min_end;
    }

    public void setTotal_minute(String total_minute) {
        this.total_minute = total_minute;
    }

    public void setColorfill(String colorfill) {
        this.colorfill = colorfill;
    }

    public void setGyosi(String gyosi) {
        this.gyosi = gyosi;
    }
}
