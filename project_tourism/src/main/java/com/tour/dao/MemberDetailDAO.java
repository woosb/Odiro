package com.tour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.dto.WishListDTO;

@Repository
public class MemberDetailDAO {
	@Autowired
	SqlSession sqlSession;
	static final String namespace = "com.tour.memberDetail";
	
	public List<WishListDTO> getWishList(String e_mail) {
		return sqlSession.selectList(namespace+".getWishList", e_mail);
	}
	
	public int deleteWishList(WishListDTO dto) {
		return sqlSession.delete(namespace+".deleteWishList", dto);
	}
	
	public int addWishList(WishListDTO dto) {
		return sqlSession.insert(namespace+".addWishList", dto);
	}
}
