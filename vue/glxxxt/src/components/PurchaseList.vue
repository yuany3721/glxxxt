<template>
    <el-input v-model="search" size="mini" placeholder="搜索食材或日期" />
    <el-table :data="tableData" :default-sort="{ prop: 'id', order: 'descending' }">
        <el-table-column prop="id" label="id" sortable> </el-table-column>
        <el-table-column prop="ingredientName" label="食材名称" sortable> </el-table-column>
        <el-table-column prop="price" label="进货价" sortable> </el-table-column>
        <el-table-column prop="quantity" label="订货量" sortable> </el-table-column>
        <el-table-column prop="date" label="日期" sortable> </el-table-column>
    </el-table>
    <br /><br />
    <el-button type="primary" :loading="isBack" @click="backToHome">
        返回
        <i class="el-icon-house el-icon--right"></i>
    </el-button>
    <br /><br />
</template>

<script type="text/javascript">
export default {
    name: "PurchaseList",
};
</script>

<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs, computed } from "vue";
import router from "../router";
const { proxy } = getCurrentInstance();

const data = reactive({
    purchases: [],
    search: "",
    isBack: false,
});

function getPurchaseList() {
    //获取订货单列表
    proxy.$http
        .get("/getPurchaseList")
        .then((res) => {
            // console.log(res);
            data.purchases = res.data;
            //console.log(this.purchases);
        })
        .catch(function () {
            console.log("%c error in getting Purchase List", "color:red;");
        });
}

onMounted(() => {
    getPurchaseList();
});

function backToHome() {
    data.isBack = true;
    window.setTimeout(() => {
        router.push("/");
    }, 2000);
}

const tableData = computed(() =>
    data.purchases.filter(
        (data) =>
            !search.value ||
            data.ingredientName.toLowerCase().includes(search.value.toLowerCase()) ||
            data.date.toLowerCase().includes(search.value.toLowerCase())
    )
);

const { search, isBack } = toRefs(data);
</script>

<style scoped></style>
