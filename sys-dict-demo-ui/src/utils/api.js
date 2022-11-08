import request from "@/utils/request";
import qs from 'qs'

const BASE_API = process.env.VUE_APP_BASE_API

/**
 * get 请求封装
 * @param url 请求 url 地址
 * @param params  请求参数
 * @param config  axios 配置对象
 */
export function get(url, params, config) {
  /**
   * axios 中的 get 方法
   *  get:
   *    第一个参数: url 地址
   *    第二个参数: config 对象
   */
  return request.get(`${BASE_API}${url}`, {
    params, // 参数
    paramsSerializer: params => {
      // 参数序列化为表单格式 a=b&c=d
      return qs.stringify(params, {indices: false})
    },
    ...config
  })
}

/**
 * 发送 post 请求，参数为 json 格式
 * @param url 请求 url 地址
 * @param params  请求参数（json 格式）
 * @param config  axios 配置对象
 */
export function postJson(url, params, config) {
  /**
   * axios 的 post 方法
   *  post:
   *    第一个参数: uri 地址
   *    第二个参数: 参数对象
   *      json 类型: {key: value, key2: value}
   *      字符串类型: key=value&key2=value
   *    第三个参数: config 对象
   *  post(uri, {key: value, ...}, {headers: {'xxx': 'xxx'}})
   */
  return request.post(`${BASE_API}${url}`, params, config)
}

/**
 * 发送 post 请求，参数为表单类型
 * @param url 请求 url 地址
 * @param params  请求参数（json 格式）
 * @param config  axios 配置对象
 */
/*export function postForm(url, params, config) {
  return request.post(`${BASE_API}${url}`, qs.stringify(params, {indices: false}), {
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    ...config
  })
}*/

export function postForm(url, params, config) {
  return form('POST', url, params, config)
}

export function putForm(url, params, config) {
  return form('PUT', url, params, config)
}

export function patchForm(url, params, config) {
  return form('PATCH', url, params, config)
}

export function deleteForm(url, params, config) {
  return form('DELETE', url, params, config)
}

export function form(method, url, params, config) {
  // 发送 axios 请求, 直接通过配置的方式发请求
  return request({
    method,
    url: `${BASE_API}${url}`,
    headers: {'content-type': 'application/x-www-form-urlencoded'},
    // data 只能是 post/put/delete 等类型的方法才可以使用
    // params 是给 get 方法使用
    data: qs.stringify(params, {indices: false}),
    ...config
  })
}
