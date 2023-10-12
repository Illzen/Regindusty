const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        proxy: {
            // https://geo.datav.aliyun.com/areas_v3/bound/350500_full.json
            '/datav': {
                target: 'https://geo.datav.aliyun.com/',
                changeOrigin: true,
                secure: false,
                pathRewrite: {
                    '^/datav': ''
                }
            }
        }
    }
})
