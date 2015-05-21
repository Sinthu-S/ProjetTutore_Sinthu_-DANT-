var ManagerModule = angular.module('ManagerApp', []);

ManagerModule.controller('ManagerController', function($scope, $http){
	var urlBase="http://localhost:8080/TaskManagerApp";

	$scope.connexion = function connexion(){
		if($scope.login=="t" || $scope.pass=="t"){
			$scope.connexionEchec="true"
			
		}else{

		}
	};

	$scope.addTask = function addTask() {
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
	};

});




