<%--
  Created by IntelliJ IDEA.
  User: dainv
  Date: 7/21/2014
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Application</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <h1>History</h1>

        <table class="table table-bordered table-striped" align="center">
            <thead>
                <tr>
                    <th>Device</th>
                    <th>Command</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${histories}" var="history" varStatus="i">
                <tr>
                    <td>
                        <h4>${history.device.name}</h4>
                    </td>
                    <td>
                        <h4>${history.command.name}</h4>
                    </td>
                    <td>
                        <h4>${history.date}</h4>
                    </td>
                    <td>
                        <h4>${history.success}</h4>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form:form action="../progress" method="get">
            <button  class="btn btn-default">Go to Sending Page</button>
        </form:form>
</div>
</body>
</html>