package object;

public class dayForecast {

	private String date; // not edit
	private Long dayIcon;
	private Long nightIcon;
	private String minTemperature; // not edit
	private String maxTemperature; // not edit
	private String dayWind; // edit
	private String nightWind;
	private String uVIndex; // not edit
	private String airQualityCategory; // not edit
	private String dayRainProbability;
	private String nightRainProbability;
	private String daySnowProbability;
	private String nightSnowProbability;
	private String dayIceProbability;
	private String nightIceProbability;
	private String dayRain;
	private String nightRain;
	private String daySnow;
	private String nightSnow;
	private String dayIce;
	private String nightIce;

	public dayForecast() {
		super();
		// TODO Auto-generated constructor stub
	}

	public dayForecast(String date, Long dayIcon, Long nightIcon, String minTemperature, String maxTemperature,
			String dayWind, String nightWind, String uVIndex, String airQualityCategory, String dayRainProbability,
			String nightRainProbability, String daySnowProbability, String nightSnowProbability,
			String dayIceProbability, String nightIceProbability, String dayRain, String nightRain, String daySnow,
			String nightSnow, String dayIce, String nightIce) {
		super();
		this.date = date;
		this.dayIcon = dayIcon;
		this.nightIcon = nightIcon;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.dayWind = dayWind;
		this.nightWind = nightWind;
		this.uVIndex = uVIndex;
		this.airQualityCategory = airQualityCategory;
		this.dayRainProbability = dayRainProbability;
		this.nightRainProbability = nightRainProbability;
		this.daySnowProbability = daySnowProbability;
		this.nightSnowProbability = nightSnowProbability;
		this.dayIceProbability = dayIceProbability;
		this.nightIceProbability = nightIceProbability;
		this.dayRain = dayRain;
		this.nightRain = nightRain;
		this.daySnow = daySnow;
		this.nightSnow = nightSnow;
		this.dayIce = dayIce;
		this.nightIce = nightIce;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getDayIcon() {
		return dayIcon;
	}

	public void setDayIcon(Long dayIcon) {
		this.dayIcon = dayIcon;
	}

	public Long getNightIcon() {
		return nightIcon;
	}

	public void setNightIcon(Long nightIcon) {
		this.nightIcon = nightIcon;
	}

	public String getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(String minTemperature) {
		this.minTemperature = minTemperature;
	}

	public String getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(String maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public String getDayWind() {
		return dayWind;
	}

	public void setDayWind(String dayWind) {
		this.dayWind = dayWind;
	}

	public String getNightWind() {
		return nightWind;
	}

	public void setNightWind(String nightWind) {
		this.nightWind = nightWind;
	}

	public String getuVIndex() {
		return uVIndex;
	}

	public void setuVIndex(String uVIndex) {
		this.uVIndex = uVIndex;
	}

	public String getAirQualityCategory() {
		return airQualityCategory;
	}

	public void setAirQualityCategory(String airQualityCategory) {
		this.airQualityCategory = airQualityCategory;
	}

	public String getDayRainProbability() {
		return dayRainProbability;
	}

	public void setDayRainProbability(String dayRainProbability) {
		this.dayRainProbability = dayRainProbability;
	}

	public String getNightRainProbability() {
		return nightRainProbability;
	}

	public void setNightRainProbability(String nightRainProbability) {
		this.nightRainProbability = nightRainProbability;
	}

	public String getDaySnowProbability() {
		return daySnowProbability;
	}

	public void setDaySnowProbability(String daySnowProbability) {
		this.daySnowProbability = daySnowProbability;
	}

	public String getNightSnowProbability() {
		return nightSnowProbability;
	}

	public void setNightSnowProbability(String nightSnowProbability) {
		this.nightSnowProbability = nightSnowProbability;
	}

	public String getDayIceProbability() {
		return dayIceProbability;
	}

	public void setDayIceProbability(String dayIceProbability) {
		this.dayIceProbability = dayIceProbability;
	}

	public String getNightIceProbability() {
		return nightIceProbability;
	}

	public void setNightIceProbability(String nightIceProbability) {
		this.nightIceProbability = nightIceProbability;
	}

	public String getDayRain() {
		return dayRain;
	}

	public void setDayRain(String dayRain) {
		this.dayRain = dayRain;
	}

	public String getNightRain() {
		return nightRain;
	}

	public void setNightRain(String nightRain) {
		this.nightRain = nightRain;
	}

	public String getDaySnow() {
		return daySnow;
	}

	public void setDaySnow(String daySnow) {
		this.daySnow = daySnow;
	}

	public String getNightSnow() {
		return nightSnow;
	}

	public void setNightSnow(String nightSnow) {
		this.nightSnow = nightSnow;
	}

	public String getDayIce() {
		return dayIce;
	}

	public void setDayIce(String dayIce) {
		this.dayIce = dayIce;
	}

	public String getNightIce() {
		return nightIce;
	}

	public void setNightIce(String nightIce) {
		this.nightIce = nightIce;
	}

}
