<template>
  <div style="position: relative; width: 300px;">
    <input type="text" placeholder="Enter username" v-model="username"/>
    <input type="password" placeholder="Enter password" v-model="password"/>
    <input type="button" value="Save" @click="save"/>
  </div>
</template>

<script>
function getIndex(list, id) {
  for (let i = 0; i < list.length; i++) {
    if (list[i].id === id) {
      return list[i]
    }
  }
  return -1
}

export default {
  props: ['users', 'userAttr'],
  data() {
    return {
      username: '',
      password: '',
      id: '',
    }
  },
  watch: {
    userAttr(newVal, OldVal) {
      this.username = newVal.username;
      this.password = newVal.password;
      this.id = newVal.id;
    }
  },
  methods: {
    save() {
      const user = {
        username: this.username,
        password: this.password,
      };

      if (this.id) {
        this.$resource("/api/users{/id}").update({id: this.id}, user).then(result =>
            result.json().then(data => {
              const index = getIndex(this.users, data.id)
              this.users.splice(index, 1);
              this.users.push(user)
              this.id = '';
              this.username = '';
              this.password = '';
            }))
      } else {
        this.$resource("/api/users{/id}").save({}, user).then(result =>
            result.json().then(data => {
              this.users.push(data)
              this.username = '';
              this.password = '';
            }))
      }
    }
  }
}
</script>

<style>

</style>