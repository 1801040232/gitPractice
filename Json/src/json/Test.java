package json;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Test {

	public static void main(String[] args) throws IOException {
		// city
		URL cityURL;
		HttpURLConnection urlConnection;
		cityURL = new URL(
				"http://dataservice.accuweather.com/locations/v1/cities/search?apikey=e9YWgVGcb7MBFZYKNVI8eTvyBeGHI1iR&q=Hanoi");
		urlConnection = (HttpURLConnection) cityURL.openConnection();
		InputStream is = urlConnection.getInputStream();
		Scanner sc = new Scanner(is);
		StringBuilder result = new StringBuilder();
		String line;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			result.append(line);
		}
		System.out.println(result);
		Object obj = JSONValue.parse(result.toString());
		JSONArray jsonarray = (JSONArray) obj;
		JSONObject jsob = (JSONObject) jsonarray.get(0);
		String key = (String) jsob.get("Key");

		// weather
		URL weatherURL;
		HttpURLConnection weatherURLConnection;
		weatherURL = new URL("http://dataservice.accuweather.com/currentconditions/v1/" + key
				+ "?apikey=e9YWgVGcb7MBFZYKNVI8eTvyBeGHI1iR");
		weatherURLConnection = (HttpURLConnection) weatherURL.openConnection();
		InputStream weatherIS = weatherURLConnection.getInputStream();
		Scanner weatherSC = new Scanner(weatherIS);
		StringBuilder weatherResult = new StringBuilder();
		String weatherLine;
		while (weatherSC.hasNextLine()) {
			weatherLine = weatherSC.nextLine();
			weatherResult.append(weatherLine);
		}
		System.out.println(weatherResult);
		Object weatherObj = JSONValue.parse(weatherResult.toString());
		JSONArray weatherJsonArray = (JSONArray) weatherObj;
		JSONObject weatherJsOb = (JSONObject) weatherJsonArray.get(0);

		String weatherText = (String) weatherJsOb.get("WeatherText");
		String englishName = (String) jsob.get("EnglishName");

		JSONObject weatherJsOb1 = (JSONObject) weatherJsOb.get("Temperature");
		JSONObject weatherJsOb2 = (JSONObject) weatherJsOb1.get("Metric");
		Double value = (Double) weatherJsOb2.get("Value");

		System.out.println(weatherText);
		System.out.println(value);
		System.out.println(englishName);
	}
}
