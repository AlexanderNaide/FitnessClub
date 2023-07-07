angular.module('fitnessClub').controller('authController', function ($scope, $http, $location, $localStorage) {
    const contextPathAuth = 'http://localhost:8081/three-oceans.fitness/api/v1';

    $scope.authentications = function () {
        $http.post(contextPathAuth + '/auth', $scope.auth)
            .then(function (response) {
                if(response.data.token){
                    console.log("Токен получен");
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.fitnessClubUser = {username: $scope.auth.username, token: response.data.token};

                    $location.path('/');
                }
            }).catch(function (response) {
            // console.log(response.data.message)
            $scope.modalStatus = response.data.message;
        });
    };

    $scope.registrations = function () {
        $http.post(contextPathAuth + '/reg', $scope.auth)
            .then(function (response) {
                if(response.data.token){
                    console.log("Токен получен")
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.fitnessClubUser = {username: $scope.auth.keypass, token: response.data.token};

                    $location.path('/');
                }
            }).catch(function (response) {
            // console.log(response.data.message)
            $scope.modalStatus = response.data.message;
        });
    };
});