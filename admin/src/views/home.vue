<template>
  <div
    class="content"
    :style="{
      minHeight: '100vh',
      padding: '20px 30px 20px',
      alignItems: 'flex-start',
      flexWrap: 'wrap',
    //   background: 'url(http://codegen.caihongy.cn/20231106/fcced3ef2baf48959dd536334731b0a6.png) no-repeat center top / cover,#ff8b1e',
      display: 'block',
      fontSize: '14px',
      height: 'auto',
    }"
  >
    <!-- notice -->
    <!-- title -->
    <div
      class="text"
      :style="{
        margin: '20px auto 40px',
        color: '#000',
        textAlign: 'center',
        display: 'block',
        width: '100%',
        fontSize: '30px',
        fontWeight: '500',
      }"
    >
      欢迎使用 {{ this.$project.projectName }}
    </div>

    <!-- echarts -->
  </div>
</template>
<script>
//0
import router from "@/router/router-static";
import * as echarts from "echarts";
export default {
  data() {
    return {};
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      if (this.$storage.get("Token")) {
        this.$http({
          url: `${this.$storage.get("sessionTable")}/session`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code != 0) {
            router.push({ name: "login" });
          }
        });
      } else {
        router.push({ name: "login" });
      }
    },
  },
};
</script>
<style lang="scss" scoped>
.cardView {
  display: flex;
  flex-wrap: wrap;
  width: 100%;

  .cards {
    display: flex;
    align-items: center;
    width: 100%;
    margin-bottom: 10px;
    justify-content: center;
    .card {
      width: calc(25% - 20px);
      margin: 0 10px;
      /deep/.el-card__body {
        padding: 0;
      }
    }
  }
}

// 日历
.calendar td .text {
  border: 0px solid rgba(93, 213, 200, 0.2);
  border-radius: 4px;
  flex-direction: column;
  color: #888;
  background: rgba(114, 123, 132, 0.05);
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 100%;
}
.calendar td .text:hover {
  background: rgba(114, 123, 132, 0.05);
}
.calendar td .text .new {
  color: inherit;
  font-size: inherit;
  line-height: 1.4;
}
.calendar td .text .old {
  color: inherit;
  font-size: inherit;
  line-height: 1.4;
}
.calendar td.festival .text {
  border: 0px solid rgba(93, 213, 200, 0.1);
  border-radius: 4px;
  flex-direction: column;
  color: #000;
  background: #d4b99b;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 100%;
}
.calendar td.festival .text:hover {
  background: #d4b99b;
}
.calendar td.festival .text .new {
  color: inherit;
  font-size: inherit;
  line-height: 1.4;
}
.calendar td.festival .text .old {
  color: inherit;
  font-size: inherit;
  line-height: 1.4;
}
.calendar td.other .text {
  border-radius: 20px;
  flex-direction: column;
  background: none;
  display: flex;
  width: 100%;
  font-size: inherit;
  justify-content: center;
  align-items: center;
  opacity: 0.6;
  height: 100%;
}
.calendar td.other .text:hover {
  background: none;
}
.calendar td.other .text .new {
  color: #000;
  font-size: inherit;
  line-height: 1.4;
}
.calendar td.other .text .old {
  color: #666;
  font-size: inherit;
  line-height: 1.4;
}
.calendar td.today .text {
  border-radius: 4px;
  flex-direction: column;
  color: #000;
  background: #f6d346;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 100%;
}
.calendar td.today .text:hover {
  background: #f6d346;
}
.calendar td.today .text .new {
  font-size: inherit;
  line-height: 1.4;
}
.calendar td.today .text .old {
  font-size: inherit;
  line-height: 1.4;
}

// echarts1
.type1 .echarts1 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 100%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type1 .echarts1:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
// echarts2
.type2 .echarts1 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type2 .echarts1:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type2 .echarts2 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type2 .echarts2:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
// echarts3
.type3 .echarts1 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0 0 30px;
  color: #333;
  background: rgba(255, 255, 255, 0.96);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type3 .echarts1:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type3 .echarts2 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type3 .echarts2:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type3 .echarts3 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 100%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type3 .echarts3:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
// echarts4
.type4 .echarts1 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type4 .echarts1:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type4 .echarts2 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type4 .echarts2:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type4 .echarts3 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type4 .echarts3:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type4 .echarts4 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type4 .echarts4:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
// echarts5
.type5 .echarts1 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 0.96);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type5 .echarts1:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type5 .echarts2 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}
.type5 .echarts2:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type5 .echarts3 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 100%;
  position: relative;
  transition: 0.3s;
  height: 360px;
}
.type5 .echarts3:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type5 .echarts4 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 360px;
}
.type5 .echarts4:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}
.type5 .echarts5 {
  border: 0px solid #bababa;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);
  margin: 0px 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 360px;
}
.type5 .echarts5:hover {
  box-shadow: 0 1px 10px 1px rgba(115, 108, 203, 0.1);
  transform: translate3d(0, 0px, 0);
  z-index: 1;
}

.echarts-flag-2 {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  padding: 10px 20px;
  background: rebeccapurple;

  & > div {
    width: 32%;
    height: 300px;
    margin: 10px 0;
    background: rgba(255, 255, 255, 0.1);
    border-radius: 8px;
    padding: 10px 20px;
  }
}
</style>
