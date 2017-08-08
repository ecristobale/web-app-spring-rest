(function() {
	'use strict';
	
	angular
		.module('myAngularApp')
		.controller('UserController', UserController);
	
	UserController.$inject = ['$scope', 'UserService'];
	
	function UserController($scope, UserService){
		
		var vm = this; // vm ==> View Model
		vm.user = {id:null, username:'', address:'', email:''};
		vm.users = [];
		
		vm.submit = submit;
		vm.reset = reset;
		
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

		function createUser(user) {
			UserService.createUser(user)
				.then(fetchAllUsers);
		}
		
		function submit() {
			if(vm.user.id === null){
				createUser(vm.user);
			}
			
			
			reset();
		}

		function reset() {
			vm.user = {id:null, username:'', address:'', email:''};
			$scope.myForm.$setPristine();
		}
	}
	
})();