import angular from 'angular';
import ngRoute from 'angular-route';

import { EldestFilter } from './eldest.filter';
import { UsersController } from './users.controller';
import { UserController } from './user.controller';
import { UserService } from './user.service';

export default angular.module('user', [
    ngRoute
])

.controller('UsersController', UsersController)
.controller('UserController', UserController)
.filter('eldest', EldestFilter)

.service('UserService', UserService)

.config(function($routeProvider) {

    $routeProvider
    .when('/users', {
      template: require('./users.html'),
      controller: 'UsersController',
      controllerAs: 'ctrl'
    })
    .when('/user/:id', {
      template: require('./user.html'),
      controller: 'UserController',
      controllerAs: 'ctrl'
    })
    .when('/users/add', {
      template: require('./addUser.html'),
      controller: 'UserController',
      controllerAs: 'ctrl'
    })
})

.name;