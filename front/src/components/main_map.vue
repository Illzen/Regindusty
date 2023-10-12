<script>
import * as echarts from "echarts";

export default {
  name: 'main_map',
  data() {
    return {
      api: 'https://restapi.amap.com/v3/config/district?keywords=%E6%B3%89%E5%B7%9E&subdistrict=2&key=0387c06d226fd06d368add15c6eee057&extensions=all',
      local_api: '/areas_v3/bound/350000_full.json',
      datav_api: {
        front: '/areas_v3/bound/',
        adcode: '100000',
        back: '_full.json'
      },
      map: {
        "type": "FeatureCollection",
        "features": []
      },
      max_longitude: 0,
      min_longitude: 0,
      max_latitude: 0,
      min_latitude: 0,
    }
  },
  mounted() {
    this.axios.get('/datav' + this.datav_api.front + this.datav_api.adcode + this.datav_api.back).then((res) => {
      // this.map.features.push(this.parse(res.data))

      console.log(res);
      this.map = res.data;
      echarts.registerMap('ali_map', JSON.parse(JSON.stringify(this.map)));


      const map_chart = echarts.init(document.getElementById("body"))
      console.log(res.data.features[12].properties.center);
      map_chart.setOption({
        title: {
          text: '乡镇特色产业图',
          subtext: 'Data from Wikipedia',
          textStyle: {
            color: 'yellow',

          },
          top: 30,
          left: 30,
          shadowBlur: 10,
          shadowColor: 'gray',
        },
        geo: {
          show: true,
          map: 'ali_map',
          center: res.data.features[12].properties.center,
          roam:true,
          label: {
            show: true,
            overFlow: 'break',
            ellipsis: ''
          },
          zoom: 10,
          visualMap: {
            min: 1000,
            max: 100000,
            text: "搜索热度",
            realtime: true,
            inRange: {
              color: ['lightskyblue', 'yellow', 'orangered']
            }
          }
        },
      });
      this.axios.get('datav' + this.datav_api.front + '350000' + this.datav_api.back).then((res) => {
        console.log(res.data);
        for (var e = 0; e < res.data.features.length; e++) {
          this.axios.get('datav' + this.datav_api.front + String(res.data.features[e].properties.adcode) + this.datav_api.back).then((res) => {
            console.log(res.data);
          })
        }

      })


    })
  },
  methods: {

    set_api(api, target) {

      api += target;

      return api;

    },

    //解析通过高德地图api获取的数据
    parse(data) {
      let i, j;

      let polygons = data.districts[0].polyline.split('|');
      for (i = 0; i < polygons.length; i++) {
        polygons[i] = polygons[i].split(';');
      }
      for (i = 0; i < polygons.length; i++) {
        for (j = 0; j < polygons[i].length; j++) {
          polygons[i][j] = polygons[i][j].split(',');
          polygons[i][j][0] = Number(polygons[i][j][0]);
          polygons[i][j][1] = Number(polygons[i][j][1]);
        }
      }

      this.location(polygons);

      return JSON.parse(JSON.stringify({
        "type": "Feature",
        "properties": {
          "adcode": data.districts[0].adcode,
          "name": data.districts[0].name,
          "center": data.districts[0].center.split(','),
          "level": "district",
          "parent": {
            "adcode": Math.floor(data.districts[0].adcode / 1000) * 1000
          },
          "acroutes": [
            100000,
            Math.floor(data.districts[0].adcode / 1000) * 1000,
            data.districts[0].adcode
          ]
        },
        "geometry": {
          "type": "MultiPolygon",
          "coordinates": polygons
        }
      }))
    },

    location(polygons) {
      let i, j;

      this.min_longitude = this.max_longitude = polygons[0][0][0];
      this.min_latitude = this.max_latitude = polygons[0][0][1];

      for (i = 0; i < polygons.length; i++) {
        for (j = 0; j < polygons[i].length; j++) {
          if (this.min_longitude > polygons[i][j][0]) {
            this.min_longitude = polygons[i][j][0]
          } else if (this.max_longitude < polygons[i][j][0]) {
            this.max_longitude = polygons[i][j][0]
          }
          if (this.min_latitude > polygons[i][j][1]) {
            this.min_latitude = polygons[i][j][1]
          } else if (this.max_latitude < polygons[i][j][1]) {
            this.max_latitude = polygons[i][j][1]
          }
        }
      }

      console.log("max x = " + this.max_longitude + '\n' +
          "min x = " + this.min_longitude + '\n' +
          "max y = " + this.max_latitude + '\n' +
          "min y = " + this.min_latitude + '\n');

    }
  }
}

</script>

<template>
  <div id="body" style="background-color: hotpink" />
</template>

<style scoped>

#body{
  width: 100%;
  height: 100%;
}

</style>