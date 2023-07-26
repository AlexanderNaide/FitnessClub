angular.module('fitnessClub').controller('servicesController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/three-oceans.fitness/api/v1/user-service';

    // $scope.loadInformation = function () {
    //     $http({
    //         url: contextPath + '/info',
    //         method: 'GET'
    //     }).then(function (response) {
    //         console.log(response.data);
    //         $scope.UserInformation = response.data;
    //     });
    // };


    $scope.loadSubscriptions = function () {
        $http({
            url: contextPath + '/subscriptions',
            method: 'GET'
        }).then(function (response) {
            console.log(response.data)
            $scope.subscriptionDtoList = response.data;
        });
    };


    $scope.getTicketById = function (id){
        $http({
            url: contextPath + "/subscriptions/" + id,
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.currentSubscription = response.data;
        }).catch(function (response) {
            alert(response.data.message)
        });
    };

    // $scope.loadInformation();
    $scope.loadSubscriptions();
});