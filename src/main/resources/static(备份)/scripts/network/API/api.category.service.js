(function () {

    'use strict';

    angular
    .module('app')
    .factory('APICategoryService', APICategoryService);

    APICategoryService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APICategoryService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APICategoryService' );
        service.list = _list;
        service.categoryList = _categoryList;
        return service;

        function _list( params ) {
            return this.fetch( '/api.category.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }

        function _categoryList( params ) {
            return this.fetch( '/api.categoryGoods.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
