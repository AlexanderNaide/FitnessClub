angular.module('fitnessClub').controller('scheduleController', function ($scope, $http) {
    const contextPathSubscriptionService = 'http://localhost:8081/subscriptions-service/api/v1/subscriptions';
    const contextSchedulePath = 'http://localhost:8081/schedule-service/api/v1/events';

    $scope.loadSchedule = function () {
        $http({
            url: contextSchedulePath + '/general',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.scheduleDto = response.data;
        });
    };

    $scope.loadUserSubscriptions = function () {
        $http({
            url: contextPathSubscriptionService,
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)
            $scope.subscriptionDtoList = response.data;
        });
    };

    $scope.isMainClass = function (discipline){
        let added = false;
        for (const sub of $scope.subscriptionDtoList) {
            if (sub.disciplineName === discipline){
                added = true;
                break;
            }
        }
        return added ? "main" : null;
    };

    const filters = {};

    $('.button-group').each(function (i, buttonGroup){
        const $buttonGroup = $(buttonGroup);
        $buttonGroup.on('click', 'div', function (event) {
            $buttonGroup.find('.active').removeClass('active');
            const $button = $(event.currentTarget);
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
        if (filter.filter !== ''){
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

    $scope.loadUserSubscriptions();
    $scope.loadSchedule();
});