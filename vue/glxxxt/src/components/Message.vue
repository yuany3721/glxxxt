<template>
    <div v-if="isview">
        <el-table :data="msgs">
            <el-table-column prop="title" label="标题" width="180px"> </el-table-column>
            <el-table-column prop="content" label="留言内容"> </el-table-column>
            <el-table-column prop="date" label="留言时间" width="180px"> </el-table-column>
        </el-table>
        <br />
        <br />
        <el-button type="primary" :loading="isBack" @click="isview = false">
            返回
            <i class="el-icon-house el-icon--right"></i>
        </el-button>
    </div>
    <div v-else>
        <el-button type="primary" :loading="isBack" @click="view"> 查看当前留言 </el-button>
        <br /><br />
        <el-input v-model="input" placeholder="留言标题"></el-input>
        <br />
        <el-input type="textarea" :rows="2" placeholder="请输入留言内容" v-model="textarea"> </el-input>
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
    </div>
</template>

<script>
export default {
    name: "Message",
};
</script>

<script setup>
import { reactive, getCurrentInstance, toRefs } from "vue";
import router from "../router";
const { proxy } = getCurrentInstance();

const data = reactive({
    input: "",
    textarea: "",
    isloading: false,
    isBack: false,
    isview: false,
    msgs: [],
});

function submit() {
    //购买单
    data.isloading = true;
    window.setTimeout(() => {
        proxy.$http
            .post("addMessage", {
                title: data.input,
                content: data.textarea,
            })
            .then((res) => {
                //console.log(res);
                if (res.data == 1) {
                    alert("留言成功！");
                    router.push("/");
                } else {
                    alert("留言失败！");
                    data.isloading = false;
                }
            })
            .catch(function () {
                console.log("%c error in adding message", "color:red;");
            });
    });
}

function backToHome() {
    data.isBack = true;
    window.setTimeout(() => {
        data.isloading = false;
        data.isBack = false;
        data.isContinue = false;
        router.push("/");
    }, 2000);
}

function view() {
    data.isview = true;
    window.setTimeout(() => {
        proxy.$http
            .get("/getAllMessage")
            .then((res) => {
                // console.log(res);
                data.msgs = res.data;
            })
            .catch(function () {
                console.log("%c error in getting message", "color:red;");
            });
    });
}

const { input, textarea, isloading, isBack, isview, msgs } = toRefs(data);
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
