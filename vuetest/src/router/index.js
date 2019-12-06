import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/shared/Home'
import Login from '@/components/shared/Login'

Vue.use(Router)

// function getCookie (cname) {
//   let name = cname + '='
//   let ca = document.cookie.split(';')
//   for (let i = 0; i < ca.length; i++) {
//     let c = ca[i].trim()
//     if (c.indexOf(name) === 0) {
//       return c.substring(name.length, c.length)
//     }
//   }
//   return ''
// }

let router = new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (localStorage.getItem('isLogin') === null) {
    if (to.path !== '/login') {
      return next({
        path: '/login',
        params: { nextUrl: to.fullPath }
      })
    } else {
      next()
    }
  } else {
    if (to.path === '/login') {
      return next({
        path: '/'
      })
    }
    next()
  }

  // if (getCookie('SESSION') === '') {
  //   if (to.path !== '/login') {
  //     return next({
  //       path: '/login',
  //       params: { nextUrl: to.fullPath }
  //     })
  //   } else {
  //     next()
  //   }
  // } else {
  //   if (to.path === '/login') {
  //     return next({
  //       path: '/'
  //     })
  //   }
  //   next()
  // }
})

export default router
