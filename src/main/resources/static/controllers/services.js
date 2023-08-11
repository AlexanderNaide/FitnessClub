angular.module('fitnessClub').controller('servicesController', function ($scope, $http) {
    const contextPathSubscriptionService = 'http://localhost:5555/accounts/api/v1/clients/subscriptions';

    $scope.loadUserSubscriptions = function () {
        $http({
            url: contextPathSubscriptionService + '/info',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)
            $scope.subscriptionDtoList = response.data;
        });
    };

    $scope.getAllSubscriptions = function () {
        $http({
            url: contextPathSubscriptionService + '/get-all',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)
            $scope.addSubscriptionList = response.data;
        });
    };

    $scope.buySubscription = function (id){
        $http({
            url: contextPathSubscriptionService + "/buy/" + id,
            method: 'POST'
        }).then(function () {
            $scope.loadUserSubscriptions();
        });
    };

    // Запрос на удаление абонемента - пока не нужен
/*    $scope.deleteSubscription = function (id){
        $http({
            url: contextPathSubscriptionService + "/unsubscribe/" + id,
            method: 'POST'
        }).then(function () {
            $scope.loadUserSubscriptions();
        });
    };*/


    // Запрос подробной информации об абонементе.
/*    $scope.getTicketById = function (id){
        $http({
            url: contextPathSubscriptionService + "/" + id,
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.currentSubscription = response.data;
        }).catch(function (response) {
            alert(response.data.message);
        });
    };*/

    $scope.isAdded = function (id){
        let added = false;
        for (const sub of $scope.subscriptionDtoList) {
            if (sub.id === id){
                added = true;
                break;
            }
        }
        return added;
    };

    $scope.loadUserSubscriptions();
});