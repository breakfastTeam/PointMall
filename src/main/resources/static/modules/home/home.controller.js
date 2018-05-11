(function () {

	'use strict';

	angular
		.module('app')
		.controller('HomeController', HomeController);

	HomeController.$inject = ['$scope', '$http','$rootScope', '$timeout', '$location', '$state', 'API', 'ENUM','CONSTANTS', '$window', 'AppAuthenticationService', 'CartModel','ConfigModel'];

	function HomeController($scope, $http,$rootScope, $timeout, $location, $state, API, ENUM,CONSTANTS, $window, AppAuthenticationService, CartModel,ConfigModel) {

        var MAX_ADS = 10;
        var MAX_NOTICES = 5;
        var MAX_CATEGORIES = 4;
        var MAX_PRODUCTS = 4;

		$scope.ads = [];

		var emptyProduct = {};
		var emptyProducts = [];

		for (var i = 0; i < MAX_PRODUCTS; ++i) {
			emptyProducts.push(emptyProduct);
		}

		$scope.topSale = emptyProducts;
		$scope.newArrival = emptyProducts;
		$scope.editorChoice = emptyProducts;

        $scope.touchGoods = _touchGoods;
        $scope.touchBanner = _touchBanner;

		$scope.reload = _reload;
		$scope.loadMore = _loadMore;


		function _touchBanner(banner) {
			if (!banner.link || !banner.link.length) {
				$scope.toast('没有链接');
				return;
			}

			$window.location.href = banner.link;
		}

		function _touchGoods(goods) {
			$state.go('product', {
				product: product.id,
			});
		}


		function _reload() {
            _reloadAds();
            _reloadBrands();
            _reloadChannels();
            _reloadNewArrival();
            _reloadFloorAndGoods();
            _reloadTopSale();
            _reloadTopics();

        }


        function _reloadAds() {
            API.ad.list({
                    page: 1,
                    per_page: MAX_ADS
                })
                .then(function (data) {
                    $scope.ads = data;
                    var timer = $timeout(function () {
                        $scope.bannerSwiper = new Swiper('.home-banner', {
                            pagination: '.swiper-pagination',
                            paginationClickable: true,
                            spaceBetween: 30,
                            centeredSlides: true,
                            autoplay: 1500,
                            autoplayDisableOnInteraction: false,
                            loop: true,
                        });

                        TouchSlide({
                            slideCell: "#slideBox",
                            titCell: "#slideBox .hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
                            mainCell: "#slideBox .bd ul",
                            effect: "leftLoop",
                            autoPage: true,//自动分页
                            autoPlay: true //自动播放
                        });

                    }, 100);
                });
        }

        function _reloadChannels() {
            API.channel
                .list({
                    page: 1,
                    per_page: MAX_CATEGORIES
                })
                .then(function (channels) {
                    $scope.channels = channels;
                });
        }

        function _reloadFloorAndGoods() {
            API.floor
                .list({
                    page: 1,
                    per_page: MAX_CATEGORIES
                })
                .then(function (floorsAndGoods) {
                    $scope.floorsAndGoods = floorsAndGoods;
                });
        }
        function _reloadTopSale() {
            API.goods
                .topSaleList({
                    page: 1,
                    per_page: MAX_PRODUCTS,
                    sort_key: ENUM.SORT_KEY.SALE,
                    sort_value: ENUM.SORT_VALUE.DESC
                })
                .then(function (goods) {
                    $scope.topSales = goods;
                });
        }

        function _reloadNewArrival() {
            API.goods
                .newArrivalList({
                    page: 1,
                    per_page: MAX_PRODUCTS,
                    sort_key: ENUM.SORT_KEY.DATE,
                    sort_value: ENUM.SORT_VALUE.DESC
                })
                .then(function (goods) {
                    $scope.newGoods = goods;
                });
        }
        function _reloadBrands() {
            API.brand.list().then(function (data) {
                    $scope.brands = data;
                });
        }

        function _reloadTopics() {
            API.topic.list().then(function (data) {
                console.log(data);
                $scope.topics = data;
            });
        }

		function _loadMore() {
			// TODO:
		}

		_reload();
	}

})();