<template>
    <div class="breadcrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item><span @click="homepage">主页</span></el-breadcrumb-item>
            <el-breadcrumb-item to="/">火锅店管理信息系统</el-breadcrumb-item>
            <transition-group name="breadcrumb">
                <el-breadcrumb-item v-for="item in listData" :key="item.path + item.name">
                    <router-link :to="item">{{ item.meta.breadcrumb }}</router-link>
                </el-breadcrumb-item>
            </transition-group>
        </el-breadcrumb>
        <div class="separator"></div>
    </div>
</template>

<script>
export default {
    name: "Breadcrumb",
};
</script>

<script setup>
import { onMounted, reactive, toRefs, watch } from "vue";
import router from "../router";

const data = reactive({
    listData: [],
});

function getMatched() {
    data.listData = router.currentRoute.matched;
}

function homepage() {
    window.location = "https://yuany3721.top";
}

onMounted(() => {
    getMatched();
});

watch(
    () => router.currentRoute.value.matched,
    (newValue, oldValue) => {
        data.listData = newValue;
    },
    { immediate: true }
);

const { listData } = toRefs(data);
</script>

<style scoped>
.breadcrumb {
    width: 80%;
    margin: 10px auto;
    padding: 10px 0 0 10px;
}
.el-breadcrumb__item span {
    font-weight: bolder;
    color: #000;
    cursor: pointer;
}
.el-breadcrumb__item span:hover {
    color: #409eff;
}
.separator {
    display: block;
    width: 40px;
    height: 3px;
    margin: 10px 0 15px;
    background-color: #4775ff;
    position: relative;
}
</style>
