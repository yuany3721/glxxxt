<template>
    <img src="../assets/404.jpg" alt="404" />
    <br />
    <el-button type="primary" round @click="back">返回</el-button>
</template>

<script>
export default {
    name: "NotFound",
    methods: {
        back() {
            this.$router.go(-1);
        },
    },
};
</script>

<style scoped>
img {
    max-width: 80%;
    margin-top: 50px;
}
</style>
