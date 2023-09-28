<script>

// import map_chart from "@/components/map_chart.vue";
import main_header from "@/components/main_header.vue";
import main_map from "@/components/main_map.vue";


export default {
  data() {

  },
  components: {
    main_map,
    // map_chart,
    main_header
  },
}


</script>

<template id="app">

  <el-container style="height: 100%">
    <el-header height="80px">
      <main_header />
    </el-header>

    <el-container>

      <el-main class="test" style="background-color: blue">
        <main_map />
        <!--        <map_chart />-->
      </el-main>

      <el-aside class="test" width="200px" style="background-color: yellow">


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

html{
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

.test {
  border-radius: 10px;
  margin: 4px;
}
</style>
