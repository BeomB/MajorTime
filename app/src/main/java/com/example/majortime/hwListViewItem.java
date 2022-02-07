package com.example.majortime;

public class hwListViewItem {
    private String contentStr;
    private String titleStr;
    private Integer idInt;
    private Integer yearInt;
    private Integer monthInt;
    private Integer dayInt;
    private Integer hourInt;
    private Integer minuteInt;
    private Integer timeidInt;


    public void setId(Integer _id) { this.idInt = _id;}
    public void setTitle(String title) {
        this.titleStr = title;
    }
    public void setContent(String content) {
        this.contentStr = content;
    }
    public void setTimeid(Integer time_id) {this.timeidInt=time_id;}
    public void setYear(Integer year) {this.yearInt=year;}
    public void setMonth(Integer month) {this.monthInt=month;}
    public void setDay(Integer day) {this.dayInt=day;}
    public void setHout(Integer hour) {this.hourInt=hour;}
    public void setMinute(Integer minute){this.minuteInt=minute;}

    public Integer getId() { return idInt;}
    public String getContent(){ return contentStr; }
    public String getTitle() {
        return titleStr;
    }
    public Integer getTimeidInt() {return timeidInt;}
    public Integer getYearInt() {return yearInt;}
    public Integer getMonthInt() {return  monthInt;}
    public Integer getDayInt() {return dayInt;}
    public Integer getHourInt() {return hourInt;}
    public Integer getMinuteInt(){return  minuteInt;}
}
