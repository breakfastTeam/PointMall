(function () {

    'use strict';

    angular
    .module('app')
    .factory('APIIndexService', APIIndexService);

    APIIndexService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIIndexService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIIndexService' );
        service.list = _list;
        return service;

        function _list( params ) {
            return this.fetch( '/index/index', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errno ? res.data : null;
            });
        }

    }

})();
