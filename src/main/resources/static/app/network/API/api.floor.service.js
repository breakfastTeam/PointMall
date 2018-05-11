(function () {

    'use strict';

    angular
    .module('app')
    .factory('APIFloorService', APIFloorService);

    APIFloorService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIFloorService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIFloorService' );
        service.list = _list;
        return service;

        function _list( params ) {
            return this.fetch( '/api.floorAndGoods.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
