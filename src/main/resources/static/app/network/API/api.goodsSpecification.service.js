(function () {

    'use strict';

    angular
    .module('app')
    .factory('APIGoodsSpecificationService', APIGoodsSpecificationService);

    APIGoodsSpecificationService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIGoodsSpecificationService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIGoodsSpecificationService' );
        service.list = _list;
        return service;

        function _list( params ) {
            return this.fetch( '/api.goodsSpecification.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
