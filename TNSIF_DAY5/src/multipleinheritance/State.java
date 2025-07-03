package multipleinheritance;

public class State extends Country {

	private String statename;
	private String language;
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "State [statename=" + statename + ", language=" + language + ", Countryname()=" + getCountryname()
				+ ", Capital()=" + getCapital() + "]";
	}
	
}
