<%--
  Created by IntelliJ IDEA.
  User: dainv
  Date: 7/18/2014
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <p align="center">
        <h2>Send Command</h2>
    </p>

    <table>
        <thead>
            <tr>
                <th>Device</th>
                <th>Command</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th>
                    <c:forEach items="${devices}" var="device" varStatus="i">
                        <select class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </c:forEach>
                </th>
                <th></th>
            </tr>
        </tbody>
    </table>

</body>
</html>
