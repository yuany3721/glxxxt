import { createApp } from "vue";
import App from "./App.vue";
const app = createApp(App);

// router
import router from "./router";
router.beforeEach((to, from, next) => {
    if (to.meta.breadcrumb) {
        document.title = to.meta.breadcrumb;
    }
    next();
});
app.use(router);

//axios
import axios from "./axios";
app.config.globalProperties.$http = axios;

app.mount("#app");
