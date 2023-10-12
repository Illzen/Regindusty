import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import VueAxios from "vue-axios";
import axios from "axios";

const app = createApp(App)
app.use(ElementPlus)
app.use(VueAxios,axios)
app.mount('#app')

/**
 *
 * @param {*} id
 * @param {*} animations
 * 声明初始值
 * 判断动画是否结束
 */
export function playAnimation (id, animations) {
    let index = 0;
    const ele = document.querySelector(id);
    setAnimation(ele, animations[index]);
    ele.addEventListener('webkitAnimationEnd', function () {
        if (index < animations.length - 1) {
            index++;
            setAnimation(ele, animations[index]);
        }
    })
}

/**
 *
 * @param {*} element
 * @param {*} animation
 * 取index对应的动画
 * 给元素animation重新赋值
 */
export function setAnimation (element, animation) {
    const action = `${animation.duration * 1000}ms ease ${animation.delayed * 1000}ms ${
        animation.loop ? 'infinite' : animation.frequency
    } normal both running ${animation.type}`;
    element.style.animation = action;
}


