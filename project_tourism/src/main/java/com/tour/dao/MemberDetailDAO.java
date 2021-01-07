package com.tour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.dto.ContentInfoDTO;
import com.tour.dto.MySchedulerDTO;

@Repository
public class MemberDetailDAO {
	@Autowired
	SqlSession sqlSession;
	static final String namespace = "com.tour.memberDetail";
	
	public List<ContentInfoDTO> getWishList(String e_mail) {
		return sqlSession.selectList(namespace+".getWishList", e_mail);
	}
	
	public int deleteWishList(ContentInfoDTO dto) {
		return sqlSession.delete(namespace+".deleteWishList", dto);
	}
	
	public int addWishList(ContentInfoDTO dto) {
		return sqlSession.insert(namespace+".addWishList", dto);
	}
	
	public int addSchedul(MySchedulerDTO dto) {
		return sqlSession.insert(namespace+".addSchedul", dto);
	}
	
	public List<MySchedulerDTO> getMySchedul(String e_mail){
		return sqlSession.selectList(namespace+".getMySchedul", e_mail);
	}
	
	public int removeMySchedul(int id) {
		return sqlSession.delete(namespace+".removeMyScchedul", id);
	}
}
