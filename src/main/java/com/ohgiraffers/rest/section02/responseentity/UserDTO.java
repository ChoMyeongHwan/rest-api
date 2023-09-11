package com.ohgiraffers.rest.section02.responseentity;

import java.util.Date;

public class UserDTO {

    private int no;
    private String id;
    private String pw;
    private String name;
    private Date enrollDate;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public UserDTO(int no, String id, String pw, String name, Date enrollDate) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
