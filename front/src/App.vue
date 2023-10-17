<script>

// import map_chart from "@/components/map_chart.vue";
import main_header from "@/components/main_header.vue";
import main_map from "@/components/main_map.vue";


export default {
  data() {

  },
  components: {
    main_map,
    main_header
  },
}


</script>
<title>
    基于知识图谱的乡村产业振兴信息平台开发与应用
  </title>
<template id="app">
  
  <el-container style="height: 100%">
    <el-header height="80px">
      <main_header/>
    </el-header>

    <el-container direction="horizontal">

      <el-main style="padding: 0;margin: 0">
        <el-container direction="horizontal">
          <el-container direction="vertical">
            <el-main class="map-chart">
              <main_map/>
            </el-main>
            <el-container direction="horizontal">

            </el-container>
          </el-container>
          <el-container direction="vertical">

          </el-container>
        </el-container>
      </el-main>

      <el-aside width="200px" style="background-color: yellow">

      </el-aside>

    </el-container>

  </el-container>

</template>

<style>
body {
  height: 100%;
  width: 100%;
  margin: 0;
}

html {
  height: 100%;
  width: 100%;
}

#app {
  height: 100%;
  width: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0;
  z-index: 9;
  background: rgba(5, 11, 22, 1) url(./assets/images/bg.png) no-repeat;
  background-size: 100% 100%;
}

.map-chart{
  height: 450px;
  width: 600px;
}

</style>
