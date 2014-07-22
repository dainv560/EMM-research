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
            <h1>Devices</h1>
            <form:form method="post" class="form-inline" action="addDevice" commandName="device" role="form">
                <div class="form-group">
                    <form:label path="name">Name:</form:label>
                    <form:input path="name" class="form-control" placeholder="Name"/>
                    <form:label path="platform">Platform:</form:label>
                    <form:input path="platform" class="form-control" placeholder="Platform"/>
                </div>
                <button type="submit" class="btn btn-default">Add Device</button>
            </form:form>

            <c:if test="${!empty devices}">
                <h3>Devices</h3>
                    <table class="table table-bordered table-striped" align="center">
                        <thead>
                            <tr>
                                <th>Device</th>
                                <th>Platform</th>
                                <th>&nbsp;</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${devices}" var="device" varStatus="i">
                                <tr>
                                    <td>
                                        <a href="/history/${device.id}"><h4>${device.name}</h4></a>
                                    </td>
                                    <td>
                                        <h4>${device.platform}</h4>
                                    </td>
                                    <td align="center">
                                        <form:form action="deleteDevice/${device.id}" method="post"><input type="submit"
                                                                                                     class="btn btn-danger btn-mini"
                                                                                                     value="Delete"/>
                                        </form:form>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <form:form class="form-inline" role="form" method="get">
                    <a href="/progress" role="button" class="btn btn-default" >Go to Sending Page</a>
                    <a href="/command" role="button" class="btn btn-default" >Adding Command</a>
                </form:form>
            </c:if>
        </div>
    </body>
</html>