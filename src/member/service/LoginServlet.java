package member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.been.MemberDTO;
import member.dao.MemberDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// post 방식일때만  한글처리
		request.setCharacterEncoding("UTF-8");

		// 데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DB 
		MemberDAO memberDAO = MemberDAO.getInstance();
		String name = memberDAO.loginMember(id, pwd);
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>회원가입</title>");	
   
    	if(name == null) out.println("로그인실패"); 
    	else out.println(name+"님이 로그인하셨습니다.");    	 
    	
    	out.println("<body>");
    	out.println("</body>");    	
    	out.println("</head>");
    	out.println("</html>");
	}
}
