angular.module('fitnessClub').controller('scheduleController', function ($scope, $http, $localStorage) {
    const contextPathScheduleService = 'http://localhost:5555/schedule/api/v1/events';
    const contextPathAccountService = 'http://localhost:5555/accounts/api/v1/clients';
    $scope.userSubscriptionList = [];
    $scope.userEventList = [];


    $scope.setActiveLinc = function (){
        const $buttonGroup = $('.nav-item');
        $buttonGroup.find('.active').removeClass('active');
        const $button = $('.schedule-linc');
        $button.addClass('active');
    };

    $scope.loadSchedule = function () {
        $http({
            url: contextPathScheduleService + '/general',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.scheduleDto = response.data;
        });
    };

    $scope.loadUserSubscriptions = function () {
        $http({
            url: contextPathAccountService + '/subscriptions/info',
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data)

            // Запрашивается список абонементов и пересыпается в список строк
            // $scope.userSubscriptionList = [];
            for (const dto of response.data) {
                $scope.userSubscriptionList.push(dto.discipline);
            }
        });
    };

    $scope.loadUserEvents = function () {
        if ($scope.ifUserAvailable()){
            $http({
                url: contextPathScheduleService + '/personal',
                method: 'GET'
            }).then(function (response) {
                // console.log(response.data)

                // Лист Id с номерами событий
                $scope.userEventList = response.data;
                $scope.reloadFilter();
            });
        }
    };

    $scope.getEventInformation = function (id) {
        $http({
            url: contextPathScheduleService + "/" + id + "/info",
            method: 'GET'
        }).then(function (response) {
            // console.log(response.data);
            $scope.CurrentEvent = response.data;
            if(!$scope.ifUserAvailable()){
                $('.non_user').removeClass('hidden');
                $('.non_sub').addClass('hidden');
                $('.non_event').addClass('hidden');
                $('.there_event').addClass('hidden');
            } else if (!$scope.userSubscriptionList.includes($scope.CurrentEvent.discipline.name)){
                $('.non_user').addClass('hidden');
                $('.non_sub').removeClass('hidden');
                $('.non_event').addClass('hidden');
                $('.there_event').addClass('hidden');
            } else if (!$scope.isSubscribe($scope.CurrentEvent.id)){
                $('.non_user').addClass('hidden');
                $('.non_sub').addClass('hidden');
                $('.non_event').removeClass('hidden');
                $('.there_event').addClass('hidden');
            } else {
                $('.non_user').addClass('hidden');
                $('.non_sub').addClass('hidden');
                $('.non_event').addClass('hidden');
                $('.there_event').removeClass('hidden');
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

    $scope.ifUserAvailable = function (){
        return !!$localStorage.fitnessClubUser;
    };

    $scope.redirectAuthWindow = function (){
        $scope.closeModal($('#modalClassInfo'));
        $('#modalAuth').modal('toggle');
    }

    $scope.addEvent = function (id, discipline){
        if (!$scope.ifUserAvailable()){
            alert('Запись на занятия доступна только для зарегистрированных пользователей.');
        } else if(!$scope.userSubscriptionList.includes(discipline)){
            alert('Для записи на это занятие вначале необходимо приобрести абонемент.');
        } else {
            $http({
                url: contextPathScheduleService + "/subscribe/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserEvents();
            }).catch(function (response) {
                alert(response.data.message)
            });
        }
    };

    $scope.addEventOnModalInfo = function (id, discipline, modal){
        if (!$scope.ifUserAvailable()){
            alert('Запись на занятия доступна только для зарегистрированных пользователей.');
        } else if(!$scope.userSubscriptionList.includes(discipline)){
            alert('Для записи на это занятие вначале необходимо приобрести абонемент.');
        } else {
            $http({
                url: contextPathScheduleService + "/subscribe/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserEvents();
                $scope.closeModal(modal);
            });
        }
    };

    $scope.deleteEvent = function (id){
        if($scope.ifUserAvailable()){
            $http({
                url: contextPathScheduleService + "/unsubscribe/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserEvents();
            });
        }
    };

    $scope.deleteEventOnModalInfo = function (id, modal){
        if($scope.ifUserAvailable()){
            $http({
                url: contextPathScheduleService + "/unsubscribe/" + id,
                method: 'POST'
            }).then(function () {
                $scope.loadUserEvents();
                $scope.closeModal(modal);
            });
        }
    };
    const filters = {};

    $scope.reloadFilter = function (){
        const interval = setInterval(function () {
            clearInterval(interval);
            const filterValue = $scope.concatValues(filters);
            $scope.setFilter({filter: filterValue});
        }, 10);
    }

    $('.button-group').each(function (i, buttonGroup){
        const $buttonGroup = $(buttonGroup);
        $buttonGroup.on('click', 'div', function (event) {
            $buttonGroup.find('.active').removeClass('active');
            const $button = $(event.currentTarget);
            if (!$button.hasClass('all')){
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


    $scope.setActiveLinc();
    if($scope.ifUserAvailable()){
        $scope.loadUserEvents();
        $scope.loadUserSubscriptions();
    }
    $scope.loadSchedule();
});