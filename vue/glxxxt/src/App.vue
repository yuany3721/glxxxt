<script setup>
import Breadcrumb from "./components/Breadcrumb.vue";
</script>

<template>
    <h1 class="red">火！锅！店！</h1>
    <el-card class="el-card">
        <div class="box">
            <div class="item"><router-link to="/">首页</router-link></div>
            |
            <div class="item"><router-link to="/Menu">菜单</router-link></div>
            |
            <div class="item"><router-link to="/Purchase">进货单</router-link></div>
            |
            <div class="item"><router-link to="/Ingredient">食材列表</router-link></div>
            |
            <div class="item"><router-link to="/PurchaseList">进货单列表</router-link></div>
            |
            <div class="item"><router-link to="/Order">订单列表</router-link></div>
            |
            <div class="item"><router-link to="/Message">留言</router-link></div>
            |
            <div class="item"><router-link to="/Information">基本信息</router-link></div>
        </div>
    </el-card>
    <Breadcrumb />
    <el-card class="el-card"><router-view :key="$route.path"></router-view></el-card>
</template>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
.red {
    color: red;
    font-size: 50px;
}
.el-card {
    width: 80%;
    margin: 10px auto;
}
.box {
    display: flex;
    flex-flow: row wrap;
    justify-content: flex-start;
    align-items: center;
    align-content: flex-start;
}
.item {
    margin: 10px;
    padding: 5px;
    flex: auto;
}
.item a {
    text-decoration: none;
    font-size: larger;
    font-weight: bolder;
    letter-spacing: 0.2em;
    cursor: pointer;
    color: #000;
}
.item a:hover {
    color: #409eff;
}
</style>
