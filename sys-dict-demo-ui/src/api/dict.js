import {deleteForm, get, postForm, putForm} from "@/utils/api";

export function deleteById(id) {
  return deleteForm(`/dict/types/${id}`)
}

export function listData(params) {
  return get('/dict/types', params)
}

export function getByType(type) {
  return get(`/dict/types/${type}`)
}

export function update(params) {
  return putForm('/dict/types', params)
}

export function save(params) {
  return postForm('/dict/types', params)
}
