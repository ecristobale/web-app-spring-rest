(function() {
	'use strict';
	
	angular
		.module('myAngularApp')
		.factory('UserService', UserService);
	
	UserService.$inject = ['$http', '$q'];

	function UserService($http, $q){
		
		var REST_SERVICE_URI = 'http://localhost:8080/web-app-spring-rest/user';
		
		var service = {
			fetchAllUsers : fetchAllUsers,
			createUser: createUser,
			updateUser: updateUser
		};
		
		return service;
		
		function fetchAllUsers() {
			var deferred = $q.defer();
			$http.get(REST_SERVICE_URI)
				.then(fetchAllUsersComplete)
				.catch(fetchAllUsersFailed);
			
			return deferred.promise;
			
			function fetchAllUsersComplete(response){
				deferred.resolve(response.data);
			}
			
			function fetchAllUsersFailed(errorResponse){
				console.error('Error while fetching users');
				deferred.reject(errorResponse);
			}
		}

		function createUser(user) {
			console.log('Factory --> createUser --> id: ' + user.id + ', username: ' + user.username + ', email: ' + user.email);
			var deferred = $q.defer();
			$http.post(REST_SERVICE_URI, user)
				.then(createUserComplete)
				.catch(createUserFailed);

			return deferred.promise;

			function createUserComplete(response){
				deferred.resolve(response.data);
			}

			function createUserFailed(errorResponse){
				console.error('Error while creating user: { id: ' + user.id + ', username: ' + user.username + ', address: ' + user.address + ', email: ' + user.email + ' }');
				deferred.reject(errorResponse);
			}
		}

		function updateUser(user, id) {
			console.log('Factory --> updateUser --> id: ' + user.id + ', username: ' + user.username + ', email: ' + user.email);
			var deferred = $q.defer();
			$http.put(REST_SERVICE_URI + '/' + id, user)
				.then(updateUserComplete)
				.catch(updateUserFailed);

			return deferred.promise;

			function updateUserComplete(response){
				deferred.resolve(response.data);
			}

			function updateUserFailed(errorResponse){
				console.error('Error while updating user: { id: ' + user.id + ', username: ' + user.username + ', address: ' + user.address + ', email: ' + user.email + ' }');
				deferred.reject(errorResponse);
			}
		}
	}

})();