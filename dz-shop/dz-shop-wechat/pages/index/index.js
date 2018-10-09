//index.js
var api = require('../../config/api.js');
//获取应用实例
const app = getApp()

//导入js
//网络访问
function getRecommend(callback) {
  wx.request({
    url: api.Image +"main/slideshow",
    data: {
      g_tk: 5381,
      uin: 0,
      format: 'json',
      inCharset: 'utf-8',
      outCharset: 'utf-8',
      notice: 0,
      platform: 'h5',
      needNewCode: 1,
      _: Date.now()
    },
    method: 'GET',
    header: { 'content-Type': 'application/json' },
    success: function (res) {
      if (res.statusCode == 200) {
        callback(res.data);
      }
    }
  })
}

module.exports = {
  getRecommend: getRecommend
}

Page({
  data: {
    slider: [],
    swiperCurrent: 0
  },
  onLoad: function () {
    var that = this;
    //网络访问，获取轮播图的图片
    getRecommend(function (data) {
      that.setData({
        slider: data
      })
    });
  },
  //轮播图的切换事件
  swiperChange: function (e) {
    //只要把切换后当前的index传给<swiper>组件的current属性即可
    this.setData({
      swiperCurrent: e.detail.current
    })
  },
  //点击指示点切换
  chuangEvent: function (e) {
    this.setData({
      swiperCurrent: e.currentTarget.id
    })
  }
})
