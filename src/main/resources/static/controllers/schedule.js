angular.module('fitnessClub').controller('scheduleController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/three-oceans.fitness/api/v1/user-service';

    $scope.dayList = [
        'Понедельник',
        'Вторник',
        'Среда',
        'Четверг',
        'Пятница',
        'Суббота',
        'Воскресенье'
    ];

    $scope.timeGrid = [];

    $scope.loadSchedule = function () {
        $http({
            url: contextPath + '/schedule',
            method: 'GET'
        }).then(function (response) {
            let scheduleDtoList = response.data;
            for (const scheduleDtoListElement of scheduleDtoList) {
                let time = scheduleDtoListElement.time;
                if (!$scope.timeGrid.includes(time)){
                    $scope.timeGrid.push(time);
                }
            }
            $scope.scheduleDtoList = scheduleDtoList;
        });
    };

    $scope.loadSchedule();
});