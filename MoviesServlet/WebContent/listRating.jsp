<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="list.css" rel="stylesheet" />
<title>Ratings</title>
</head>
<body>
	<form method="POST" action='RatingController' name="frm">
        Date : <input
            type="text" name="date"
             /> <br /> <input
            type="submit" value="Submit" />
    </form>
    

    <table border=1>
    	<caption>Ratings</caption>
        <thead>
            <tr>
            	<th>Position</th>
                <th>Title</th>
                <th>Year</th>
                <th>Votes</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ratings}" var="rating">
                <tr>
                    <td><c:out value="${rating.getPosition()}" /></td>
                    <td><c:out value="${rating.getMovie().getName()}" /></td>
                    <td><c:out value="${rating.getMovie().getYear()}" /></td>
                    <td><c:out value="${rating.getVotes()}" /></td>
                    <td><c:out value="${rating.getDate()}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>