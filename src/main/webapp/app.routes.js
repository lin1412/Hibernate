(function() {
    'use strict';

    angular.module('flashApp')
        .config(['$stateProvider', '$urlRouterProvider',
                 function($stateProvider, $urlRouterProvider) {
                     $urlRouterProvider.otherwise('/home');

                     $stateProvider
                         .state('home', {
                             url: '/home',
                             templateUrl: 'modules/home/home.html',
                             controller: 'HomeController as hc'
                         })
                         .state('users', {
                             url: '/users',
                             templateUrl: 'users.jsp'
                         });
                 }
                ]);
})();
