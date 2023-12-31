package pojos;
/*
 * 	id (PK), first_name,last_name, dob,batting_avg,wickets_taken....
	+team_id (FK)
 */

import java.sql.Date;
import java.time.LocalDate;

public class Player {
	private int playerId;//PK
	private String firstName;
	private String lastName;
	private Date dob;
	private double battingAvg;
	private int wicketsTaken;
	//FK 
	private int teamId;
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(int playerId, String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken,
			int teamId) {
		super();
		this.playerId = playerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
		this.teamId = teamId;
	}
	public Player(String fname, String lname, Date d, double battingAvg2, int wicketsTaken2, int teamId2) {
		this.firstName = fname;
		this.lastName = lname;
		this.dob = d;
		this.battingAvg = battingAvg2;
		this.wicketsTaken = wicketsTaken2;
		this.teamId = teamId2;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + ", teamId=" + teamId + "]";
	}
	
}
