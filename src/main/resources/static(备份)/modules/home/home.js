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
				url: '/index',
				title: "神州数码积分商城",
				templateUrl: 'modules/home/home.html'
			});


		$stateProvider
			.state('home', {
				needAuth: false,
				url: '/home',
				title: "神州数码积分商城",
				templateUrl: 'modules/home/home.html',
			});

	};



})();