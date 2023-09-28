<script>

import axios from "axios";
import * as  echarts from 'echarts'


let ali_api = 'https://restapi.amap.com/v3/config/district?keywords=%E6%B3%89%E5%B7%9E&subdistrict=2&key=0387c06d226fd06d368add15c6eee057&extensions=all'
// let api = 'https://geojson.cn/api/data/350000.json'


export default {
  name: "map_chart",
  beforeCreate() {
    let ali_map = get_map(ali_api);
    ali_map = JSON.stringify(ali_map);
    // let map = JSON.stringify(axios.get(api).then((res) => {
    //   console.log(res);
    // }))
    // echarts.registerMap('map', {geoJSON: map});
    echarts.registerMap('ali_map', {geoJSON: ali_map});
  },
  mounted() {
    const chart_map = echarts.init(document.getElementById('map-chart'));
    chart_map.setOption({
      title: {
        text: "Map_Title"
      },
      series: [{
        type: 'map',
        map: 'ali_map',
        roam: true,
        boundingCoords: [
          // 定位左上角经纬度
          [-180, 90],
          // 定位右下角经纬度
          [180, -90]
        ],
      }],

    });
  },
  methods: {
    get_map(api) {
      axios.get(api).then((response) => {
        var i;
        var res = {
          "type": "FeatureCollection",
          "features": []
        };
        var data = response.data;
        console.log(data);
        var str = data.districts[0].polyline;
        var polygons = str.split('|');
        var polygon = [];
        for (i = 0; i < polygons.length; i++) {
          polygon.push(polygons[i].split(';'),);
        }
        for (i = 0; i < polygon.length; i++) {
          res.features.push({
            "type": "Feature",
            "properties": {},
            "geometry": {
              "type": "Polygon",
              "coordinates": polygon[i],
            }
          })
        }
        console.log(res);
        return res;
      })
    }
  }
}
</script>

<template>

  <div>
    <div id="my-map">
    </div>
    <div id="ali-map">
    </div>
  </div>

</template>

<style scoped>

#my-map {
  height: 90%;
  width: 72%;
  background-color: red;
}
#ali-map {
  height: 90%;
  width: 72%;
  background-color: red;
}

</style>