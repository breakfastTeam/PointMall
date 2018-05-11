(function () {

	'use strict';

	angular
		.module('app')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];

	function config($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('profile', {
				// needAuth: true,
				needAuth:false,
				url: '/profile',
				title: "个人中心",
				templateUrl: 'modules/profile/profile.html',
			});

	}

})();