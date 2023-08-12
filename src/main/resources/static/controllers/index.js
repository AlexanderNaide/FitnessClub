(function () {
    angular
        .module('fitnessClub', ['ngRoute', 'ngStorage'])
        .config(config)
        // .configuration(config)
        .run(run);


    function config($routeProvider){
        $routeProvider
            .when('/admin', {
                templateUrl: 'pages/schedule.html',
                controller: 'scheduleController'
            })
            .when('/schedule', {
                templateUrl: 'pages/schedule.html',
                controller: 'scheduleController'
            })
            .when('/services', {
                templateUrl: 'pages/services.html',
                controller: 'servicesController'
            })
            .when('/auth', {
                templateUrl: 'pages/auth.html',
                controller: 'authController'
            })
            .when('/', {
                templateUrl: 'pages/home.html',
                controller: 'homeController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage, $location) {
        if ($localStorage.fitnessClubUser) {
            try {
                let jwt = $localStorage.fitnessClubUser.token;
                let payload = JSON.parse(atob(jwt.split('.')[1]));
                let currentTime = parseInt(new Date().getTime() / 1000);
                if (currentTime > payload.exp) {
                    console.log("Время жизни токена истекло");
                    delete $localStorage.fitnessClubUser;
                    $http.defaults.headers.common.Authorization = '';
                    $location.path('/')
                } else {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.fitnessClubUser.token;
                    // console.log('Role: ' + payload.authority);
                    if (String(payload.authority) === String("admin")){
                        // console.log("It's admin");
                        $location.path('/admin');
                    }
                }
            } catch (e) {
            }
        } else {
            $location.path('/auth');
        }
    }
})();

angular.module('fitnessClub').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {

    $scope.clearUser = function (){
        delete $localStorage.fitnessClubUser;
        $http.defaults.headers.common.Authorization = '';
        // $location.path('/auth')
    }

    $scope.ifUserLoggedIn = function (){
        return !!$localStorage.fitnessClubUser && String($localStorage.fitnessClubUser.role) !== String("admin");
    }
    $scope.ifAdminLoggedIn = function (){
        return !!$localStorage.fitnessClubUser && String($localStorage.fitnessClubUser.role) === String("admin");
    }

});

