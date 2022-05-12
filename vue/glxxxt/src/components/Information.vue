<template>
    <div class="title bg-primary grid-content" @click.native="abstract">
        <span>简介</span>
    </div>
    <div class="title bg-primary grid-content" @click.native="ywlct">
        <span>业务流程图</span>
    </div>
    <div class="title bg-primary grid-content" @click.native="sjlct">
        <span>数据流程图</span>
    </div>
    <div class="title bg-primary grid-content" @click.native="closelct">
        <span>关闭流程图、简介</span>
    </div>
    <div>
        <div v-if="view1">
            <br />
            <img src="../assets/MIS_业务流程图.png" alt="业务流程图" />
        </div>
        <div v-if="view2">
            <br />
            <img src="../assets/MIS_数据流程图.png" alt="数据流程图" />
        </div>
        <div v-if="view3">
            <br />
            <h1>简介</h1>
            <p>
                目前餐厅管理行业中高级管理人员匮乏，低级工作人员效率过低，工作量无法做到平均分担，同时中小型企业运行成本过高，大部分企业无法承担。在服务方面，由于服务人员的精力有限,不仅无法将有限的工作时间科学有效的利用,还会可能导致服务人员的过度劳累。开发此系统,将所有的管理流程智能化,给餐厅管理者减轻经营负担。
            </p>
            <br>
            <h1>主要功能</h1>
            <p>
                运营火锅店的主要模块为点餐,出餐,人员服务,物料采购等,本系统可以将这些功能模块化,中心管理系统采用面向特定应用集成电路(ASIC),将一切运营电子化,流程化。主要功能如下：
                <ol>
                    <li>顾客点餐,系统会根据物料存储,判断是否可以出餐,确定出餐后,同时给后厨和物料储备发出指令,实时更新储备,及时出餐</li>
                    <li>每个服务员配备指示器,系统根据用户服务要求及时指派空闲服务员,平根据员工完成情况,效率等,定期进行员工评测</li>
                    <li>员工配备指示器,不仅是提高工作效率,进行测评,还可以防止过度劳累,或工作安排不公,消除潜在的劳动纠纷</li>
                    <li>火锅店的主要由系统运营,可以实时监控店内各处情况,排除潜在危险</li>
                    <li>所有点餐情况都被记录在数据库内,系统会定期进行数据分析挖掘,判断不同类特定用户的点餐习惯,形成关联规则,在点餐界面进行推送,提高销售率</li>
                    <li>员工会对用户需求及时作出反应,提高用户的消费体验,提升用户的再选择率</li>
                    <li>系统操作简单,只需要简单的数据录入,就可以实行,减少高昂的学习费用,也可以减少大量的员工培训费用,大大降低运行成本,存在很高的市场价值</li>
                </ol>
            </p>
        </div>
    </div>
</template>

<script type="text/javascript">
export default {
    name: "Information",
};
</script>

<script setup>
import { reactive, toRefs } from "vue";

const data = reactive({
    view1: false,
    view2: false,
    view3: false,
});

function sjlct() {
    data.view1 = true;
    data.view2 = false;
    data.view3 = false;
}

function ywlct() {
    data.view2 = true;
    data.view1 = false;
    data.view3 = false;
}

function abstract() {
    data.view1 = false;
    data.view2 = false;
    data.view3 = true;
}

function closelct() {
    data.view1 = false;
    data.view2 = false;
    data.view3 = false;
}

const { view1, view2, view3 } = toRefs(data);
</script>

<style scoped>
.title {
    margin: 5px;
}
.bg-primary {
    background-color: #409eff;
    border-color: #49ecff;
}

.grid-content {
    display: inline-block;
    cursor: pointer;
    border-radius: 5px;
    min-height: 26px;
    margin: 10px;
    line-height: 36px;
    padding: 5px 10px;
}
p {
    text-align: left;
    text-indent: 2em;
    font-size: 18px;
}
ol{
    text-align: left;
}
</style>
