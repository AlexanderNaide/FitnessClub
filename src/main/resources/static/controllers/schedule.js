angular.module('fitnessClub').controller('scheduleController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/three-oceans.fitness/api/v1/user-service';

    $scope.dayList = [
        // '   ',
        'Понедельник',
        'Вторник',
        'Среда',
        'Четверг',
        'Пятница',
        'Суббота',
        'Воскресенье'
    ];

    $scope.timeGrid = [
        '9:00',
        '10:00',
        '11:00',
        '12:00',
        '16:00',
        '17:00',
        '18:00',
        '19:00',
        '20:00',
        '21:00'
    ];

    // $scope.timeGrid = [
    //     {title: '', day: '   '},
    //     {title: '9:00', day: '   '},
    //     {title: '10:00', day: '   '},
    //     {title: '11:00', day: '   '},
    //     {title: '12:00', day: '   '},
    //     {title: '16:00', day: '   '},
    //     {title: '17:00', day: '   '},
    //     {title: '18:00', day: '   '},
    //     {title: '19:00', day: '   '},
    //     {title: '20:00', day: '   '},
    //     {title: '21:00', day: '   '}
    // ];

    $scope.loadSchedule = function () {
        $http({
            url: contextPath + '/schedule',
            method: 'GET'
        }).then(function (response) {
            // $scope.scheduleDtoList = $scope.timeGrid.concat(response.data);
            $scope.scheduleDtoList = response.data;
            // console.log($scope.scheduleDtoList);
        });
    };

    // $scope.loadInformation();
    $scope.loadSchedule();
});