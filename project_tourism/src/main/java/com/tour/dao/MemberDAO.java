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
	public String get_email(String nick)
	{
		return sqlSession.selectOne("memberMapper.get_email",nick);
	}

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
 
    
    //닉네임 찾기 관련 메소드
    public String find_nickcname_check(MemberDTO dto) {
        String id = sqlSession.selectOne("memberMapper.find_nickcname_check", dto);
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
 
 

    public void pass_change(MemberDTO dto)throws Exception{

    	System.out.println(dto.getE_mail());
    	System.out.println(dto.getUser_pass());
        sqlSession.update("memberMapper.passChange", dto);
        System.out.println("실행완료");
    }
 
 

    public boolean email_check(String e_mail) throws Exception {
    	System.out.println(e_mail);
    	System.out.println(sqlSession);
        String email
        =sqlSession.selectOne("memberMapper.email_check", e_mail);
    
        //조건식 ? true일때의 값 : false일때의 값
        return (email==null) ? true : false;
        
    }
 
 

    public int nickName_check(String nickName) throws Exception {
        String nickName1
        =sqlSession.selectOne("memberMapper.nickName_check", nickName);
    
        //조건식 ? true일때의 값 : false일때의 값
        return (nickName1==null) ? 0 : 1;
    }
 
    
    //회원의 프로필 정보를 리턴한다.

    public List<MemberDTO> member_profile(String e_mail) throws Exception {
        
        return sqlSession.selectList("memberMapper.member_profile", e_mail);
    }
    //관리자 페이지
    public List<MemberDTO> member() throws Exception {
        
        return sqlSession.selectList("memberMapper.member");
    }
    //회원 정보 삭제
	public void remove(String e_mail)
	{
		sqlSession.delete("memberMapper.remove",e_mail);
	}
	//닉네임 변경
	public void update(MemberDTO dto)
	{
		sqlSession.update("memberMapper.nickName_change",dto);
	}


	public boolean nick_check(String nick) {
		System.out.println(nick);
    	System.out.println(sqlSession);
        String nick2
        =sqlSession.selectOne("memberMapper.nickName_check", nick);
    
        //조건식 ? true일때의 값 : false일때의 값
        return (nick2==null) ? true : false;
	}
	
    
}