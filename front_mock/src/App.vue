<template>
  <div class="tm-2 container has-text-centered">
    <button
      class="my-6 mx-6 button is-rounded is-success is-light"
      @click="login"
    >
      LOGIN
    </button>
    <button
      class="my-6 mx-6 button is-rounded is-info is-light"
      @click="verify"
    >
      VERIFY
    </button>
    <button
      class="my-6 mx-6 button is-rounded is-danger is-light"
      @click="logout"
    >
      LOGOUT
    </button>
  </div>
</template>

<script>
export default {
  name: "App",
  methods: {
    login: () => {
      window.location.href = "https://auth.catteam.tk?origin=https://mock.catteam.tk "
    },
    verify: async () => {
      console.log("Get called");
      let res = await fetch("https://back.catteam.tk/verify", {
        method: "get",
        credentials: 'include'
      });
      if (res.ok) {
        console.log("Get done");
      }
    },
    logout: async () => {
      console.log("Del called");
      let res = await fetch("https://back.catteam.tk/logout", {
        method: "delete",
        credentials: 'include'
      });
      if (res.ok) {
        console.log("Del done");
      }
    }
  },
};
</script>
