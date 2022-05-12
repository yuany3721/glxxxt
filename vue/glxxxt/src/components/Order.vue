<template>
    这里可以做成同一个订单是一条数据，点开看到这个订单点了哪些菜，but for my laziness......
    <br />
    <el-input v-model="search" size="mini" placeholder="搜索订单时间（均为英文符号）或食材" />
    <el-table :data="tableData" :default-sort="{ prop: 'id', order: 'descending' }">
        <el-table-column prop="id" label="订单时间" sortable> </el-table-column>
        <el-table-column prop="menuName" label="菜品名称" sortable> </el-table-column>
    </el-table>
    <br />
    <br />
    <el-button type="primary" :loading="isBack" @click="backToHome">
        返回
        <i class="el-icon-house el-icon--right"></i>
    </el-button>
    <br /><br />
</template>

<script type="text/javascript">
export default {
    name: "Order",
};
</script>

<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs, computed } from "vue";
import router from "../router";
const { proxy } = getCurrentInstance();

const data = reactive({
    orders: [],
    search: "",
    isBack: false,
});

function getOrder() {
    //获取订单列表
    proxy.$http
        .get("/getOrder")
        .then((res) => {
            // console.log(res);
            data.orders = res.data;
            // console.log(this.orders);
        })
        .catch(function () {
            console.log("%c error in getting Order", "color:red;");
        });
}

const tableData = computed(() =>
    data.orders.filter(
        (data) =>
            !search.value ||
            data.menuName.toLowerCase().includes(search.value.toLowerCase()) ||
            data.id.toLowerCase().includes(search.value.toLowerCase())
    )
);

function backToHome() {
    data.isBack = true;
    window.setTimeout(() => {
        router.push("/");
    }, 2000);
}

onMounted(() => {
    getOrder();
});

const { search, isBack } = toRefs(data);
</script>
<style scoped></style>
