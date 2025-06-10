package member;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mcontrol")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new MemberDAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		String view = "";
		if(action == null) {
			getServletContext().getRequestDispatcher("/mcontrol?action=list").forward(req, resp);
		}else {
			switch(action) {
			case "list": view = list(req, resp); break;
			case "insert": view = insert(req, resp); break;
			}
			getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
	
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("memberlist", dao.getAll());
		return "/memberinfo.jsp";
	}
	
	public String insert(HttpServletRequest req, HttpServletResponse resp) {
		return "";
	}	
	
	
	
	
       


}
