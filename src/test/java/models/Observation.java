package models;

public class Observation {
	
	private int id;
	private String participantName;
	private String date;
	private String rating;
	private String round;
	private String role;
	private String percentage;
	private String framing;
	private String voice;
	private String whatToDo;
	private String efficiency;
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getFraming() {
		return framing;
	}
	public void setFraming(String framing) {
		this.framing = framing;
	}
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public String getWhatToDo() {
		return whatToDo;
	}
	public void setWhatToDo(String whatToDo) {
		this.whatToDo = whatToDo;
	}
	public String getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}
	
	
}
