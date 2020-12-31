package com.tour.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.dto.NoticeBoardDTO;

@Repository
public class NoticeBoardDAO {
	static final String namespace = "com.tour.noticeMapper";
	@Autowired
	SqlSession sqlSession;
	public List<NoticeBoardDTO> getList(int start, int end, String searchOption, String keyword) {
		//검색 옵션, 키워드 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		//BETWEEN #{start}, #{end}에 입력될 값을 맵에 저장
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(namespace+".getList",map);
	}
	public List<NoticeBoardDTO> getList2()
	{
		return sqlSession.selectList(namespace+".getList2");
	}
	public int countBoardList(String searchOption, String keyword) {
		//검색 옵션, 키워드 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne(namespace+".countBoardList",map);
	}
	public void regBoard(HttpServletRequest req) {
		NoticeBoardDTO dto = new NoticeBoardDTO();
		dto.setNotice_title((String)req.getParameter("notice_title"));
		dto.setNotice_content((String)req.getParameter("notice_content"));
		sqlSession.insert(namespace+".regBoard",dto);
	}
	public NoticeBoardDTO getDetail(String no) {
		return sqlSession.selectOne(namespace+".getDetail", no);
	}
	public void upHit(String no) {
		sqlSession.update(namespace+".upHit", no);
	}
	public void modifyOk(NoticeBoardDTO dto) {
		sqlSession.update(namespace+".modifyOk",dto);
	}
	public void deleteBoard(String no) {
		sqlSession.delete(namespace+".deleteBoard",no);
	}
	public List<NoticeBoardDTO> getNotice() {
		return sqlSession.selectList(namespace+".get_Notice");
	}
}
