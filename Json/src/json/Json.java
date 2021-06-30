package json;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import object.dayForecast;
import object.hourForecast;

/**
 * Servlet implementation class Json
 */
@WebServlet("/")
public class Json extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String action = request.getServletPath();
		switch (action) {
		case "/input":
			takeInfo(request, response);
			break;
		default:
			sendForm(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void sendForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/json.jsp");
		dispatcher.forward(request, response);
	}

	public void takeInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// get city name from view
		String cityName = request.getParameter("city");

		// API key
		String key = "svkH5lvDTCHtQpAOdg8xXS5jXx3gwq4M";

		// get city Code
		URL cityURL = new URL(
				"http://dataservice.accuweather.com/locations/v1/cities/search?apikey=" + key + "&q=" + cityName);
		HttpURLConnection cityURLConnection = (HttpURLConnection) cityURL.openConnection();
		InputStream cityIS = cityURLConnection.getInputStream();
		Scanner citySC = new Scanner(cityIS);
		StringBuilder result = new StringBuilder();
		String cityLine;
		while (citySC.hasNextLine()) {
			cityLine = citySC.nextLine();
			result.append(cityLine);
		}
		Object city = JSONValue.parse(result.toString());
		JSONArray cityJsArray = (JSONArray) city;
		JSONObject cityJsObject = (JSONObject) cityJsArray.get(0);
		String cityCode = (String) cityJsObject.get("Key");

		// get current weather info and put it in json object
		URL weatherURL = new URL("http://dataservice.accuweather.com/currentconditions/v1/" + cityCode + "?apikey="
				+ key + "&details=true&metric=true");
		HttpURLConnection weatherURLConnection = (HttpURLConnection) weatherURL.openConnection();
		InputStream weatherIS = weatherURLConnection.getInputStream();
		Scanner weatherSC = new Scanner(weatherIS);
		StringBuilder weatherResult = new StringBuilder();
		String weatherLine;
		while (weatherSC.hasNextLine()) {
			weatherLine = weatherSC.nextLine();
			weatherResult.append(weatherLine);
		}
		System.out.println(weatherResult);
		Object weather = JSONValue.parse(weatherResult.toString());
		JSONArray weatherJsArray = (JSONArray) weather;
		JSONObject weatherJsOb = (JSONObject) weatherJsArray.get(0);

		// temperature
		JSONObject temperature = (JSONObject) weatherJsOb.get("Temperature");
		JSONObject temperatureMetric = (JSONObject) temperature.get("Metric");

		// speed of wind
		JSONObject wind = (JSONObject) weatherJsOb.get("Wind");
		JSONObject speed = (JSONObject) wind.get("Speed");
		JSONObject speedMetric = (JSONObject) speed.get("Metric");

		// get hour weather forecast info by hours and put it in json object
		URL hourForecastURL = new URL("http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/" + cityCode
				+ "?apikey=" + key + "&details=true&metric=true");
		HttpURLConnection hourForecastURLConnection = (HttpURLConnection) hourForecastURL.openConnection();
		InputStream hourForecastIS = hourForecastURLConnection.getInputStream();
		Scanner hourForecastSC = new Scanner(hourForecastIS);
		StringBuilder hourForecastResult = new StringBuilder();
		String hourForecastLine;
		while (hourForecastSC.hasNextLine()) {
			hourForecastLine = hourForecastSC.nextLine();
			hourForecastResult.append(hourForecastLine);
		}
		Object hourForecast = JSONValue.parse(hourForecastResult.toString());
		JSONArray hourForecastJsArray = (JSONArray) hourForecast;
		List<hourForecast> hourForecastList = new ArrayList();
		for (int i = 0; i < hourForecastJsArray.size(); i++) {
			JSONObject hourForecastJsOb = (JSONObject) hourForecastJsArray.get(i);
			// hour
			String dateTime = (String) hourForecastJsOb.get("DateTime");
			String hour = dateTime.substring(11, 16);

			// icon
			Long hourIcon = (Long) hourForecastJsOb.get("WeatherIcon");

			// icon phrase
			String hourIconPhrase = (String) hourForecastJsOb.get("IconPhrase");

			// uv
			Long hourUVindex = (Long) hourForecastJsOb.get("UVIndex");
			String hourUVindexText = (String) hourForecastJsOb.get("UVIndexText");
			String hourUV = hourUVindex + " - (" + hourUVindexText + ")";

			// Temperature
			JSONObject hourForecastTemperature = (JSONObject) hourForecastJsOb.get("Temperature");
			Double hourTem = (Double) hourForecastTemperature.get("Value");

			// Speed of wind
			JSONObject hourForecastWind = (JSONObject) hourForecastJsOb.get("Wind");
			JSONObject hourForecastSpeed = (JSONObject) hourForecastWind.get("Speed");
			String hourWind = (Double) hourForecastSpeed.get("Value") + "km/h";

			// RainProbability;
			String rainProbability = (Long) hourForecastJsOb.get("RainProbability") + "%";

			// SnowProbability;
			String snowProbability = (Long) hourForecastJsOb.get("SnowProbability") + "%";

			// IceProbability;
			String iceProbability = (Long) hourForecastJsOb.get("IceProbability") + "%";

			// Rain
			JSONObject rain = (JSONObject) hourForecastJsOb.get("Rain");
			String hourRain = (Double) rain.get("Value") + "mm";

			// Snow
			JSONObject snow = (JSONObject) hourForecastJsOb.get("Snow");
			String hourSnow = (Double) snow.get("Value") + "cm";

			// Snow
			JSONObject ice = (JSONObject) hourForecastJsOb.get("Ice");
			String hourIce = (Double) ice.get("Value") + "mm";

			hourForecastList.add(new hourForecast(hour, hourIcon, hourIconPhrase, hourUV, hourTem, hourTem / 3,
					hourWind, rainProbability, snowProbability, iceProbability, hourRain, hourSnow, hourIce));
		}

		// get day weather forecast info by hours and put it in json object
		URL dayForecastURL = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + cityCode
				+ "?apikey=" + key + "&details=true&metric=true");
		HttpURLConnection dayForecastURLConnection = (HttpURLConnection) dayForecastURL.openConnection();
		InputStream dayForecastIS = dayForecastURLConnection.getInputStream();
		Scanner dayForecastSC = new Scanner(dayForecastIS);
		StringBuilder dayForecastResult = new StringBuilder();
		String dayForecastLine;
		while (dayForecastSC.hasNextLine()) {
			dayForecastLine = dayForecastSC.nextLine();
			dayForecastResult.append(dayForecastLine);
		}
		Object dayForecast = JSONValue.parse(dayForecastResult.toString());
		JSONObject dayForecastJsArray = (JSONObject) dayForecast;
		JSONArray daylyForecasts = (JSONArray) dayForecastJsArray.get("DailyForecasts");
		List<dayForecast> dayForecastList = new ArrayList();
		for (int i = 0; i < daylyForecasts.size(); i++) {
			JSONObject dayForecastJsOb = (JSONObject) daylyForecasts.get(i);
			// day
			String date = (String) dayForecastJsOb.get("Date");
			String day = date.substring(8, 10);

			Calendar cal = Calendar.getInstance();
			int monthNow = cal.get(Calendar.MONTH) + 1;
			String monthNowString = null;
			if (monthNow == 1) {
				monthNowString = "Jan";
			} else if (monthNow == 2) {
				monthNowString = "Feb";
			} else if (monthNow == 3) {
				monthNowString = "Mar";
			} else if (monthNow == 4) {
				monthNowString = "Apr";
			} else if (monthNow == 5) {
				monthNowString = "May";
			} else if (monthNow == 6) {
				monthNowString = "Jun";
			} else if (monthNow == 7) {
				monthNowString = "Jul";
			} else if (monthNow == 8) {
				monthNowString = "Aug";
			} else if (monthNow == 9) {
				monthNowString = "Sep";
			} else if (monthNow == 10) {
				monthNowString = "Oct";
			} else if (monthNow == 11) {
				monthNowString = "Nov";
			} else if (monthNow == 12) {
				monthNowString = "Dec";
			}

			String dayAndMonth = day + " " + monthNowString;

			// Min Temperature
			JSONObject dayForecastTemperature = (JSONObject) dayForecastJsOb.get("Temperature");
			JSONObject minimum = (JSONObject) dayForecastTemperature.get("Minimum");
			String minDayTem = (Double) minimum.get("Value") + "°C";

			// Max Temperature
			JSONObject maximum = (JSONObject) dayForecastTemperature.get("Maximum");
			String maxDayTem = (Double) maximum.get("Value") + "°C";

			// Speed of wind
			// day
			JSONObject Day = (JSONObject) dayForecastJsOb.get("Day");
			JSONObject dayForecastDayWind = (JSONObject) Day.get("Wind");
			System.out.println(dayForecastDayWind.toString());
			JSONObject dayForecastDaySpeed = (JSONObject) dayForecastDayWind.get("Speed");
			String dayDayWind = (Double) dayForecastDaySpeed.get("Value") + "km/h";
			// night
			JSONObject Night = (JSONObject) dayForecastJsOb.get("Night");
			JSONObject dayForecastNightWind = (JSONObject) Night.get("Wind");
			System.out.println(dayForecastNightWind.toString());
			JSONObject dayForecastNightSpeed = (JSONObject) dayForecastNightWind.get("Speed");
			String dayNightWind = (Double) dayForecastNightSpeed.get("Value") + "km/h";

			// day icon
			Long dayIcon = (Long) Day.get("Icon");
			// night icon
			Long nightIcon = (Long) Night.get("Icon");

			// Air Quality
			JSONArray airAndPollen = (JSONArray) dayForecastJsOb.get("AirAndPollen");
			JSONObject airQuality = (JSONObject) airAndPollen.get(0);
			Long airValue = (Long) airQuality.get("Value");
			String airCategory = (String) airQuality.get("Category");
			String air = airValue + " - " + "(" + airCategory + ")";

			// UV index
			JSONObject uVindex = (JSONObject) airAndPollen.get(5);
			Long uvValue = (Long) uVindex.get("Value");
			String uvCategory = (String) uVindex.get("Category");
			String uV = uvValue + " - " + "(" + uvCategory + ")";

			// RainProbability;
			String dayRainProbability = (Long) Day.get("RainProbability") + "%";
			String nightRainProbability = (Long) Night.get("RainProbability") + "%";

			// SnowProbability;
			String daySnowProbability = (Long) Day.get("SnowProbability") + "%";
			String nightSnowProbability = (Long) Night.get("SnowProbability") + "%";

			// IceProbability;
			String dayIceProbability = (Long) Day.get("IceProbability") + "%";
			String nightIceProbability = (Long) Night.get("IceProbability") + "%";

			// Rain
			// day
			JSONObject dayRain = (JSONObject) Day.get("Rain");
			String dayDayRain = (Double) dayRain.get("Value") + "mm";
			// night
			JSONObject nightRain = (JSONObject) Night.get("Rain");
			String dayNightRain = (Double) nightRain.get("Value") + "mm";

			// Snow
			// day
			JSONObject daySnow = (JSONObject) Day.get("Snow");
			String dayDaySnow = (Double) daySnow.get("Value") + "cm";
			// night
			JSONObject nightSnow = (JSONObject) Night.get("Snow");
			String dayNightSnow = (Double) nightSnow.get("Value") + "cm";

			// Snow
			// day
			JSONObject dayIce = (JSONObject) Day.get("Ice");
			String dayDayIce = (Double) dayIce.get("Value") + "mm";
			// night
			JSONObject nightIce = (JSONObject) Night.get("Ice");
			String dayNightIce = (Double) nightIce.get("Value") + "mm";

			dayForecastList.add(new dayForecast(dayAndMonth, dayIcon, nightIcon, minDayTem, maxDayTem, dayDayWind,
					dayNightWind, uV, air, dayRainProbability, nightRainProbability, daySnowProbability,
					nightSnowProbability, dayIceProbability, nightIceProbability, dayDayRain, dayNightRain, dayDaySnow,
					dayNightSnow, dayDayIce, dayNightIce));
		}

		// get values from the Json Object

		// description of weather
		String weatherText = (String) weatherJsOb.get("WeatherText");
		// humidity
		String relativeHumidity = (Long) weatherJsOb.get("RelativeHumidity") + "%";
		// uv index
		Long uVIndex = (Long) weatherJsOb.get("UVIndex");
		// uv index text
		String uVIndexText = (String) weatherJsOb.get("UVIndexText");
		// city name
		String englishName = (String) cityJsObject.get("EnglishName");
		// icon
		Long weatherIcon = (Long) weatherJsOb.get("WeatherIcon");
		// temperature
		Double temperatureValue = (Double) temperatureMetric.get("Value");
		// speed of wind
		String windValue = (Double) speedMetric.get("Value") + "km/h";
		System.out.println(windValue);

		System.out.println(weatherIcon);

		// move the values to the front-end
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/weatherForecast.jsp");
		request.setAttribute("weatherText", weatherText);
		request.setAttribute("relativeHumidity", relativeHumidity);
		request.setAttribute("englishName", englishName);
		request.setAttribute("value", temperatureValue);
		request.setAttribute("windValue", windValue);
		request.setAttribute("uVIndex", uVIndex);
		request.setAttribute("uVIndexText", uVIndexText);
		request.setAttribute("hourForecastList", hourForecastList);
		request.setAttribute("dayForecastList", dayForecastList);

		String link;
		if (weatherIcon <= 22) {
			link = "https://my-json-server.typicode.com/pqvan20/db/weatherIcon/" + weatherIcon;

		} else {
			link = "https://my-json-server.typicode.com/pqvan20/db/weatherIcons/" + weatherIcon;
		}
		URL imageURL = new URL(link);
		;
		HttpURLConnection imageURLConnection = (HttpURLConnection) imageURL.openConnection();
		InputStream imageIS = imageURLConnection.getInputStream();
		Scanner imageSC = new Scanner(imageIS);
		StringBuilder imageResult = new StringBuilder();
		String imageLine;
		while (imageSC.hasNextLine()) {
			imageLine = imageSC.nextLine();
			imageResult.append(imageLine);
		}
		System.out.println(imageResult.toString());
		Object image = JSONValue.parse(imageResult.toString());
		JSONObject imageJsOb = (JSONObject) image;
		String imageLink = (String) imageJsOb.get("link");
		System.out.println(imageLink);
		request.setAttribute("imageLink", imageLink);

		// Date
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int dateNow = cal.get(Calendar.DATE);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int yearNow = cal.get(Calendar.YEAR);
		int hourNow = cal.get(Calendar.HOUR);
		int minuteNow = cal.get(Calendar.MINUTE);
		String dayOfWeekString = null;
		if (dayOfWeek == 2) {
			dayOfWeekString = "Mon";
		} else if (dayOfWeek == 3) {
			dayOfWeekString = "Tus";
		} else if (dayOfWeek == 4) {
			dayOfWeekString = "Wed";
		} else if (dayOfWeek == 5) {
			dayOfWeekString = "Thu";
		} else if (dayOfWeek == 6) {
			dayOfWeekString = "Fri";
		} else if (dayOfWeek == 7) {
			dayOfWeekString = "Sat";
		} else if (dayOfWeek == 8) {
			dayOfWeekString = "Sun";
		}
		String timeNow = dayOfWeekString + ", " + dateNow + "/" + monthNow + "/" + yearNow + " " + hourNow + ":"
				+ minuteNow;
		request.setAttribute("timeNow", timeNow);
		dispatcher.forward(request, response);
	}

}
