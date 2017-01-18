const api = 'http://localhost:3000/users';

export class UserService {
    constructor($http, $timeout) {
        this.$http = $http;
        this.$timeout = $timeout;
    }

    getUser(id) {
        return this.$http.get(`${ api }/${ id }`)
            .then(response =>  response.data);
    }

    getUsers() {
        return this.$http.get(api)
            .then(response =>  response.data);
    }

    saveUser(user) {
        return this[user.id ? 'updateUser' : 'addUser'](user);
    }

    addUser(user) {
        return this.$http.post(api, user)
            .then(response =>  response.data);
    }

    updateUser(user) {
        return this.$http.put(`${ api }/${ user.id }`, user)
            .then(response =>  response.data);  
    }

    deleteUser(user) {
        return this.$timeout(3000)
            .then(() => this.$http.delete(`${ api }/${ user.id }`))
            .then(response =>  response.data);
    }
}