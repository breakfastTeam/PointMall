(function () {

    'use strict';

    angular
    .module('app')
    .factory('APIGoodsGalleryService', APIGoodsGalleryService);

    APIGoodsGalleryService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIGoodsGalleryService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIGoodsGalleryService' );
        service.list = _list;
        return service;

        function _list( params ) {
            return this.fetch( '/api.goodsGallery.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
