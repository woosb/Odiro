package com.tour.memberService;

import java.util.List;
import java.util.Map;
 
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tour.dao.MemberDAO;
import com.tour.dto.MemberDTO;
 
@Service //서비스 빈 선언
public class MemberServiceImpl implements MemberService {
 
    @Inject    
    MemberDAO memberdao; //dao를 사용하기 위해 의존성을 주입
    private JavaMailSender mailSender;
 
    @Override    //회원가입 메소드
    public void join(MemberDTO dto) {
        memberdao.join(dto);
 
    }
 
    @Override    //로그인 관련 메소드 (세션에 아이디와 비밀번호를 저장)
    public boolean loginCheck(MemberDTO dto, HttpSession session) {
        
        boolean result = memberdao.loginCheck(dto);
        
        if(result) {    //로그인 성공
            session.setAttribute("e_mail", dto.getE_mail());
            session.setAttribute("member_pass", dto.getUser_pass());
            session.setAttribute("nick", memberdao.find_nickcname_check(dto));
            System.out.println(session.getAttribute("e_mail"));
            System.out.println(session.getAttribute("member_pass"));
            System.out.println(session.getAttribute("nick"));
        }
        
        return result;
    }
 
    //아이디 찾기
    @Override
    public String find_idCheck(MemberDTO dto) {
        String id = memberdao.find_nickcname_check(dto);
        
        return id;
    }
 
    //비밀번호 찾기
    @Override
    public String find_passCheck(MemberDTO dto) {
        String pass = memberdao.find_passCheck(dto);
        return pass;
    }
 
 
    @Override
    public void authentication(MemberDTO dto) {
        
        memberdao.authentication(dto);
    }
 
 
    @Override
    public void pass_change(Map<String, Object> map, MemberDTO dto) throws Exception {
        
        
        memberdao.pass_change(map,dto);
    }
 
 
    //이메일 중복 확인
    @Override
    public boolean email_check(String e_mail) throws Exception{
        System.out.println(e_mail);
        boolean result = memberdao.email_check(e_mail);
        
        return result;
        
    }

 
    //닉네임 중복 확인
    @Override
    public int nickName_check(String nickName) throws Exception {
        
        return memberdao.nickName_check(nickName);
    }
 
    //자신의 프로필을 볼 수 있게 하는 메소드
    @Override
    public List<MemberDTO> member_profile(String e_mail) throws Exception{
        
        return memberdao.member_profile(e_mail);
    }
    
    public List<MemberDTO> member() throws Exception
    {
    	return memberdao.member();
    }
    
    public void remove(String e_mail)
    {
    	memberdao.remove(e_mail);
    }
    
    public void update(MemberDTO dto)
    {
    	memberdao.update(dto);
    }
    
}
