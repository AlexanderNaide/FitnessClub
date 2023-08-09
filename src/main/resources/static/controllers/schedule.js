angular.module('fitnessClub').controller('scheduleController', function ($scope, $http) {
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
            url: contextSchedulePath + '/subscription',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)

            // Лист Строк названий дисциплин
            $scope.userSubscriptionList = response.data;
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
        // let added = false;

        // for (const sub of $scope.subscriptionDtoList) {
        //     if (sub.disciplineName === discipline){
        //         added = true;
        //         break;
        //     }
        // }
        // return added ? "main" : null;
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

    $scope.deleteEvent = function (id){
        $http({
            url: contextSchedulePath + "/unsubscribe/" + id,
            method: 'POST'
        }).then(function () {
            $scope.loadUserEvents();
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