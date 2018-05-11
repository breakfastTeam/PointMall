(function () {

	'use strict';

	angular
		.module('app')
		.controller('HomeController', HomeController);

	HomeController.$inject = ['$scope', '$http','$rootScope', '$timeout', '$location', '$state', 'API', 'ENUM','CONSTANTS', '$window', 'AppAuthenticationService', 'CartModel','ConfigModel'];

	function HomeController($scope, $http,$rootScope, $timeout, $location, $state, API, ENUM,CONSTANTS, $window, AppAuthenticationService, CartModel,ConfigModel) {

		var MAX_BANNERS = 10;
		var MAX_NOTICES = 5;
		var MAX_CATEGORIES = 4;
		var MAX_PRODUCTS = 4;

		$scope.banners = [];
		$scope.notices = [];

		var emptyProduct = {};
		var emptyProducts = [];

		for (var i = 0; i < MAX_PRODUCTS; ++i) {
			emptyProducts.push(emptyProduct);
		}

		$scope.topSale = emptyProducts;
		$scope.newArrival = emptyProducts;
		$scope.editorChoice = emptyProducts;

		$scope.touchBanner = _touchBanner;
		$scope.touchProduct = _touchProduct;

		$scope.reload = _reload;
		$scope.loadMore = _loadMore;

		$scope.cartModel = CartModel;


		function _touchBanner(banner) {
			if (!banner.link || !banner.link.length) {
				$scope.toast('没有链接');
				return;
			}

			$window.location.href = banner.link;
		}

		function _touchProduct(product) {
			$state.go('product', {
				product: product.id,
			});
		}


		function _reload() {

			if(CONSTANTS.FOR_WEIXIN && !AppAuthenticationService.getOpenId()){

				if ($rootScope.isWeixin()) {
					$state.go('wechat-authbase', {});
					return;
				}
			}

            _reloadIndex();

			$scope.cartModel.reloadIfNeeded();
		}

        function _reloadIndex() {
            API.index
                .list({
                    page: 1,
                    per_page: MAX_PRODUCTS,
                    sort_key: ENUM.SORT_KEY.DATE,
                    sort_value: ENUM.SORT_VALUE.DESC
                })
                .then(function (res) {
                    $scope.newGoods= res.data.newGoodsList;
					$scope.hotGoods= res.data.hotGoodsList;
					$scope.topics= res.data.topicList;
                    $scope.brands= res.data.brandList;
                    $scope.floorGoods= res.data.categoryList;
                    $scope.banners= res.data.banner;
                    $scope.channels= res.data.channel
                });
        }

		function _loadMore() {
			// TODO:
		}

		_reload();
	}

})();