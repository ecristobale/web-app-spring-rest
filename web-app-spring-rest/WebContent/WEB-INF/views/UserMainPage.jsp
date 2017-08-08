<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>  
	<title>User Main Page</title>  
	<style>
		.username.ng-valid {
			background-color: lightgreen;
		}
		.username.ng-dirty.ng-invalid-required {
			background-color: red;
		}
		.username.ng-dirty.ng-invalid-minlength {
			background-color: yellow;
		}

		.email.ng-valid {
			background-color: lightgreen;
		}
		.email.ng-dirty.ng-invalid-required {
			background-color: red;
		}
		.email.ng-dirty.ng-invalid-email {
			background-color: yellow;
		}
	</style>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myAngularApp" class="ng-cloak">
	<div class="generic-container" ng-controller="UserController as userCtrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="userCtrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="userCtrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Name (*)</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="userCtrl.user.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="userCtrl.user.address" id="address" class="form-control input-sm" placeholder="Enter your Address"/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email (*)</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="userCtrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!userCtrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="userCtrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Address</th>
                              <th>Email</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="usr in userCtrl.users">
                              <td><span ng-bind="usr.id"></span></td>
                              <td><span ng-bind="usr.username"></span></td>
                              <td><span ng-bind="usr.address"></span></td>
                              <td><span ng-bind="usr.email"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
	</div>
       
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.min.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
	<script src="<c:url value='/static/js/factory/user_factory.js' />"></script>
</body>
</html>