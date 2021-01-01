package com.tour.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.dto.BoardDTO;
import com.tour.dto.Criteria;
import com.tour.dto.ContentInfoDTO;

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
	
	public List<BoardDTO> getList(Criteria cri){
		return sqlSession.selectList(namespace+".getList", cri);
	}
	
	public BoardDTO getDetail(int id) {
		return sqlSession.selectOne(namespace+".getDetail", id);
	}
	
	public int delete(int ref) {
		return sqlSession.delete(namespace+".delete", ref);
	}
	
	public int modify(BoardDTO dto) {
		return sqlSession.update(namespace+".modify", dto);
	}
	
	public int reply(BoardDTO dto) {
		return sqlSession.insert(namespace+".reply", dto);
	}
	
	public int addRefOrder(BoardDTO dto) {
		return sqlSession.update(namespace+".addRefOrder", dto);
	}
	
	public int addReplyNum(int parentNum) {
		return sqlSession.update(namespace+".addReplyNum", parentNum);
	}
	
	public List<BoardDTO> getReply(int ref) {
		return sqlSession.selectList(namespace+".getReply", ref);
	}
	
	public int upHit(int id) {
		return sqlSession.update(namespace+".upHit", id);
	}
	
	public int upRecommend(int id) {
		return sqlSession.update(namespace+".upRecommend", id);
	}
	
	public int getTotal() {
		return sqlSession.selectOne(namespace+".getTotal");
	} 
}
