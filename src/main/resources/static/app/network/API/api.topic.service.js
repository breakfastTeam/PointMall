(function () {

    'use strict';

    angular
        .module('app')
        .factory('APITopicService', APITopicService);

    APITopicService.$inject =  ['$http', '$q', '$timeout', 'CacheFactory', 'ENUM'];

    function APITopicService($http, $q, $timeout, CacheFactory, ENUM) {

        var service = new APIEndpoint( $http, $q, $timeout, CacheFactory, 'APITopicService' );
        service.list = _list;
        return service;

        function _list( params ) {
            return this.fetch( '/api.topic.list', params, true, function(res){
                return ENUM.ERROR_CODE.OK == res.data.errorCode ? res.data.result : null;
            });
        }
    }

})();
