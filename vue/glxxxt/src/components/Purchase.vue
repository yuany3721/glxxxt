<template>
    <template v-if="isPurchase">
        <h1>采购单</h1>

        <el-select v-model="value" placeholder="请选择采购内容" filterable>
            <el-option v-for="item in options" :key="item.name" :label="item.name" :value="item.id"> </el-option>
        </el-select>

        数量：<el-input-number v-model="num" :precision="2" :step="0.01"></el-input-number>

        单价：<el-input-number v-model="price" :precision="2" :step="0.01"></el-input-number>

        <br />
        <br />

        <el-button type="primary" :loading="isloading" @click="submit">
            提交
            <i class="el-icon-check el-icon--right"></i>
        </el-button>
        <br />
        <br />
        <el-button type="primary" :loading="isBack" @click="backToHome">
            返回
            <i class="el-icon-house el-icon--right"></i>
        </el-button>
    </template>
    <template v-else>
        <el-button type="primary" :loading="isContinue" @click="backToPurchase">
            继续填写进货单
            <i class="el-icon-chicken el-icon--right"></i>
        </el-button>

        <br />
        <br />

        <el-button type="primary" :loading="isBack" @click="backToHome">
            返回
            <i class="el-icon-house el-icon--right"></i>
        </el-button>
    </template>
</template>

<script>
export default {
    name: "Purchase",
};
</script>

<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs } from "vue";
import router from "../router";
const { proxy } = getCurrentInstance();

let data = reactive({
    options: [],
    value: "",
    num: 0,
    price: 0,
    isloading: false,
    isBack: false,
    isContinue: false,
    isPurchase: true,
});

function backToHome() {
    data.isBack = true;
    window.setTimeout(() => {
        data.isloading = false;
        data.isBack = false;
        data.isContinue = false;
        router.push("/");
    }, 2000);
}

function backToPurchase() {
    data.isContinue = true;
    window.setTimeout(() => {
        data.isloading = false;
        data.isBack = false;
        data.isContinue = false;
        data.isPurchase = true;
        data.value = "";
        data.num = 0;
        data.price = 0;
    }, 2000);
}

function submit() {
    //购买单
    data.isloading = true;
    window.setTimeout(() => {
        proxy.$http
            .post("purchase", {
                id: data.value,
                price: data.price,
                quantity: data.num,
            })
            .then((res) => {
                // console.log(res);
            })
            .catch(function () {
                console.log("%c error in confirming the purchase", "color:red;");
            });
        let param2 = new URLSearchParams();
        param2.append("id", data.value);
        param2.append("addnum", data.num);
        proxy.$http
            .post("addIngredient", param2)
            .then((res) => {
                //console.log(res)
            })
            .catch(function () {
                console.log("%c error in adding ingredient", "color:red;");
            });
        data.isloading = false;
        data.isBack = false;
        data.isContinue = false;
        data.isPurchase = false;
    }, 2000);
}

function getIngredient() {
    //获取材料列表
    proxy.$http
        .get("getIngredient")
        .then((res) => {
            // console.log(res);
            data.options = res.data;
            // console.log(this.options);
        })
        .catch(function () {
            console.log("%c error in getting ingredient", "color:red;");
        });
}

onMounted(() => {
    getIngredient();
    // console.log("purchase");
});

const { options, value, num, price, isloading, isBack, isContinue, isPurchase } = toRefs(data);
</script>

<style scoped></style>
