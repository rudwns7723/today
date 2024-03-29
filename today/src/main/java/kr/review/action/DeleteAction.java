package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.review.dao.ReviewDAO;
import kr.review.vo.ReviewVO;
import kr.controller.Action;
import kr.reservation.vo.ReservationVO;
import kr.util.FileUtil;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		//로그인 된 경우
		int r_num = Integer.parseInt(
				       request.getParameter("r_num"));
		ReviewDAO dao = ReviewDAO.getInstance();
		
		ReviewVO review = dao.getReview(r_num);
		if(user_num != review.getM_num()) {
			//로그인한 회원번호와 작성자 회원번호가 불일치
			return "/WEB-INF/views/common/notice.jsp";
		}
		
		//로그인한 회원번호와 작성자 회원번호가 일치
		dao.deleteReview(r_num);
		//파일 삭제
//		FileUtil.removeFile(request, db_board.getFilename());
		
		return "redirect:/review/reviewPage.do";
	}

}
