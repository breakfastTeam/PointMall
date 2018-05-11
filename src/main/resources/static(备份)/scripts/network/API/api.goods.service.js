(function () {
    'use strict';

    angular
    .module('app')
    .factory('APIGoodsService', APIGoodsService);

    APIGoodsService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIGoodsService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIGoodsService' );
        service.list = _list;
        service.topSaleList = _topSaleList;
        service.newArrivalList = _newArrivalList;
        service.accessoryList = _accessoryList;
        service.get = _get;
        service.like = _like;
        service.unlike = _unlike;
        service.likedList = _likedList;
        service.validate = _validate;
        service.purchase = _purchase;
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


        function _list(params) {
            return this.fetch( '/v2/ecapi.product.list', params, false, function(res){
                    return (res.data &&(ENUM.ERROR_CODE.OK == res.data.error_code)) ? res.data.products : null;

            });
        }

        function _accessoryList(params) {
            return this.fetch( '/v2/ecapi.product.list', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.error_code ? res.data.products : null;
            });
        }

        function _like(params) {
            return this.fetch( '/v2/ecapi.product.like', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.error_code ? res.data.is_liked : true;
            });
        }

        function _unlike(params) {
            return this.fetch( '/v2/ecapi.product.unlike', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.error_code ? res.data.is_liked : false;
            });
        }

        function _likedList(params) {
            return this.fetch( '/v2/ecapi.product.liked.list', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.error_code ? res.data.products : null;
            });
        }

        function _validate(params) {
            return this.fetch( '/v2/ecapi.product.validate', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.error_code ? res.data.is_valid : false;
            });
        }

        function _purchase(params) {
            return this.fetch( '/v2/ecapi.product.purchase', params, false, function(res){
                return ENUM.ERROR_CODE.OK == res.data.error_code ? res.data.order : null;
            });
        }

    }

})();
