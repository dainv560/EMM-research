<%--
  Created by IntelliJ IDEA.
  User: dainv
  Date: 7/21/2014
  Time: 10:40 AM
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
    <h1>Commands</h1>
    <form:form method="post" class="form-inline" action="addCommand" commandName="command" role="form">
        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <form:input path="name" class="form-control" placeholder="Name"/>
        </div>
        <button type="submit" class="btn btn-default">Add Command</button>
    </form:form>

    <c:if test="${!empty commands}">
        <h3>Commands</h3>
            <table class="table table-bordered table-striped" align="center">
                <thead>
                <tr>
                    <th>Command</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${commands}" var="command" varStatus="i">
                        <tr>
                            <td>
                                <h4>${command.name}</h4>
                            </td>
                            <td align="center">
                                <form:form action="deleteCommand/${command.id}" method="post"><input type="submit"
                                                                                           class="btn btn-danger btn-mini"
                                                                                           value="Delete"/>
                                </form:form>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        <form:form action="progress" method="get">
            <button  class="btn btn-default">Go to Sending Page</button>
        </form:form>
    </c:if>
</div>
</body>
</html>