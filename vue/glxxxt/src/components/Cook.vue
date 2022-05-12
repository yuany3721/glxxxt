<template>
    <div v-if="isOrder">
        点单成功
        <br />
        <br />

        当前菜单：
        <div v-for="dish in order" :key="dish.id">{{ dish.dishes }}({{ dish.type }})</div>
        <br />
        <br />

        <el-button type="primary" :loading="isloading" @click="cook"> 点我让厨师<b>瞬间</b>做完这些菜 </el-button>
    </div>
    <div v-else>
        <el-button type="primary" :loading="isloading" @click="back">
            点单失败，点击返回菜单
            <i class="el-icon-house el-icon--right"></i>
        </el-button>
    </div>
</template>

<script>
export default {
    name: "Cook",
};
</script>
<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs, computed } from "vue";
import router from "../router";
/** vite 直接引route或者useRoute会报错
 * 所以只能全引进来.useRoute */
import * as vueRouter from "vue-router";
const { proxy } = getCurrentInstance();

const data = reactive({
    order: [],
    isOrder: false,
    isloading: false,
});

function getOrder() {
    data.order = JSON.parse(vueRouter.useRoute().params.order);
    proxy.$http
        .post_json("/newOrder", data.order)
        .then((res) => {
            // console.log(res);
            if (res.data == 1) {
                data.isOrder = true;
            }
        })
        .catch(function () {
            console.log("%c error in confirming the order", "color:red;");
        });
}

function back() {
    data.isloading = true;
    router.push("/Menu");
}

function cook() {
    data.isloading = true;
    proxy.$http
        .post_json("/cook", data.order)
        .then((res) => {
            // console.log(res);
            if (res.data == 1) {
                alert("做完了！！！");
                router.push("/");
            }
        })
        .catch(function () {
            console.log("%c error in cooking", "color:red;");
        });
}

onMounted(() => {
    getOrder();
});

const { order, isOrder, isloading } = toRefs(data);
</script>

<style scoped></style>
