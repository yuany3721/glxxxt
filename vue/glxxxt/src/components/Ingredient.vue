<template>
    <el-input v-model="search" size="mini" placeholder="搜索食材" />
    <el-table :data="filterTableData" :default-sort="{ prop: 'id', order: 'ascending' }">
        <el-table-column prop="id" label="id" sortable> </el-table-column>
        <el-table-column prop="name" label="食材名称" sortable> </el-table-column>
        <el-table-column prop="remaining" label="余量" sortable> </el-table-column>
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
    name: "Ingredient",
};
</script>

<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs, computed } from "vue";
import router from "../router";
const { proxy } = getCurrentInstance();

const data = reactive({
    ingredients: [],
    search: "",
    isBack: false,
});

function getIngredient() {
    //获取材料列表
    proxy.$http
        .get("/getIngredient")
        .then((res) => {
            // console.log(res);
            data.ingredients = res.data;
            // console.log(this.ingredients);
        })
        .catch(function () {
            console.log("%c error in getting ingredient", "color:red;");
        });
}

function backToHome() {
    data.isBack = true;
    window.setTimeout(() => {
        router.push("/");
    }, 2000);
}

onMounted(() => {
    getIngredient();
});

const filterTableData = computed(() =>
    data.ingredients.filter((data) => !search.value || data.name.toLowerCase().includes(search.value.toLowerCase()))
);

const { search, isBack } = toRefs(data);
</script>

<style scoped></style>
