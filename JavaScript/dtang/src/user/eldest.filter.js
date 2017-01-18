export function EldestFilter () {
    return (users) => {
        if (!users instanceof Array || !users || !users.length) return '';

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
}