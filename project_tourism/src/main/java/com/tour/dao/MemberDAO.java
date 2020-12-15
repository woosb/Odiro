package com.tour.dao;

import java.util.List;
import java.util.Map;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tour.dto.MemberDTO;
 
 
 
@Repository
public class MemberDAO {
    @Inject
    SqlSession sqlSession;
    //회원가입 관련 메소드

    public void join(MemberDTO dto) {
        
        sqlSession.insert("memberMapper.insertUser",dto);        
    }
    
    
    //로그인관련 메소드
    public boolean loginCheck(MemberDTO dto) {
        String name
            =sqlSession.selectOne("memberMapper.login_check", dto);
        
        //조건식 ? true일때의 값 : false일때의 값
        return (name==null) ? false : true;
    }
 
    
    //아이디 찾기 관련 메소드
    public String find_idCheck(MemberDTO dto) {
        String id = sqlSession.selectOne("memberMapper.find_id_check", dto);
        return id;
        
    }
 
    
    //비밀번호 찾기 관련 메소드
    public String find_passCheck(MemberDTO dto) {
        String pass = sqlSession.selectOne("memberMapper.find_pass_check", dto);
        return pass;
    }
 
    
    //회원 인증 관련 메소드
    //버튼을 클릭한 회원의 정보를 회원 테이블에 저장해서 사용할 수 있게 함
    public void authentication(MemberDTO dto) {
        
        sqlSession.insert("memberMapper.authentication", dto);
        
    }
 
 

    public void pass_change(Map<String, Object> map, MemberDTO dto)throws Exception{
        
        map.get("member_pass");
        map.get("e_mail");
 
        sqlSession.update("memberMapper.pass_change", map);
    }
 
 

    public boolean email_check(String e_mail) throws Exception {
    	System.out.println(e_mail);
    	System.out.println(sqlSession);
        String email
        =sqlSession.selectOne("memberMapper.email_check", e_mail);
    
        //조건식 ? true일때의 값 : false일때의 값
        return (email==null) ? true : false;
        
    }
 
 

    public boolean join_id_check(String user_id) throws Exception {
        String user_id1
        =sqlSession.selectOne("memberMapper.join_id_check", user_id);
    
        //조건식 ? true일때의 값 : false일때의 값
        return (user_id1==null) ? true : false;
    }
 
    
    //회원의 프로필 정보를 리턴한다.

    public List<MemberDTO> member_profile(String user_id) throws Exception {
        
        return sqlSession.selectList("memberMapper.member_profile", user_id);
    }
    
}