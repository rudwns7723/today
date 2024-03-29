package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.reservation.dao.ReservationDAO;
import kr.reservation.vo.ReservationVO;
import kr.review.dao.ReviewDAO;

public class WriteFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num =
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		//로그인 된 경우
//		int rev_num = Integer.parseInt(
//				request.getParameter("rev_num"));
////
//		ReviewDAO dao = ReviewDAO.getInstance();
//		ReservationVO rez = dao.getReservation(rev_num);
		
		
		return "/WEB-INF/views/review/writeForm.jsp";
		
		
	}

}
