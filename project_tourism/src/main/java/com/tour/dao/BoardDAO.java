package com.tour.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	static final String namespace = "com.tour.board";
	
	public int register(BoardDTO dto) {
		return sqlSession.insert(namespace+".register", dto);
	}
	
	public Integer getMaxRef() {
		return sqlSession.selectOne(namespace+".getMaxRef");
	}
	public List<BoardDTO> getList(){
		return sqlSession.selectList(namespace+".getList");
	}
	
	public BoardDTO getDetail(int id) {
		return sqlSession.selectOne(namespace+".getDetail", id);
	}
}
