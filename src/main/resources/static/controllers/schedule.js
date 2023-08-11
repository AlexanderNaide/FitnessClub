angular.module('fitnessClub').controller('scheduleController', function ($scope, $http) {
    const contextSchedulePath = 'http://localhost:5555/schedule/api/v1/events';
    const contextPathSubscriptionService = 'http://localhost:5555/accounts/api/v1/clients/subscriptions';

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
            url: contextPathSubscriptionService + '/info',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)

            // Запрашивается список абонементов и пересыпается в список строк
            $scope.userSubscriptionList = [];
            for (const dto of response.data) {
                $scope.userSubscriptionList.push(dto.disciplineName);
            }
        });
    };

    $scope.loadUserEvents = function () {
        $http({
            url: contextSchedulePath + '/personal',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)

            // Лист Id с номерами событий
            $scope.userEventList = response.data;
        });
    };

    $scope.getEventInformation = function (id) {
        $http({
            url: contextSchedulePath + "/" + id + "/info",
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.CurrentEvent = response.data;
            if(!$scope.userSubscriptionList.includes($scope.CurrentEvent.discipline.name)){
                $('.non_sub').removeClass('hidden');
                $('.there_event').addClass('hidden');
                $('.non_event').addClass('hidden');
            } else if ($scope.isSubscribe($scope.CurrentEvent.id)){
                $('.there_event').removeClass('hidden');
                $('.non_sub').addClass('hidden');
                $('.non_event').addClass('hidden');
            } else {
                $('.non_event').removeClass('hidden');
                $('.non_sub').addClass('hidden');
                $('.there_event').addClass('hidden');
            }
            $('#modalClassInfo').modal('toggle');
        }).catch(function (response) {
            alert(response.data.message);
        });
    };

    $scope.closeModal = function (modal){
        $(modal).modal('hide');
    };

    $scope.isSubscribe = function (id){
        return $scope.userEventList.includes(id);
    };

    $scope.isMainClass = function (id){
        return $scope.isSubscribe(id) ? "main" : null;
    };

    $scope.addEvent = function (id, discipline){
        if(!$scope.userSubscriptionList.includes(discipline)){
            alert('Для записи на это занятие вначале необходимо приобрести абонемент.');
        } else {
            $http({
                url: contextSchedulePath + "/subscribe/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserEvents();
            });
        }
    };

    $scope.addEventOnModalInfo = function (id, discipline, modal){
        if(!$scope.userSubscriptionList.includes(discipline)){
            alert('Для записи на это занятие вначале необходимо приобрести абонемент.');
        } else {
            $http({
                url: contextSchedulePath + "/subscribe/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserEvents();
                $scope.closeModal(modal);
            });
        }
    };

    $scope.deleteEvent = function (id){
        $http({
            url: contextSchedulePath + "/unsubscribe/" + id,
            method: 'POST'
        }).then(function () {
            $scope.loadUserEvents();
        });
    };

    $scope.deleteEventOnModalInfo = function (id, modal){
        $http({
            url: contextSchedulePath + "/unsubscribe/" + id,
            method: 'POST'
        }).then(function () {
            $scope.loadUserEvents();
            $scope.closeModal(modal);
        });
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

    $scope.loadUserEvents();
    $scope.loadUserSubscriptions();
    $scope.loadSchedule();
});