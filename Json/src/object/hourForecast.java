package object;

public class hourForecast {

	private String dateTime;
	private Long hourIcon;
	private String hourIconPhrase;
	private String uVindex;
	private Double temperature;
	private Double temperatureDivideBy3;
	private String wind;
	private String rainProbability;
	private String snowProbability;
	private String iceProbability;
	private String rain;
	private String snow;
	private String ice;

	public hourForecast() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hourForecast(String dateTime, Long hourIcon, String hourIconPhrase, String uVindex, Double temperature,
			Double temperatureDivideBy3, String wind, String rainProbability, String snowProbability,
			String iceProbability, String rain, String snow, String ice) {
		super();
		this.dateTime = dateTime;
		this.hourIcon = hourIcon;
		this.hourIconPhrase = hourIconPhrase;
		this.uVindex = uVindex;
		this.temperature = temperature;
		this.temperatureDivideBy3 = temperatureDivideBy3;
		this.wind = wind;
		this.rainProbability = rainProbability;
		this.snowProbability = snowProbability;
		this.iceProbability = iceProbability;
		this.rain = rain;
		this.snow = snow;
		this.ice = ice;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Long getHourIcon() {
		return hourIcon;
	}

	public void setHourIcon(Long hourIcon) {
		this.hourIcon = hourIcon;
	}

	public String getHourIconPhrase() {
		return hourIconPhrase;
	}

	public void setHourIconPhrase(String hourIconPhrase) {
		this.hourIconPhrase = hourIconPhrase;
	}

	public String getuVindex() {
		return uVindex;
	}

	public void setuVindex(String uVindex) {
		this.uVindex = uVindex;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getTemperatureDivideBy3() {
		return temperatureDivideBy3;
	}

	public void setTemperatureDivideBy3(Double temperatureDivideBy3) {
		this.temperatureDivideBy3 = temperatureDivideBy3;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getRainProbability() {
		return rainProbability;
	}

	public void setRainProbability(String rainProbability) {
		this.rainProbability = rainProbability;
	}

	public String getSnowProbability() {
		return snowProbability;
	}

	public void setSnowProbability(String snowProbability) {
		this.snowProbability = snowProbability;
	}

	public String getIceProbability() {
		return iceProbability;
	}

	public void setIceProbability(String iceProbability) {
		this.iceProbability = iceProbability;
	}

	public String getRain() {
		return rain;
	}

	public void setRain(String rain) {
		this.rain = rain;
	}

	public String getSnow() {
		return snow;
	}

	public void setSnow(String snow) {
		this.snow = snow;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

}
