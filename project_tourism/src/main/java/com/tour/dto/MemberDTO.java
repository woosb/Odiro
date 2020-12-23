package com.tour.dto;

import java.util.Date;

public class MemberDTO {
    
    private String user_id;    //아이디
    private String user_pass;    //비밀번호
    private String e_mail;    //이메일
    
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_pass() {
        return user_pass;
    }
    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
    public String getE_mail() {
        return e_mail;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    
    
    @Override
    public String toString() {
        return "MemberDTO [user_id=" + user_id + ", user_pass=" + user_pass + ", e_mail=" + e_mail + "]";
    }
    
 
}
