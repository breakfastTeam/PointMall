(function () {

    'use strict';

    angular
        .module('app')
        .factory('APIChannelService', APIChannelService);

    APIChannelService.$inject = ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APIChannelService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APIChannelService' );
        service.list = _list;
        return service;

        function _list( params ) {
            return this.fetch( '/api.channel.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
