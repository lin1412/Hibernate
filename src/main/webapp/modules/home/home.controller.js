(function() {
    'use strict';

    angular.module('flash.home').controller('HomeController', HomeController);

    function HomeController($http) {
        var hc = this;
        hc.helloWorld = 'Hello, world!';
    }

    HomeController.$inject = ['$http'];
})();
