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

    $scope.loadSchedule = function () {
        $http({
            url: contextPath + '/schedule',
            method: 'GET'
        }).then(function (response) {
            let scheduleDtoList = response.data;
            // for (const scheduleDtoListElement of scheduleDtoList) {
            //     let time = scheduleDtoListElement.time;
                // if (!$scope.timeGrid.includes(time)){
                //     $scope.timeGrid.push(time);
                // }
                // $scope.timeGrid.sort();
            // }
            $scope.scheduleDtoList = scheduleDtoList;;
        });
    };


    const filters = {};

    $('.button-group').each(function (i, buttonGroup){
        const $buttonGroup = $(buttonGroup);
        $buttonGroup.on('click', 'div', function (event) {
            $buttonGroup.find('.active').removeClass('active');
            const $button = $(event.currentTarget);
            console.log($button.hasClass('all'));
            if ($button.hasClass('all')){
                $buttonGroup.find('.item_filter_btn').addClass('active');
            } else {
                $button.addClass('active');
            }
        });
    });

    $('.timetable_filtering').on('click', '.item_filter_btn', function (event){
        const $button = $(event.currentTarget);
        const $buttonGroup = $button.parents('.button-group');
        const filterGroup = $buttonGroup.attr('data-filter-group');
        filters[filterGroup] = $button.attr('data-filter');
        const filterValue = $scope.concatValues(filters);
        $scope.setFilter({filter: filterValue});
    });

    $scope.setFilter = function (filter){
        const $grid = $('.grid');
        let allGrids = $grid.find('.class_grid');
        allGrids.removeClass('hidden');
        let otherGrids = allGrids.not(filter.filter);
        if (otherGrids.length !== allGrids.length) {
            otherGrids.addClass('hidden');
        }
    };

    $scope.concatValues = function (obj){
        let value = '';
        for (const prop in obj ) {
            value += obj[ prop ];
        }
        return value;
    };

    $scope.loadSchedule();
});