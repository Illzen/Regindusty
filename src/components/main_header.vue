<script>

import {playAnimation} from "@/main";

const header_anime = [{
  type: 'fadeInDown',
  name: 'header_anime',
  delayed: 0,
  loop: false,
  frequency: 1,
  duration: 1,
  isPlayer: false,
  isDisabled: false
}]

export default {
  name: "main_header",
  mounted() {
    this.$nextTick(() => {
      playAnimation('#header-body', header_anime)
    })

  }
}
</script>

<template>

  <div id="header-body">
    <div id="header_title">
      this is test title
    </div>
    <img src="../assets/images/top.png" id="header-image" alt=""/>
  </div>

</template>

<style scoped>

#header-body {
  height: 100%;
  width: 100%;
  padding: 0;
  margin: 0;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

#header_title {
  position: absolute;
  top: 14px;
  height: 40px;
  margin: 10px 0 0;
  text-align: center;
  font-size: 26px;
  width: auto !important;
  transform: rotate(0deg) !important;
  color: #00E3FE !important;
}

#header-image {
  position: absolute;
  top: 27px;
  width: 100%;
  height: 50px;
  z-index: 1;
  opacity: 1;
  transform: rotate(0deg);
  background: rgba(255, 255, 255, 0);
  border: 0 solid #2ed64a;
  border-radius: 0;
  margin: 0;
  padding: 0;
}

</style>