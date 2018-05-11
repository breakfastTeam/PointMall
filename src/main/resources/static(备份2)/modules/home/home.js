(function () {

	'use strict';

	angular
		.module('app')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];

	function config($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('index', {
				needAuth: false,
				url: '?token',
				title: "轻松兑",
				templateUrl: 'modules/home/h5.html'
			});


		$stateProvider
			.state('home', {
				needAuth: false,
				url: '/home',
				title: "轻松兑",
				templateUrl: 'modules/home/h5.html',
			});

	};



})();