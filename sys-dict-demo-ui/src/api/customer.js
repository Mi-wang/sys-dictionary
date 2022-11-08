import {get, postForm, putForm} from "@/utils/api";

export function listData(params) {
  return get('/customer', params)
}

export function update(params) {
  return putForm('/customer', params)
}

export function save(params) {
  return postForm('/customer', params)
}
