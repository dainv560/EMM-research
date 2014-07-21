<%--
  Created by IntelliJ IDEA.
  User: dainv
  Date: 7/18/2014
  Time: 2:11 PM
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

    <c:if test="${!empty devices}">
        <c:if test="${!empty commands}">

        <h3>Sending Command</h3>
        <form:form method="post" commandName="history">
            <table class="table table-bordered table-striped" align="center">
                <thead>
                <tr>
                    <th>Device</th>
                    <!--<th>&nbsp;</th>-->
                    <th>Command</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <form:select path="device_id" class="form-control" id="device">
                            <c:forEach items="${devices}" var="device" varStatus="i">
                                <option  value=${device.id} id=${device.id}>${device.name}</option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td>
                        <form:select path="command_id" class="form-control" id="command">
                            <c:forEach items="${commands}" var="command" varStatus="i">
                                <option value=${command.id} id=${command.id}>${command.name}</option>
                            </c:forEach>
                        </form:select>
                    </td>

                </tr>
                </tbody>
            </table>

            <button align="right" type="submit" class="btn btn-primary">SEND</button>

        </form:form>
        </c:if>
    </c:if>
    <c:if test="${empty devices}">
        <p align="center">
            <h3>No Device</h3>
        </p>
    </c:if>
    <c:if test="${empty commands}">
        <p align="center">
        <h3>No Command</h3>
        </p>
    </c:if>

</div>
</body>
</html>