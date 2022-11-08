<template>
  <!-- 在 template 中有且仅有一个根节点 -->
  <div class="app-container">
    <!--查询表单-->
    <el-form :inline="true" size="mini" :model="searchForm" class="demo-form-inline">
      <el-form-item label="关键字">
        <el-input v-model="searchForm.keyword" placeholder="请输入关键字"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button icon="el-icon-plus" @click="handleAdd">新增</el-button>
      </el-form-item>
    </el-form>
    <!--  数据表格  -->
    <el-table
      v-loading="loading"
      stripe
      :data="tableData"
      style="width: 100%">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="type" label="类型">
        <template v-slot="scope">
          <router-link class="el-button--text" :to=" `/system/dict/${scope.row.type}`">
            {{ scope.row.type }}
          </router-link>
        </template>
      </el-table-column>
      <el-table-column prop="remark" label="备注"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            style="margin-right: 10px"
            @click="handleEdit(scope.row)">编辑
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            slot="reference"
            @click="handleDelete(scope.row)"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--  分页条  -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="searchForm.current"
      :total="total"
      :page-sizes="[3, 10, 20, 50]"
      :page-size="searchForm.size"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!--  弹出框  -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="400px">
      <el-form label-width="50px" size="mini" :model="editForm">
        <el-form-item label="名称">
          <el-input v-model="editForm.name" placeholder="请输入字典名称"/>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="editForm.type" placeholder="请输入字典类型"/>
        </el-form-item>
        <el-form-item label="备注">
          <el-input type="textarea" v-model="editForm.remark" placeholder="请输入字典备注"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleSubmit">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {deleteById, listData, save, update} from "@/api/dict"

export default {
  name: 'Dict',
  data() {
    return {
      tableData: [],
      total: 0,
      loading: false,
      multipart: false,
      single: true,
      searchForm: {
        keyword: null,
        current: 1,
        size: 3
      },
      dialogTitle: '新增字典',
      ids: [],
      editForm: {
        name: '',
        sn: ''
      },
      dialogVisible: false
    }
  },
  methods: {
    getList() {
      // 准备要获取数据了
      this.loading = true
      // 发送请求查询页面需要的数据
      listData(this.searchForm)
        .then(res => {
          // res.data === PageInfo
          const {data} = res

          // 从后台获取的表格数据
          this.tableData = data.records
          // 从后台获取的总页数
          this.total = data.total
          this.searchForm.current = data.current
          this.searchForm.size = data.size

          // 已经拿到数据了
          this.loading = false
        })
        .catch(res => {
          console.log(res, '请求失败了...')
          // 已经拿到数据了
          this.loading = false
        })
    },
    handleQuery() {
      this.searchForm.current = 1
      this.getList()
    },
    handleSizeChange(limit) {
      this.searchForm.size = limit
      this.getList()
    },
    handleCurrentChange(current) {
      // 1. 将得到的当前页设置到 searchForm.current
      this.searchForm.current = current
      // 2. 发送请求获取数据
      this.getList()
    },
    handleEdit(row) {
      this.dialogTitle = '编辑字典'
      // 显示弹框
      this.dialogVisible = true
      // 回显数据
      this.editForm = {...row}
    },
    handleAdd() {
      this.dialogTitle = '新增字典'
      // 先将表单的内容重置
      this.editForm = {
        name: null,
        type: null,
        remark: null
      }
      // 显示弹框
      this.dialogVisible = true
    },
    handleSubmit() {
      let ret;
      if (this.editForm.id) {
        // 编辑
        ret = update(this.editForm)
      } else {
        ret = save(this.editForm)
      }
      // 1. 发送请求到后台
      ret.then(res => {
          // 2. 刷新列表
          this.getList()
          // 3. 关闭弹框
          this.dialogVisible = false
          // 提示
          this.$message.success('操作成功')
        })
    },
    handleDelete(row) {
      let ids = row.id
      this.$confirm(`确认将编号为${ids}的用户删除吗?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 1. 发送请求到后台删除数据
        deleteById(ids).then(res => {
          // 2. 将当前页设置为第一页, 刷新当前表格
          this.searchForm.keyword = null
          this.handleQuery()

          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
      })
    }
  },
  created() {
    // 发送请求查询页面需要的数据
    this.getList()
  }
}
</script>
<style lang="css" scoped>
.line {
  text-align: center;
}

.el-pagination {
  text-align: right;
}
</style>
