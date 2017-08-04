<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>User Main Page</title>
</head>
<body ng-app="myAngularApp" class="ng-cloak">
	<div class="generic-container" ng-controller="UserController as ctrl">
		<div class="panel panel-default">
			<!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Users </span></div>
            <div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Address</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="user in ctrl.users">
							<td><span ng-bind="user.id"></span></td>
							<td><span ng-bind="user.name"></span></td>
							<td><span ng-bind="user.address"></span></td>
							<td><span ng-bind="user.email"></span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script> 
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
    <script src="<c:url value='/static/js/factory/user_factory.js' />"></script>
</body>
</html>