(function() {
	'use strict';
	
	angular
		.module('myAngularApp')
		.controller('UserController', UserController);
	
	UserController.$inject = ['UserService'];
	
	function UserController(UserService){
		
		var vm = this; // vm ==> View Model
		vm.users = [];
		
		activate();
		
		function activate() {
			return fetchAllUsers().then(function() {
				console.log('Activated all users view');
			})
		}
		
		function fetchAllUsers() {
			return UserService.fetchAllUsers()
				.then(function(data) {
					vm.users = data;
					return vm.users;
				});
		}
	}
	
})();