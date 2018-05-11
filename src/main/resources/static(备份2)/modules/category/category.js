(function () {

	'use strict';

	angular
		.module('app')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];

	function config($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('category', {
				needAuth: false,
				url: '/category',
				title: "商品分类",
				templateUrl: 'http://www.fd30.cn/demo7/h5_catalog.php',
			});

	}

})();