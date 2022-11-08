import {deleteForm, get, postForm, putForm} from "@/utils/api";

export function deleteById(id) {
  return deleteForm(`/dict/items/${id}`)
}

export function listData(params) {
  return get('/dict/items', params)
}

export function listByType(type) {
  return get(`/dict/items/${type}`)
}
export function update(params) {
  return putForm('/dict/items', params)
}

export function save(params) {
  return postForm('/dict/items', params)
}
