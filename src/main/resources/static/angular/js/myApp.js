var app = angular.module("myBanqueApp", []);
app
		.controller(
				"myBanqueController",
				function($scope, $http) {
					$scope.compte = null;
					$scope.numCompte = null;
					$scope.pageOperations = [];
					$scope.pageCourante = 0;
					$scope.pageSize = 3;
					$scope.pages = [];
					$scope.errorMessage=null;
				

					$scope.operation = {
						type : "versement",
						montant : 0,
						cpte2:null
					}// par defaut radio versement checked

					$scope.chargerCompte = function() {
						$scope.pageCourante = 0;// par defaut lorsque il charge
						// un compte
						// pointer sur la 1er page au grid
						$http.get("/comptes/" + $scope.numCompte)

						.success(function(data) {

							$scope.compte = data;
							$scope.chargerOperations();
						})
						.error(function(data) {
								     $scope.errorMessage=data.message;
								     $scope.compte=null;
								    // $scope.loaoperations();
							       })
						;

					};

					$scope.chargerOperations = function() {
						$http.get(
								"/operations?numCompte=" + $scope.numCompte
										+ "&page=" + $scope.pageCourante
										+ "&size=" + $scope.pageSize)

						.success(function(data) {

							$scope.pageOperations = data;
							$scope.pages = new Array(data.totalPages);
							$scope.errorMessage=null;
						});
					};

					$scope.goToPage = function(p) {
						$scope.pageCourante = p;
						$scope.chargerOperations();
					};

					$scope.saveOperation = function() {
						
						var params="";
						
						if ($scope.operation.type == 'virement') {
							params= "cpte1=" + $scope.numCompte+ "&cpte2=" + $scope.operation.cpte2+ "&montant="+ $scope.operation.montant+ "&codeEmp=1";
						}else{
							params="code=" + $scope.numCompte+ "&montant="+ $scope.operation.montant+ "&codeEmp=1";
						}

							$http(
									{
										method : 'PUT',
										url : $scope.operation.type,
										data :params,
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									})
									.success(function(data) {
								     $scope.chargerCompte();
								    // $scope.loaoperations();
							       })
							       .error(function(data) {
								     $scope.errorMessage=data.message;
								    
								    // $scope.loaoperations();
							       });


					};
				});
