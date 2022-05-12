<template>
    <div id="menu">
        <div class="title">菜单</div>
        <el-table :data="menu" ref="filterTable" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"> </el-table-column>
            <el-table-column prop="dishes" label="菜品名称" width="180px"> </el-table-column>
            <el-table-column prop="price" label="价格（元）" width="180px"> </el-table-column>
            <el-table-column
                prop="type"
                label="类型"
                width="100"
                :filters="[
                    { text: '锅底', value: '锅底' },
                    { text: '火锅菜', value: '火锅菜' },
                    { text: '炒菜', value: '炒菜' },
                    { text: '酒水饮料', value: '酒水饮料' },
                    { text: '主食', value: '主食' },
                ]"
                :filter-method="filterTag"
                filter-placement="bottom-end"
            >
                <template #default="scope">
                    <el-tag
                        :type="
                            scope.row.type === '锅底'
                                ? 'primary'
                                : scope.row.type === '火锅菜'
                                ? 'success'
                                : scope.row.type === '炒菜'
                                ? 'info'
                                : scope.row.type === '酒水饮料'
                                ? 'warning'
                                : ''
                        "
                        disable-transitions
                        >{{ scope.row.type }}</el-tag
                    >
                </template>
            </el-table-column>
        </el-table>
    </div>
    <div class="leftalign title">当前点菜列表：</div>
    <el-row>
        <el-col :span="3" v-if="noselected">
            <div class="grid-content bg-primary">暂无选中</div>
        </el-col>
        <el-col :span="3" v-for="(select, index) in menu_selected" :key="index">
            <div class="grid-content bg-primary">
                {{ select.dishes }}
            </div>
        </el-col>
    </el-row>
    <div class="leftalign title">当前共计：{{ price }} 元</div>
    <div id="submitmenu">
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

        <br />
        <br />
        <br />
    </div>
</template>

<script type="text/javascript">
export default {
    name: "Menu",
};
</script>

<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs } from "vue";
import router from "../router";
const { proxy } = getCurrentInstance();
const data = reactive({
    menu: [],
    menu_selected: [],
    noselected: true,
    price: 0,
    isloading: false,
    isBack: false,
});

function getMenu() {
    //获取菜单
    proxy.$http
        .get("/getMenu")
        .then((res) => {
            //console.log(res);
            data.menu = res.data;
        })
        .catch(function () {
            console.log("%c error in getting menu", "color:red;");
        });
}

function filterTag(value, row) {
    return row.type === value;
}

function handleSelectionChange(val) {
    //刷新菜单选中状态
    data.menu_selected = [];
    data.price = 0;
    data.menu_selected = val;
    for (let i = 0; i < val.length; i++) {
        data.price += val[i].price;
    }
    if (data.menu_selected.length == 0) {
        data.noselected = true;
    } else {
        data.noselected = false;
    }
}

function submit() {
    data.isloading = true;
    window.setTimeout(() => {
        router.push({
            name: "Cook",
            params: {
                order: JSON.stringify(data.menu_selected),
            },
        });
    }, 2000);
}

function backToHome() {
    data.isBack = true;
    window.setTimeout(() => {
        data.isBack = false;
        router.push("/");
    }, 2000);
}

onMounted(() => {
    getMenu();
});

const { menu, menu_selected, noselected, price, isloading, isBack } = toRefs(data);
</script>

<style scoped>
.title {
    margin: 5px;
    font-weight: bolder;
}
.leftalign {
    text-align: left;
}
.bg-primary {
    background-color: #ecf5ff;
    border-color: #d9ecff;
}

.grid-content {
    border-radius: 5px;
    min-height: 26px;
    margin: 5px;
    line-height: 36px;
}
#submitmenu {
    align-self: left;
}
@media screen and (min-width: 992px) {
    #Menu {
        /* width: 65%; */
        text-align: center;
        margin: 0 auto;
        /* background-color: rgba(0, 0, 0, 0.05); */
    }
}
</style>
