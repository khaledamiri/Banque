var app = angular.module("myBanqueApp", []);
app.controller("myBanqueController", function($scope, $http) {
	$scope.compte = null;
	$scope.numCompte = null;
	$scope.pageOperations=[];
	$scope.operation = {
		type : "versement",
		montant : 0
	}// par defaut radio versement checked
	$scope.chargerCompte = function() {

		$http.get("/comptes/" + $scope.numCompte)

		.success(function(data) {
			
			$scope.compte = data;
			$scope.chargerOperations();
		});

	};
	
	$scope.chargerOperations=function(){
		$http.get("/operations?numCompte=" + $scope.numCompte+"&page=0"+"&size=7")

		.success(function(data) {
			
			$scope.pageOperations = data;
		});
	};
	
	$scope.saveOperation = function() {
		$http({
					method : 'PUT',
					url : $scope.operation.type,
					data : "code=" + $scope.numCompte + "&montant="
							+ $scope.operation.montant+"&codeEmp=1",
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				})
				.success(function(data) {
				$scope.chargerCompte();
			//$scope.loaoperations();
		});
	};
});
