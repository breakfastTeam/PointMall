(function () {

    'use strict';

    angular
    .module('app')
    .factory('APIGoodsService', APIGoodsService);

    APIGoodsService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIGoodsService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIGoodsService' );
        service.detail = _detail;
        return service;

        function _detail( params ) {
            return this.fetch( '/goods/detail', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errno ? res.data : null;
            });
        }

    }

})();
