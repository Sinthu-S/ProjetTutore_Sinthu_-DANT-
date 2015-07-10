var ManagerModule = angular.module('ManagerApp', ['ngCookies']);

ManagerModule.controller('ManagerController', function($scope, $http, $location, $window,  $rootScope, $cookieStore){
	var urlBase="http://localhost:8080";
	$scope.connexionEchec=false;
	$scope.profileUser;

	$scope.connexion = function(){
		if($scope.login=="" || $scope.pass=="" || $scope.login==undefined || $scope.pass==undefined){
			$scope.connexionEchec=true;
			alert("passe pas");
		}else{
			$http.get(urlBase+'/user/connexion/'+$scope.login+'/'+$scope.pass+"/").
			success(function(data) {
				if(data == undefined){
					$scope.connexionEchec=true;	
					alert("passe pas 1");
				}else{
					$scope.profileUser=data;
					$cookieStore.put('token2', $scope.profileUser.token);
					alert($scope.profileUser.typeUser);
					switch($scope.profileUser.typeUser) {
						case "admin":
						window.location=urlBase+"/homeAdmin";
						break;
						case "manager":
						window.location=urlBase+"/homeChefDeProjet";
						break;
						case "developpeur":
						window.location=urlBase+"/homeDeveloppeur";
						break;
						case "client":
						window.location=urlBase+"/homeClient";
						break;
					}
					
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
	};

	$scope.dejaConnecte = function(){
		$scope.token=$cookieStore.get('token2');
		if($scope.token!=undefined){
			$http.get(urlBase+'/user/token/'+ $cookieStore.get('token2')+"/").
			success(function(data) {
				if(data != null){
					$scope.profileUser=data;
					switch($scope.profileUser.typeUser) {
						case "admin":
						window.location=urlBase+"/homeAdmin";
						break;
						case "chefdeprojet":
						window.location=urlBase+"/homeChefDeProjet";
						break;
						case "developpeur":
						window.location=urlBase+"/homeDeveloppeur";
						break;
						case "client":
						window.location=urlBase+"/homeClient";
						break;
					}
					
				}
			});
		}
	}

	$scope.dejaConnecte();

});



ManagerModule.controller('HomeController', function($scope, $http, $location, $window, $cookieStore){
	var urlBase="http://localhost:8080";
	$scope.token=$cookieStore.get('token2');
	$scope.profileUser;



	$scope.initialise = function(){
		alert("initialise");
		if($scope.token==undefined){
			window.location=urlBase+"/login";
		}else{
			$http.get(urlBase+'/user/token/'+$scope.token+"/").
			success(function(data) {
				$scope.profileUser=data;
				if(data == undefined){
					window.location=urlBase+"/login";
				}
				if($scope.profileUser.typeUser=="admin"){
					$http.get(urlBase+'/user/stat').
					success(function(data) {
						alert(data);
						$scope.clients=data[0];
						$scope.managers=data[1];
						$scope.developpeurs=data[2];



					});
				};
			});
		};


	}


	$scope.onFileSelect = function() {
		
		var file = $scope.file;
		var test = {
			description:"Test",
			status: "REJECTED"
		};
		var fd = new FormData();
		fd.append('data', angular.toJson(test));
		fd.append("file", file);
		$http.get({
			url: '/user/data/fileupload',
			headers: {'Content-Type': undefined},
			data: fd,
			transformRequest: angular.identity
		})
		.success(function(data, status) {
			alert("success");
		});
		
	}

	$scope.inscription = function(typeUser){
		if($scope.nomUser==undefined || $scope.prenomUser==undefined || $scope.serviceUser==undefined || $scope.emailUser==undefined || $scope.loginUser==undefined || $scope.passUser==undefined){
			alert("Veuillez remplir tous les champs!");
		}else{
			$http.get(urlBase+"/user/inscription/"+$scope.nomUser+"/"+$scope.prenomUser+"/"+$scope.serviceUser+"/"+typeUser+"/"+$scope.emailUser+"/"+$scope.loginUser+"/"+$scope.passUser+"/");
			$scope.initialise();
		}
	}

	$scope.modification = function(login,nom,prenom,service,email){
		if(nom==undefined || prenom==undefined || service==undefined || email==undefined){
			alert(nom +"/"+prenom +"/"+ service +"/"+ email);
			alert("Veuillez remplir tous les champs!");
		}else{
			$http.get(urlBase+"/user/modification/"+nom+"/"+prenom+"/"+service+"/"+email+"/"+login+"/");
			window.location.reload();
		}
	}

	$scope.suppression = function(login){
		$http.get(urlBase+"/user/suppression/"+login+"/");
		window.location.reload();
	}




	$scope.deconnexion = function(){
		$http.get(urlBase+'/user/deconnexion/'+$scope.token);
		window.location=urlBase+"/login";
	}


	$scope.initialiseProjet = function(){
		$http.get(urlBase+"/projet/all/").
		success(function(data) {
			$scope.projets=data;
		});
	}

	$scope.ajoutProjet = function(){
		if($scope.nomProjet==undefined || $scope.projetClient==undefined || $scope.projetManager==undefined){
			alert("Veuillez remplir tous les champs!");	
		}else{
			$http.get(urlBase+"/projet/"+$scope.nomProjet+"/"+$scope.projetClient+"/"+$scope.projetManager+"/");
			window.location.reload();	
		}
	}

	$scope.majProjet = function(nomProjet, projetClient, projetManager){
		if(projetClient==undefined || projetManager==undefined){
			alert("Veuillez remplir tous les champs!");	
		}else{
			$http.get(urlBase+"/projet/"+nomProjet+"/"+projetClient+"/"+projetManager+"/");
			window.location.reload();	
		}
	}

	$scope.initialise();
	$scope.initialiseProjet();






});


ManagerModule.controller('homeManagerController', function($scope, $http, $location, $window, $cookieStore){
	var urlBase="http://localhost:8080";
	$scope.token=$cookieStore.get('token2');
	$scope.profileUser;
	$scope.demandeDev=[];

	$scope.initialiseProjet = function(){
		if($scope.token==undefined){
			window.location=urlBase+"/login";
		}else{
			$http.get(urlBase+'/user/token/'+$scope.token+"/").
			success(function(data) {
				$scope.profileUser=data;
				if(data == undefined){
					window.location=urlBase+"/login";
				}
				if($scope.profileUser.typeUser=="manager"){
					$http.get(urlBase+"/projet/all/manager/"+ $scope.profileUser.nom+" "+$scope.profileUser.prenom+"/").
					success(function(data) {
						$scope.projets=data;
					});

					$http.get(urlBase+'/user/stat').
					success(function(data) {
						$scope.developpeurs=data[2];



					});
				};

				if($scope.profileUser.typeUser=="client"){
					$http.get(urlBase+"/projet/all/client/"+ $scope.profileUser.nom+" "+$scope.profileUser.prenom+"/").
					success(function(data) {
						$scope.projets=data;
					});

				};

				if($scope.profileUser.typeUser=="developpeur"){
					
					$http.get(urlBase+"/projet/all/").

					success(function(data) {

						$scope.projets=data;
					});
				};
			});
		};


	};

	$scope.ajoutDemande = function(){
		$http.get(urlBase+"/projet/add/"+ $scope.projet+"/"+$scope.demandeTitre+"/"+$scope.demandeDescription+"/"+$scope.demandeService+"/"+$scope.demandeTechno+"/")
		window.location.reload();	
	}

	$scope.projetcourant = function(nom){
		for (var i = 0; i < $scope.projets.length; i++) {

			if ($scope.projets[i].nom==$scope.projet) {
				$scope.projetCourant=$scope.projets[i];
				break;
			}
		}
	};

	$scope.majProjet = function(indice, progression, commentaire, demandeDev){
		if(progression==undefined){
			progression=$scope.projetCourant.listIdTask[indice].etat;
		}
		if(demandeDev==undefined){
			demandeDev=$scope.projetCourant.listIdTask[indice].loginDeveloppeur;
		}
		if(commentaire==undefined){
			alert("Ajoutez un commentaire");
		}else{

			$http.get(urlBase+"/projet/maj/"+$scope.projetCourant.nom +"/"+indice +"/"+$scope.profileUser.nom+"/"+commentaire+"/"+progression+"/"+demandeDev+"/");

			window.location.reload();	
		}
	}

	$scope.majProjetDev = function(indice, progression, commentaire){
		if(progression==undefined){
			progression=$scope.projetCourant.listIdTask[indice].etat;
		}
		if(commentaire==undefined){
			alert("Ajoutez un commentaire");
		}else{

			$http.get(urlBase+"/projet/maj/"+$scope.projetCourant.nom +"/"+indice +"/"+$scope.profileUser.nom+"/"+commentaire+"/"+progression+"/");

			window.location.reload();	
		}
	}

	$scope.deconnexion = function(){
		$http.get(urlBase+'/user/deconnexion/'+$scope.token);
		window.location=urlBase+"/login";
	}





	$scope.initialiseProjet();


});







