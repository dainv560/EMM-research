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
            <form:form method="post" action="add" commandName="device" role="form">
                <div class="form-group">
                    <form:label path="name">Name:</form:label>
                    <form:input path="name" class="form-control" placeholder="Name"/>
                </div>
                <button type="submit" class="btn btn-default">Add Device</button>
            </form:form>

            <c:if test="${!empty devices}">
                <h3>Devices</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Index</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${devices}" var="device" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${device.id}</td>
                                <td>${device.name}</td>
                                <td>
                                    <form:form action="delete/${device.id}" method="post"><input type="submit"
                                                                                               class="btn btn-danger btn-mini"
                                                                                               value="Delete"/>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
</html>