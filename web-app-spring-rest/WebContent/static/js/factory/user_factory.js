(function() {
	'use strict';
	
	angular
		.module('myAngularApp')
		.factory('UserService', UserService);
	
	UserService.$inject = ['$http', '$q'];

	function UserService($http, $q){
		
		var REST_SERVICE_URI = 'http://localhost:8080/web-app-spring-rest/user';
		
		var service = {
			fetchAllUsers : fetchAllUsers 	
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
				console.log('Error while fetching users');
				deferred.reject(errorResponse);
			}
		}
	}

})();