(function () {

	'use strict';

	angular
		.module('app')
		.factory('CartModel', CartModel);

	CartModel.$inject = ['$http', '$q', '$timeout', '$rootScope', 'CacheFactory', 'AppAuthenticationService', 'API', 'ENUM'];

	function CartModel($http, $q, $timeout, $rootScope, CacheFactory, AppAuthenticationService, API, ENUM) {

		var service = {};
		service.isEmpty = false;
		service.isLoaded = false;
		service.isLoading = false;
		service.isLastPage = false;
		service.total = 0;
		service.subtotal = {};
		service.groups = null;
		service.add = _add;
		service.reload = _reload;
		service.reloadIfNeeded = _reloadIfNeeded;
		return service;

		function _add(goodsId, num, productId) {
			if (!AppAuthenticationService.getToken())
				return;
			var _this = this;
            return API.cart.add({
                goodsId: goodsId,
                number: num,
                productId: productId
				})
				.then(function (succeed) {
					if (succeed) {
						_this.reload();
					}
					return succeed;
				});
		}

		function _reload() {

			console.log(AppAuthenticationService.getToken());

			if (!AppAuthenticationService.getToken()) {
				// 置空
				this.total = 0;
				service.total = 0;
				return;
			}

			var _this = this;
			return API.cart.get({})
				.then(function (res) {
					console.log(res);
				});
		}

		function _reloadIfNeeded() {
			this.reload();
		}
	}

})();