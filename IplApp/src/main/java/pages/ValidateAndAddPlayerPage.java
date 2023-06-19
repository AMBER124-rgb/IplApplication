package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

/**
 * Servlet implementation class ValidateAndAddPlayerPage
 */
@WebServlet("/validate")
public class ValidateAndAddPlayerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get session
			HttpSession session = request.getSession();
			// get daos
			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
			// get req params --parse --validation
			int teamId = Integer.parseInt(request.getParameter("team_id"));
			System.out.println(teamId);
//			int playerId, String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken,int teamId
			String fname=request.getParameter("first_name");
			String lname=request.getParameter("last_name");
			LocalDate dob=LocalDate.parse(request.getParameter("dob"));
			double battingAvg=Double.parseDouble(request.getParameter("avg"));
			int wicketsTaken=Integer.parseInt(request.getParameter("wickets"));
			int ageInYears = Period.between(dob, LocalDate.now()).getYears();
			List<Team> allTeams = teamDao.getAllTeams();
			Team t1=teamDao.getSelectedTeamDetails(teamId);
			Date d=Date.valueOf(dob);
			pw.print(ageInYears);
			Player testPlayer = new Player(fname,lname,d,battingAvg,wicketsTaken,teamId);
			System.out.println("id in obj " + testPlayer.getTeamId());
			if(ageInYears<t1.getMaxAge() && battingAvg>t1.getBattingAvg()&& wicketsTaken>t1.getWicketsTaken()) {
				playerDao.addNewPlayer(testPlayer);
				pw.print("Player added successfully");
			}else
			{
				pw.print("Player not added");
			}
			// dob : LocalDate.parse(....) --> age : Period.between --> compare max age :
			// compare it with db data --success
			//Date.valueOf(localdate)
			//in case of success : playerDao's --insert
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
