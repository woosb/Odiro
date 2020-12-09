package com.tour.dao;

import java.util.List;

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
	public List<NoticeBoardDTO> selectNoticeList() {
		return sqlSession.selectList(namespace+".selectNoticeList");
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
}
