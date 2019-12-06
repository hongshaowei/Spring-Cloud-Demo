<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="User Account:"
        label-for="input-1"
        description="Do insert with cautious."
      >
        <b-form-input
          id="input-1"
          v-model="form.adAcc"
          type="text"
          required
          placeholder="Enter user account"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Password:" label-for="input-2">
        <b-form-input id="input-2" v-model="form.adPwd" type="password" required placeholder="Enter Password"></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Login',
  data: function () {
    return {
      form: {
        adAcc: '',
        adPwd: ''
      },
      show: true
    }
  },
  methods: {
    onSubmit (event) {
      event.preventDefault()
      const formData = new FormData()
      formData.append('adAcc', this.form.adAcc)
      formData.append('adPwd', this.form.adPwd)
      // Vue.axios.post('http://localhost:8080/auth-service/login', formData, {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
      //   .then(resp => {
      //     console.log(resp.data)
      //     let rslt = resp.data
      //     if (rslt.status === 200) {
      //       localStorage.setItem('isLogin', 1)
      //       this.$router.push({name: 'Home'})
      //     }
      //   })
      axios.post('http://localhost:8080/auth-service/login', formData, {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
        .then(resp => {
          console.log(resp.data)
          let rslt = resp.data
          if (rslt.status === 200) {
            localStorage.setItem('isLogin', 1)
            this.$router.push({name: 'Home'})
            // if (this.$route.params.nextUrl != null) {
            //   this.$router.push(this.$route.params.nextUrl)
            // } else {
            //   this.$router.push('/')
            // }
          }
          // if (this.$route.params.nextUrl != null) {
          //   this.$router.push(this.$route.params.nextUrl)
          // } else {
          //   this.$router.push('Home')
          // }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    onReset (event) {
      event.preventDefault()
      // Reset our form values
      this.form.adAcc = ''
      this.form.adPwd = ''
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  }
}
</script>
