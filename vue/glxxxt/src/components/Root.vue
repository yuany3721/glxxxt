<template>
    <div class="info" v-if="isneeded">
        当前缺少食材：
        <span v-for="(ingredient, index) in ingredients" :key="index"> <br />{{ ingredient.name }} </span>
    </div>
    <div class="info" v-else>当前不缺少食材</div>
</template>

<script>
export default {
    name: "Root",
};
</script>

<script setup>
import { reactive, getCurrentInstance, onMounted, toRefs } from "vue";
const { proxy } = getCurrentInstance();

let data = reactive({
    isneeded: true,
    ingredients: [],
});

function getNeeded() {
    proxy.$http
        .get("/getNeededIngredient")
        .then((res) => {
            // console.log(res);
            data.ingredients = res.data;
            if (data.ingredients.length == 0) {
                data.isneeded = false;
            }
        })
        .catch(function () {
            console.log("%c error in getting needed", "color:red;");
        });
}

onMounted(() => {
    getNeeded();
});

const { isneeded, ingredients } = toRefs(data);
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.box {
    display: flex;
    flex-flow: row wrap;
    justify-content: flex-start;
    align-items: center;
    align-content: flex-start;
}
.item {
    margin: 10px;
    flex: auto;
}
.info {
    padding: 20px;
    font: 20px bolder;
}
</style>
