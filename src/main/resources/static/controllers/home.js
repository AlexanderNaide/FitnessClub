angular.module('fitnessClub').controller('homeController', function ($scope, $http, $localStorage) {
    const contextPathSubscriptionService = 'http://localhost:5555/subscriptions/api/v1/subscriptions';
    const contextPathAccountService = 'http://localhost:5555/accounts/api/v1/clients';

    $scope.setActiveLinc = function (){
        const $buttonGroup = $('.nav-item');
        $buttonGroup.find('.active').removeClass('active');
        const $button = $('.home-linc');
        $button.addClass('active');
    };

    $scope.getAllSubscriptions = function () {
        $http({
            url: contextPathSubscriptionService + '/get-all',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)
            $scope.allSubscriptionList = response.data;
        });
    };

    $scope.getSubInfo = function (id) {
        $http({
            url: contextPathSubscriptionService + "/" + id + "/info",
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.CurrentSub = response.data;
            $('#subscriptionInformationForm').modal('toggle');
        }).catch(function (response) {
            alert(response.data.message);
        });
    };

    $scope.buySubscription = function (id){
        if ($scope.ifUserAvailable()){
            $http({
                url: contextPathSubscriptionService + "/buy/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserSubscriptions();
            }).catch(function (response) {
                alert(response.data.message)
            });
        } else {
            $scope.closeModal($('#subscriptionInformationForm'));
            $('#alertNotAuthentication').modal('toggle');
        }
    };

    $scope.redirectAuthWindow = function (){
        $scope.closeModal($('#alertNotAuthentication'));
        $('#modalAuth').modal('toggle');
    }

    $scope.closeModal = function (modal){
        $(modal).modal('hide');
    };

    $scope.ifUserAvailable = function (){
        return !!$localStorage.fitnessClubUser;
    };

    $scope.loadUserSubscriptions = function () {
        $http({
            url: contextPathAccountService + '/subscriptions/info',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.userSubscriptionList = response.data;
        });
    };

/*    $scope.ifSubAvailable = function (id) {
        // console.log("запрос");
        if ($scope.ifUserAvailable()) {
            let result = false;
            if ($scope.userSubscriptionList !== undefined && $scope.userSubscriptionList.length > 0) {
                for (let sub of $scope.userSubscriptionList) {
                    if (sub.id === id) {
                        result = true;
                        break;
                    }
                }
            }
            return result ? "hidden" : "";
        } else {
            return "";
        }
    };*/

    $scope.ifSubAvailableNative = function (id) {
        if ($scope.ifUserAvailable()) {
            if ($scope.userSubscriptionList !== undefined && $scope.userSubscriptionList.length > 0) {
                for (let sub of $scope.userSubscriptionList) {
                    if (sub.id === id) {
                        return true;
                    }
                }
            }
        } else {
            return false;
        }
    };

    $scope.loadUserSubscriptions();
    $scope.getAllSubscriptions();
    $scope.setActiveLinc();

});