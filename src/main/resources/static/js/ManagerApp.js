var ManagerModule = angular.module('ManagerApp', ['ngCookies']);

ManagerModule.controller('ManagerController', function($scope, $http, $location, $window,  $rootScope, $cookieStore){
	var urlBase="http://localhost:8080";
	$scope.connexionEchec=false;
	$scope.profileUser;

	$scope.connexion = function(){
		if($scope.login=="" || $scope.pass=="" || $scope.login==null || $scope.pass==null){
			$scope.connexionEchec=true;
			alert("passe pas");
		}else{
			$http.get(urlBase+'/user/connexion/'+$scope.login+'/'+$scope.pass).
			success(function(data) {
				if(data == null){
					$scope.connexionEchec=true;	
					alert("passe pas 1");
				}else{
					$scope.profileUser=data;
					$cookieStore.put('token', $scope.profileUser.token);
					window.location=urlBase+"/home";
					alert("passe pas 2");
				}
			});

		}
	};

	$scope.addTask = function() {
		if($scope.taskName=="" || $scope.taskDesc=="" || $scope.taskPriority == "" || $scope.taskStatus == ""){
			alert("Insufficient Data! Please provide values for task name, description, priortiy and status");
		}
		else{
			$http.post(urlBase + '/tasks/insert/' +$scope.taskName+'/'+$scope.taskDesc+'/'+$scope.taskPriority+'/'+$scope.taskStatus).
			success(function(data) {
				alert("Task added");
				$scope.tasks = data;
				$scope.taskName="";
				$scope.taskDesc="";
				$scope.taskPriority="";
				$scope.taskStatus="";
				$scope.toggle='!toggle';   
			});
		}
	}

});

ManagerModule.controller('HomeController', function($scope, $http, $location, $window, $cookieStore){
	var urlBase="http://localhost:8080";
	$scope.token=$cookieStore.get('token');
	$scope.profileUser;
	

	$scope.initialise = function(){
		if($scope.token==null){
			window.location=urlBase+"/login";
		}else{
			$http.get(urlBase+'/user/token/'+$scope.token).
			success(function(data) {
				$scope.profileUser=data;
				if(data == null){
					$scope.connexionEchec=true;	
					window.location=urlBase+"/login";
				}else{
					alert($scope.profileUser.nom);
				}
			});
		}

		
	};

	$scope.initialise();

	
});




