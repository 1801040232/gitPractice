<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	${englishName}
	<br> ${weatherText}
	<br> ${value}
	<br> humidity
	<br> ${relativeHumidity}
	<br> Speed of wind
	<br> ${windValue}
	<br> ${timeNow}
	<br> ${uVIndex}
	<br> ${uVIndexText}
	<br>
	<img src="${imageLink}" />

	<hr>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>dateTime</th>
				<th>temperature</th>
				<th>wind</th>
				<th>rainProbability</th>
				<th>snowProbability</th>
				<th>iceProbability</th>
				<th>rain</th>
				<th>snow</th>
				<th>ice</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="hour" items="${hourForecastList}">
				<tr>
					<td><c:out value="${hour.dateTime}" /></td>
					<td><c:out value="${hour.temperature}" /></td>
					<td><c:out value="${hour.wind}" /></td>
					<td><c:out value="${hour.rainProbability}" /></td>
					<td><c:out value="${hour.snowProbability}" /></td>
					<td><c:out value="${hour.iceProbability}" /></td>
					<td><c:out value="${hour.rain}" /></td>
					<td><c:out value="${hour.snow}" /></td>
					<td><c:out value="${hour.ice}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>date</th>
				<th>minTemperature</th>
				<th>maxTemperature</th>
				<th>dayWind</th>
				<th>nightWind</th>
				<th>uVIndex</th>
				<th>airQualityCategory</th>
				<th>dayRainProbability</th>
				<th>nightRainProbability</th>
				<th>daySnowProbability</th>
				<th>nightSnowProbability</th>
				<th>dayIceProbability</th>
				<th>nightIceProbability</th>
				<th>dayRain</th>
				<th>nightRain</th>
				<th>daySnow</th>
				<th>nightSnow</th>
				<th>dayIce</th>
				<th>nightIce</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="day" items="${dayForecastList}">
				<tr>
					<td><c:out value="${day.date}" /></td>
					<td><c:out value="${day.minTemperature}" /></td>
					<td><c:out value="${day.maxTemperature}" /></td>
					<td><c:out value="${day.dayWind}" /></td>
					<td><c:out value="${day.nightWind}" /></td>
					<td><c:out value="${day.uVIndex}" /></td>
					<td><c:out value="${day.airQualityCategory}" /></td>
					<td><c:out value="${day.dayRainProbability}" /></td>
					<td><c:out value="${day.nightRainProbability}" /></td>
					<td><c:out value="${day.daySnowProbability}" /></td>
					<td><c:out value="${day.nightSnowProbability}" /></td>
					<td><c:out value="${day.dayIceProbability}" /></td>
					<td><c:out value="${day.nightIceProbability}" /></td>
					<td><c:out value="${day.dayRain}" /></td>
					<td><c:out value="${day.nightRain}" /></td>
					<td><c:out value="${day.daySnow}" /></td>
					<td><c:out value="${day.nightSnow}" /></td>
					<td><c:out value="${day.dayIce}" /></td>
					<td><c:out value="${day.nightIce}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>