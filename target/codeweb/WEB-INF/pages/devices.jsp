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
                                <select class="form-control">
                                <c:forEach items="${devices}" var="device" varStatus="i">
                                    <option id=${device.id}>${device.name}</option>
                                </c:forEach>
                                </select>
                            </td>
                            <!--<td align="center">
                                <form:form action="delete/${device.id}" method="post"><input type="submit"
                                                                                           class="btn btn-danger btn-mini"
                                                                                           value="Delete"/>
                                </form:form>
                            </td> -->
                            <td>
                                <select class="form-control">
                                    <option id="command1">command 1</option>
                                    <option id="command2">command 2</option>
                                    <option id="command3">command 3</option>
                                    <option id="command4">command 4</option>
                                    <option id="command5">command 5</option>
                                </select>
                            </td>

                        </tr>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
</html>