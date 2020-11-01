var reportApi = Vue.resource("/api/users{/id}");

Vue.component('user-row', {
    props: ['user'],
    template: '<div><i>{{user.id}} </i>{{user.username}}</div>'
})

Vue.component('users-list', {
    props: ['users'],
    template:
        '<div>' +
        '<user-row v-for="user in users" :user="user" :key="user.id"></user-row>' +
        '</div>',
    created: function () {
        reportApi.get().then(result =>
            result.json().then(data =>
                data.forEach(user => this.users.push(user))
            )
        )
    }
})

var app = new Vue({
    el: '#app',
    template: '<users-list :users="users"/>',
    data: {
        users: []
    }
})