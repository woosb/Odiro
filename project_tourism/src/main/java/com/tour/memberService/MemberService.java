package com.tour.memberService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.tour.dto.MemberDTO;
public interface MemberService {
        
    
    public void join (MemberDTO dto); //회원가입 관련
    
    
    public boolean loginCheck(MemberDTO dto, HttpSession session);    //로그인 관련
    
    
    public String find_idCheck(MemberDTO dto);    //아이디 찾기 관련
    
    
    public String find_passCheck(MemberDTO dto);    //비밀번호 찾기 관련
    
    
    public void authentication(MemberDTO dto);        //회원 인증관련 메소드
    
    
    public void pass_change(Map<String, Object> map, MemberDTO dto)throws Exception;    //비밀번호 변경
    
    
    public boolean email_check(String e_mail) throws Exception;   //이메일 중복확인을 하는 메소드
    
    
    public int nickName_check(String nickName) throws Exception;    //회원가입시 닉네임을 체크하는 메소드
    
    
    public List<MemberDTO> member_profile(String e_mail) throws Exception;    //회원의 프로필을 볼 수 있는 메소드
    
    public List<MemberDTO> member() throws Exception; //관리자 페이지 멤버 리스트 불러오는 메소드
    
    public void remove(String e_mail);
    
    public void update(MemberDTO dto);


	public void passChange(MemberDTO dto) throws Exception;


	public boolean nick_check(String nick);


	public String get_email(String nick);


	public String getnick(String e_mail);

 
}
