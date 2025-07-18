package multipleinheritance;

public class City extends State {
   private String cityname;
   private float area;
public String getCityname() {
	return cityname;
}
public void setCityname(String cityname) {
	this.cityname = cityname;
}
public float getArea() {
	return area;
}
public void setArea(float area) {
	this.area = area;
}
@Override
public String toString() {
	return "City [cityname=" + cityname + ", area=" + area + ", Statename()=" + getStatename() + ", Language()="
			+ getLanguage() + ", Countryname()=" + getCountryname() + ", Capital()=" + getCapital() + "]";
}
   
   
}

