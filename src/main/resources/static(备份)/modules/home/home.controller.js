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

		// var emptyCategory = {};
		// var emptyCategories = [];

		// for ( var i = 0; i < MAX_CATEGORIES; ++i ) {
		//   emptyCategories.push( emptyCategory );
		// }

		// $scope.categories = emptyCategories;

		var emptyProduct = {};
		var emptyProducts = [];

		for (var i = 0; i < MAX_PRODUCTS; ++i) {
			emptyProducts.push(emptyProduct);
		}

		$scope.topSale = emptyProducts;
		$scope.newArrival = emptyProducts;
		$scope.editorChoice = emptyProducts;

		$scope.touchSearch = _touchSearch;
		$scope.touchBanner = _touchBanner;
		$scope.touchNotice = _touchNotice;
		$scope.touchCategory = _touchCategory;
		$scope.touchProduct = _touchProduct;
		$scope.touchGroup = _touchGroup;

		$scope.reload = _reload;
		$scope.loadMore = _loadMore;

		$scope.cartModel = CartModel;

		function _touchSearch() {
			$state.go('search', {});
		}

		function _touchBanner(banner) {
			if (!banner.link || !banner.link.length) {
				$scope.toast('没有链接');
				return;
			}

			$window.location.href = banner.link;
		}

		function _touchNotice(notice) {
			var url = '';
			if (notice.url.indexOf("http://", 0) == -1) {
				url = "http://" + notice.url;
			} else {
				url = notice.url;
			}
			$window.location.href = url;
		}

		function _touchGroup(group) {
			$state.go('home', {

			});
		}

		function _touchCategory(category) {
			$state.go('search-result', {
				sortKey: ENUM.SORT_KEY.DEFAULT,
				sortValue: ENUM.SORT_VALUE.DEFAULT,

				keyword: null,
				category: category.id,

				navTitle: category.name,
				navStyle: 'default'
			});

		}

		function _touchProduct(product) {
			$state.go('product', {
				product: product.id,
			});
		}

        /****
		 * 加载广告
         * @private
         */
		function _reloadBanners() {

			API.banner
				.list({
					page: 1,
					per_page: MAX_BANNERS
				})
				.then(function (data) {
					$scope.banners = data;
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

		/**function _reloadNotices() {
			API.notice
				.list({
					page: 1,
					per_page: MAX_NOTICES
				})
				.then(function (notices) {
					$scope.notices = notices;
					var timer = $timeout(function () {
						$scope.noticeSwiper = new Swiper('.notice-slide', {
							spaceBetween: 30,
							centeredSlides: true,
							autoplay: 1500,
							autoplayDisableOnInteraction: false,
							direction: 'vertical',
							loop: true
						});
					}, 1);
				});
		}**/

		function _reloadCategories() {
			API.category
				.list({
					page: 1,
					per_page: MAX_CATEGORIES
				})
				.then(function (categories) {
					$scope.categories = categories;

                    window.sr = new scrollReveal({
                        // reset: true,
                        move: '100px',
                        mobile: true
                    });
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

		/**function _reloadEditorChoice() {
			API.product
				.list({
					page: 1,
					per_page: MAX_PRODUCTS,
					sort_key: ENUM.SORT_KEY.POPULAR,
					sort_value: ENUM.SORT_VALUE.DESC
				})
				.then(function (products) {
					$scope.editorChoice = products;
				});
		}**/

		function _reloadTopSale() {
			API.goods
				.topSaleList({
					page: 1,
					per_page: MAX_PRODUCTS,
					sort_key: ENUM.SORT_KEY.SALE,
					sort_value: ENUM.SORT_VALUE.DESC
				})
				.then(function (goods) {
					console.log(goods)
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
                    console.log(goods)
					$scope.newArrivals = goods;
				});
		}


        function _reloadIndex() {
            API.index
                .list({
                    page: 1,
                    per_page: MAX_PRODUCTS,
                    sort_key: ENUM.SORT_KEY.DATE,
                    sort_value: ENUM.SORT_VALUE.DESC
                })
                .then(function (goods) {
                    console.log(goods)
                    // $scope.newArrivals = goods;
                });
        }

		function _reload() {
			if(CONSTANTS.FOR_WEIXIN && !AppAuthenticationService.getOpenId()){

				if ($rootScope.isWeixin()) {
					$state.go('wechat-authbase', {});
					return;
				}
			}

			// _reloadBanners();
			// _reloadNotices();
			// _reloadCategories();
            // _reloadChannels();
            // _reloadFloorAndGoods();
            // _reloadEditorChoice();
            // _reloadNewArrival();
            // _reloadTopSale();
			ConfigModel.fetch();
            // _initShared();
			/********下面代码是新增的********/
            _reloadIndex();

			$scope.cartModel.reloadIfNeeded();
		}

		function _loadMore() {
			// TODO:
		}

        function _initShared(){

            if(!AppAuthenticationService.getToken()){
                return;
            }
            API.bonus.get().then(function (bonus_info) {
                var config = ConfigModel.getConfig();
                var wechat = config['wxpay.web'];

                if ( !wechat ) {
                    return;
                };

                wx.config({
                    debug: GLOBAL_CONFIG.DEBUG, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: wechat.app_id, // 必填，公众号的唯一标识
                    timestamp: wechat.timestamp, // 必填，生成签名的时间戳
                    nonceStr: wechat.nonceStr, // 必填，生成签名的随机串
                    signature: wechat.signature,// 必填，签名，见附录1
                    jsApiList: ['chooseWXPay',
                        'onMenuShareAppMessage',
                        'onMenuShareTimeline',
                        'onMenuShareAppMessage',
                        'onMenuShareQQ'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });

                var shared_link = bonus_info.shared_link;

                wx.ready( function() {
                    wx.onMenuShareTimeline({
                        title: '推荐分成', // 分享标题
                        desc:'',
                        link: shared_link, // 分享链接
                        imgUrl: '', // 分享图标
                        success: function () {
                            // 用户确认分享后执行的回调函数
                        },
                        cancel: function () {
                            // 用户取消分享后执行的回调函数
                        }
                    });

                    wx.onMenuShareAppMessage({
                        title: '推荐分成', // 分享标题
                        desc:'',
                        link: shared_link, // 分享链接
                        imgUrl: '', // 分享图标
                        success: function () {
                            // 用户确认分享后执行的回调函数
                        },
                        cancel: function () {
                            // 用户取消分享后执行的回调函数
                        }
                    });

                    wx.onMenuShareQQ({
                        title: '推荐分成', // 分享标题
                        desc: '', // 分享描述
                        link: shared_link, // 分享链接
                        imgUrl: '', // 分享图标
                        success: function () {
                            // 用户确认分享后执行的回调函数
                        },
                        cancel: function () {
                            // 用户取消分享后执行的回调函数
                        }
                    });
                    wx.onMenuShareWeibo({
                        title: '推荐分成', // 分享标题
                        desc: '', // 分享描述
                        link: shared_link, // 分享链接
                        imgUrl: '', // 分享图标
                        success: function () {
                            // 用户确认分享后执行的回调函数
                        },
                        cancel: function () {
                            // 用户取消分享后执行的回调函数
                        }
                    });

                });

                wx.error(function(res){
                    if(GLOBAL_CONFIG.DEBUG){
                        $rootScope.toast(JSON.stringify(res));
                    }
                });
                return true;

            });


        }
		_reload();
	}

})();