<script>
import axios from "axios";

export default {
  name: 'main_map',
  data() {
    return {
      api: 'https://restapi.amap.com/v3/config/district?keywords=%E6%B3%89%E5%B7%9E&subdistrict=2&key=0387c06d226fd06d368add15c6eee057&extensions=all',
      map: {
        "type": "FeatureCollection",
        "features": []
      },
      get_ready: false,
    }
  },
  mounted() {
    let polygons;
    axios.get(this.api).then((res) => {
      console.log(res.data);
      let i, j;
      polygons = res.data.districts[0].polyline.split('|');
      for (i = 0; i < polygons.length; i++) {
        polygons[i] = polygons[i].split(';');
      }
      for (i = 0; i < polygons.length; i++) {
        for (j = 0; j < polygons[i].length; j++) {
          polygons[i][j] = polygons[i][j].split(',');
        }
      }
      // TODO:解析数据
      this.map.features.push(
          {
            "type": "Feature",
            "properties": {
              "adcode": res.data.districts[0].adcode,
              "name": res.data.districts[0].name,
              "center": res.data.districts[0].center.split(','),
              "parent": {
                "adcode": Math.floor(res.data.districts[0].adcode / 1000) * 1000
              },
              "acroutes": [
                100000,
                Math.floor(res.data.districts[0].adcode / 1000) * 1000,
                res.data.districts[0].adcode
              ]
            },
            "geometry": {
              "type": "MultiPolygon",
              "coordinates": polygons
            }
          }
      )
      this.get_ready = true;
    })
  },
  updated() {
    if (this.get_ready){
      let i,j;
      let polygons = this.map.features[0].geometry.coordinates;
      console.log("ready");
      console.log(this.map);
      console.log(polygons);
      let canvas = document.getElementById('test-canvas');
      let ctx = canvas.getContext('2d');
      ctx.fillStyle = "orangered";
      ctx.fillRect(0, 0, 1200, 800);
      for (i = 0; i < polygons.length; i++) {
        ctx.moveTo(polygons[i][0][0], polygons[i][0][1]);
        for (j = 1; j < polygons[i].length - 1; j++) {
          ctx.lineTo(polygons[i][j][0], polygons[i][j][1]);
          ctx.moveTo(polygons[i][j][0], polygons[i][j][1]);
        }
        ctx.lineTo(polygons[i][polygons[i].length - 1][0],
            polygons[i][polygons[i].length - 1][1]);
      }
      ctx.strokeStyle = "yellowgreen";
      ctx.lineWidth = 2;
      ctx.stroke()
    }
  },
  methods: {
  }
}

</script>

<template>
  <div style="height: 800px;width: 1200px;border: hotpink solid 2px;border-radius: 10px">
    <canvas id="test-canvas"/>
  </div>

</template>

<style scoped>
#test-canvas {
  margin: 0;
  padding: 0;
  border: 0;
  width: 100%;
  height: 100%;
  background-color: yellow;
}

</style>