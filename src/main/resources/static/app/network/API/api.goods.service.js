(function () {

    'use strict';

    angular
        .module('app')
        .factory('APIGoodsService', APIGoodsService);

    APIGoodsService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIGoodsService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIGoodsService' );
        service.topSaleList = _topSaleList;
        service.newArrivalList = _newArrivalList;
        service.get = _get;
        return service;

        function _topSaleList(params) {
            return this.fetch( '/api.goods.topSaleList', params, false, function(res){
                return (res.data &&(ENUM.ERROR_CODE.OK == res.data.errorCode)) ? res.data.result : null;

            });
        }

        function _newArrivalList(params) {
            return this.fetch( '/api.goods.newArrivalList', params, false, function(res){
                return (res.data &&(ENUM.ERROR_CODE.OK == res.data.errorCode)) ? res.data.result : null;

            });
        }

        function _get(params) {
            return this.fetch( '/api.goods.get', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
