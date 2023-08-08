angular.module('fitnessClub').controller('scheduleController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/three-oceans.fitness/api/v1/user-service';
    const contextSchedulePath = 'http://localhost:8081/schedule-service/api/v1/events';

    $scope.loadSchedule = function () {
        $http({
            url: contextSchedulePath + '/general',
            method: 'GET'
        }).then(function (response) {
            console.log(response.data);
            $scope.scheduleDto = response.data;
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