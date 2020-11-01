<template>
  <div>
    <i>{{ user.id }} </i>{{ user.username }}
    <span style="position: absolute; right: 0">
        <input type="button" value="Edit" @click="edit"/>
        <input type="button" value="Delete" @click="deleteUser"/>
        </span>
  </div>
</template>
<script>
export default {
  props: ['user', 'editUser', 'users'],
  methods: {
    edit() {
      this.editUser(this.user)
    },
    deleteUser() {
      this.deleteUser(this.user)
    }
  }
}
</script>

<style>

</style>