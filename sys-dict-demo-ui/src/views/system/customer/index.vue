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
      <el-table-column prop="name" label="客户姓名"></el-table-column>
      <el-table-column prop="phone" label="联系方式"></el-table-column>
      <el-table-column prop="sourceLabel" label="来源渠道"></el-table-column>
      <el-table-column prop="schoolLabel" label="意向校区"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            style="margin-right: 10px"
            @click="handleEdit(scope.row)">编辑
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
      <el-form label-width="100px" size="mini" :model="editForm">
        <el-form-item label="客户姓名">
          <el-input v-model="editForm.name" placeholder="请输入客户姓名"/>
        </el-form-item>
        <el-form-item label="联系电话">
          <el-input v-model="editForm.phone" placeholder="请输入联系方式"/>
        </el-form-item>
        <el-form-item label="来源渠道">
            <el-select v-model="editForm.source">
              <el-option v-for="s in sources" :label="s.label" :value="s.value"/>
            </el-select>
        </el-form-item>
        <el-form-item label="意向校区">
          <el-select v-model="editForm.school">
            <el-option v-for="s in schools" :label="s.label" :value="s.value"/>
          </el-select>
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
import {listData, save, update} from "@/api/customer"
import {listByType} from "@/api/dictItems"

export default {
  name: 'Customer',
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
        name: null,
        phone: null,
        source: null,
        school: null,
      },
      dialogVisible: false,
      sources:[],
      schools:[]
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
      this.dialogTitle = '编辑客户'
      // 显示弹框
      this.dialogVisible = true
      // 回显数据
      this.editForm = {...row}
    },
    handleAdd() {
      this.dialogTitle = '新增客户'
      // 先将表单的内容重置
      this.editForm = {
        name: null,
        phone: null,
        source: null,
        school: null,
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
  },
  created() {
    // 发送请求查询页面需要的数据
    this.getList()

    // 查询来源渠道字典明细
    listByType('source').then(res => {
      this.sources = res.data
    })
    // 查询意向校区字典明细
    listByType('school').then(res => {
      this.schools = res.data
    })
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
