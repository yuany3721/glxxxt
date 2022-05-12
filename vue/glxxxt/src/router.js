import * as vueRouter from "vue-router";
import Root from "./components/Root.vue";

const routes = [
    {
        path: "/",
        name: "Root",
        alias: "/index",
        component: Root,
        meta: {
            breadcrumb: "管理信息系统",
        },
    },
    {
        path: "/Cook",
        name: "Cook",
        component: () => import("./components/Cook.vue"),
        meta: {
            breadcrumb: "后厨",
        },
    },
    {
        path: "/Menu",
        name: "Menu",
        component: () => import("./components/Menu.vue"),
        meta: {
            breadcrumb: "菜单",
        },
    },
    {
        path: "/Ingredient",
        name: "Ingredient",
        component: () => import("./components/Ingredient.vue"),
        meta: {
            breadcrumb: "食材列表",
        },
    },
    {
        path: "/PurchaseList",
        name: "PurchaseList",
        component: () => import("./components/PurchaseList.vue"),
        meta: {
            breadcrumb: "进货单列表",
        },
    },
    {
        path: "/Order",
        name: "Order",
        component: () => import("./components/Order.vue"),
        meta: {
            breadcrumb: "订货单",
        },
    },
    {
        path: "/Message",
        name: "Message",
        component: () => import("./components/Message.vue"),
        meta: {
            breadcrumb: "留言",
        },
    },
    {
        path: "/Information",
        name: "Information",
        component: () => import("./components/Information.vue"),
        meta: {
            breadcrumb: "基本信息",
        },
    },
    {
        path: "/Purchase",
        name: "Purchase",
        component: () => import("./components/Purchase.vue"),
        meta: {
            breadcrumb: "进货单",
        },
    },
    {
        path: "/404",
        name: "NotFound",
        component: () => import("./components/404.vue"),
        meta: {
            breadcrumb: "404",
        },
    },
    {
        path: "/:pathMatch(.*)",
        redirect: "/404",
    },
];

const router = vueRouter.createRouter({
    history: vueRouter.createWebHistory(),
    routes: routes,
});

export default router;
