export class UserController {
    constructor($routeParams, UserService) {
        this.id = $routeParams.id;
        this.UserService = UserService;

        this.UserService.getUser(this.id)
            .then(user => this.user = user);
    }
}