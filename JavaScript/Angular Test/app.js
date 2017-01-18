angular.module('app', [])

    .run(function () {
        console.log('PizzaYOLO !');
    })

    .controller('MyFirstController', class MyFirstController {
        constructor() {
            this.users = [{
                    name: 'un',
                    age: 10
                },
                {
                    name: 'deux',
                    age: 20
                },
                {
                    name: 'trois',
                    age: 33
                },
                {
                    name: 'quatre',
                    age: 42
                },
            ];
            this.predicat = 'name';
            this.reverse = false;

            this.newUser = {
                name: '',
                age: 18
            };
        }

        sort(predicat) {
            if (this.predicat === predicat) {
                this.reverse = !this.reverse;
            }
            this.predicat = predicat;
        }

        addUser(form, user) {
            if (form.$invalid) return;

            let temp = angular.copy(user);
            this.users.push(temp);
            user.name = '';
        }
    })

    .filter('exclamation', function () {
        return (input, size = 1) => {
            if (typeof input !== 'string') return '';
            return input + '!'.repeat(size);
        }
    })

    .filter('eldest', function () {
        return (users) => {
            if (!users instanceof Array) return '';

            let max = users[0];
            users.forEach((user) => {
                if (user.age && user.age > max.age) max = user;
            });

            return max.name;

            // const eldest = users.reduce((max, user) => {
            //     if (user.age && user.age > max.age) return user;
            //     return max;
            // }, {name: '', age: 0});

            // return eldest.name;
        }
    })