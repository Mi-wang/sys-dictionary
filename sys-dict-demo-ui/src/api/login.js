import {get, postForm} from "@/utils/api-mock";

export function login(params) {
    return postForm(`/vue-wolfcode-template/user/login`, params)
}

export function logout() {
  return postForm(`/vue-wolfcode-template/user/logout`)
}

export function getInfo(token) {
  return get(`/vue-wolfcode-template/user/info`, {token})
}
