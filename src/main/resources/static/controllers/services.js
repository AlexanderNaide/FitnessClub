angular.module('fitnessClub').controller('servicesController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/three-oceans.fitness/api/v1';


    $scope.loadTickets = function () {
        $http({
            url: contextPath + '/tickets',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)
            $scope.TicketList = response.data;
        });
    };


    $scope.getTicketById = function (id){
        $http({
            url: contextPath + "/ticket/" + id,
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.currentTicket = response.data;
        }).catch(function (response) {
            alert(response.data.message)
        });
    };

    $scope.loadTickets();
});