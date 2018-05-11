(function () {

	'use strict';

	angular
		.module('app')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];

	function config($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('product', {
				needAuth: false,
				url: '/product/?goodsId',
				title: "商品详情",
				templateUrl: 'modules/product/product.html',
			});

	}

})();