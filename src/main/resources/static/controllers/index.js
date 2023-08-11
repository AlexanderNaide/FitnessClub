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
            .when('/info', {
                templateUrl: 'pages/user_info.html',
                controller: 'userInfoController'
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
                    $location.path('/home')
                } else {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.fitnessClubUser.token;
                    // console.log('Role: ' + payload.authority);
                    if (payload.authority == "admin"){
                        // console.log("It's admin");
                        $location.path('/admin');
                    }
                }
            } catch (e) {
            }
        } else {
            $location.path('/home');
        }
    }
})();

angular.module('fitnessClub').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {
    const contextPathAuth = 'http://localhost:5555/three-oceans.fitness/api/v1/auth-service';

    $scope.authentications = function () {
        $http.post(contextPathAuth + '/auth', $scope.auth)
            .then(function (response) {
                if(response.data.token){
                    // console.log("Токен получен");
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    let jwt = response.data.token;
                    let payload = JSON.parse(atob(jwt.split('.')[1]));
                    $localStorage.fitnessClubUser = {username: $scope.auth.username, token: response.data.token, role:payload.authority};
                    // console.log('Role: ' + payload.authority);
                    if (payload.authority == "admin"){
                        // console.log("It's admin");
                        $location.path('/admin');
                    } else {
                        $location.path('/');
                    }
                }
            }).catch(function (response) {
            // console.log(response.data.message)
            $scope.modalStatus = response.data.message;
        });
    };



    $scope.registrations = function () {
        $http.post(contextPathAuth + '/reg', $scope.reg)
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

    $scope.getAuthWindow = function () {
        $('#modalAuth').modal('toggle');
    };

    $scope.getRegistrations = function () {
        $('.authorizationWindow').addClass('hidden');
        $('.registrationWindow').removeClass('hidden');
    };

    $scope.getAuthorizations = function () {
        $('.registrationWindow').addClass('hidden');
        $('.authorizationWindow').removeClass('hidden');
    };

    $scope.phoneMatching = function (){
        // const re = /^[\d\+][\d\(\)\ -]{7,14}\d$/;
        const re = /^[\+]?[0-9]{1,3}[ ]?[( -]?[0-9]{3}[) -]?[ ]?[ -]?[0-9]{3}[ -]?[0-9]{2}[ -]?[0-9]{2}$/im;
        let valid = re.test($scope.reg.phone);
        if (valid) {
            $('#phone').removeClass('border-danger').addClass('border-success');
        } else {
            $('#phone').removeClass('border-success').addClass('border-danger');
        }
    };

    $scope.emailMatching = function (){
        const re = /^[\w-\.]+@[\w-]+\.[a-z]{2,4}$/i;
        let valid = re.test($scope.reg.email);
        if (valid) {
            $('#email').removeClass('border-danger').addClass('border-success');
        } else {
            $('#email').removeClass('border-success').addClass('border-danger');
        }
    };

    $scope.passwordMatching = function (){
        let password1 = $scope.reg.password;
        let password2 = $scope.reg.confirmPassword;
        if (password1 === undefined || password1 === ''){
            $('#regPassword').removeClass('border-success').addClass('border-danger');
        } else {
            $('#regPassword').removeClass('border-danger');
        }
        if (password2 === undefined || password2 === ''){
            $('#confirmPassword').removeClass('border-success').addClass('border-danger');
        } else {
            $('#confirmPassword').removeClass('border-danger');
        }
        if (password1 !== password2){
            $('#regPassword').removeClass('border-success');
            $('#confirmPassword').addClass('border-danger');
        }
        if (password1 === password2){
            $('#regPassword').removeClass('border-danger').addClass('border-success');
            $('#confirmPassword').removeClass('border-danger').addClass('border-success');
            $scope.reg.password = password1;
        }
    };

    $scope.clearUser = function (){
        delete $localStorage.fitnessClubUser;
        $http.defaults.headers.common.Authorization = '';
        $location.path('/')
    }

    $scope.closeModal = function (modal){
        $(modal).modal('hide');
    }

    $scope.ifUserLoggedIn = function (){
        return !!$localStorage.fitnessClubUser && $localStorage.fitnessClubUser.role != "admin";
    }
    $scope.ifAdminLoggedIn = function (){
        return !!$localStorage.fitnessClubUser && $localStorage.fitnessClubUser.role == "admin";
    }

});

