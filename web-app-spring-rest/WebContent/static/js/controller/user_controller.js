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
		vm.edit = edit;
		
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
		
		function updateUser(user, id){
			UserService.updateUser(user, id)
				.then(fetchAllUsers);
		}
		
		function submit() {
			if(vm.user.id === null){
				createUser(vm.user);
			} else{
				updateUser(vm.user, vm.user.id);
				console.log('User updated with id: ' + vm.user.id);
			}
						
			reset();
		}

		function reset() {
			vm.user = {id:null, username:'', address:'', email:''};
			$scope.myForm.$setPristine();
		}

		function edit(id) {
			console.log('Id to be edited: ', id);
			for(var i=0; i<vm.users.length; i++){
				if(id===vm.users[i].id){
					vm.user = angular.copy(vm.users[i]);
					break;
				}
			}
		}
		
	}
	
})();