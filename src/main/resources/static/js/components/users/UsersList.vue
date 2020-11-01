<template>
  <div style="position: relative; width: 300px;">
    <user-form :users="users" :userAttr="user"/>
    <user-row v-for="user in users"
              :user="user"
              :key="user.id"
              :editUser="editUser"
              :deleteUser="deleteUser"
              :users="users"></user-row>
  </div>
</template>

<script>
import UserRow from "./UserRow.vue";
import UserForm from "./UserForm.vue";

export default {
  props: ['users'],
  components: {
    UserRow,
    UserForm
  },
  data() {
    return {
      user: null
    }
  },
  created: function () {
    this.$resource("/api/users{/id}").get().then(result =>
        result.json().then(data =>
            data.forEach(user => this.users.push(user))
        )
    )
  },
  methods: {
    editUser(user) {
      this.user = user
    },
    deleteUser(user) {
      this.$resource("/api/users{/id}").remove({id: user.id}).then(result => {
        if (result.ok) {
          this.users.splice(this.users.indexOf(this.user), 1);
        }
      })
    }
  }
}
</script>

<style>

</style>