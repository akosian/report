<template>
  <users-list :users="users"/>
</template>

<script>
import UsersList from "../components/users/UsersList.vue";

export default {
  components: {
    UsersList
  },
  data() {
    return {
      users: []
    }
  }
}
</script>
<style>

</style>