describe('flash.home.HomeController', function() {
    'use strict';

    var controller;
    var $controller;
    var $http;

    beforeEach(function() {
        module('flash.home');
        inject(function($controller) {
            controller = $controller("HomeController", { $http: $http });
        });
    });

    describe('hello world', function() {
        it('should be hello world', function() {
            expect(controller.helloWorld).toBe("Hello, world!");
        });
    });
});
