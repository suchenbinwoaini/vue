<template>
	  <el-container style="min-height: 100vh;">
	    <el-aside width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246);height:100vh;
	    box-shadow: 2px 0 6px rgb(0 21 41 / 35%);-webkit-scrollbar:none">
	      <el-menu :default-openeds="['1', '3']" style="height: 100%;overflow-x: hidden"
                 background-color="rgb(48,65,86)"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 :collapse-transition="false"
                 :collapse="isCollapse"
        >
          <div style="height: 60px;line-height: 60px;text-align: center">
            <img src="../assets/logo.png" alt="" style="width: 20px;position: relative;top: 6px;margin-right: 5px">
            <b style="color: white" v-show="!isCollapse">后台管理系统</b>
          </div>
	        <el-submenu index="1">
	          <template slot="title"><i class="el-icon-message"></i><span>导航一</span></template>
	          <el-menu-item-group>
	            <template slot="title">分组一</template>
	            <el-menu-item index="1-1">选项1</el-menu-item>
	            <el-menu-item index="1-2">选项2</el-menu-item>
	          </el-menu-item-group>
	          <el-menu-item-group title="分组2">
	            <el-menu-item index="1-3">选项3</el-menu-item>
	          </el-menu-item-group>
	          <el-submenu index="1-4">
	            <template slot="title">选项4</template>
	            <el-menu-item index="1-4-1">选项4-1</el-menu-item>
	          </el-submenu>
	        </el-submenu>
	        <el-submenu index="2">
	          <template slot="title">
              <i class="el-icon-menu"></i>
              <span>导航二</span>
            </template>
	          <el-menu-item-group>
	            <template slot="title">分组一</template>
	            <el-menu-item index="2-1">选项1</el-menu-item>
	            <el-menu-item index="2-2">选项2</el-menu-item>
	          </el-menu-item-group>
	          <el-menu-item-group title="分组2">
	            <el-menu-item index="2-3">选项3</el-menu-item>
	          </el-menu-item-group>
	          <el-submenu index="2-4">
	            <template slot="title">选项4</template>
	            <el-menu-item index="2-4-1">选项4-1</el-menu-item>
	          </el-submenu>
	        </el-submenu>
	        <el-submenu index="3">
	          <template slot="title"><i class="el-icon-setting"></i><span>导航三</span></template>
	          <el-menu-item-group>
	            <template slot="title">分组一</template>
	            <el-menu-item index="3-1">选项1</el-menu-item>
	            <el-menu-item index="3-2">选项2</el-menu-item>
	          </el-menu-item-group>
	          <el-menu-item-group title="分组2">
	            <el-menu-item index="3-3">选项3</el-menu-item>
	          </el-menu-item-group>
	        </el-submenu>
	      </el-menu>
	    </el-aside>

	    <el-container>
	      <el-header style="font-size: 12px;border: black 1px solid;line-height: 60px;display: flex">
          <div style="flex: 1; font-size: 22px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>
	        <el-dropdown style="width: 100px;cursor: pointer">
            <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
	            <el-dropdown-item>查看</el-dropdown-item>
	            <el-dropdown-item>新增</el-dropdown-item>
	            <el-dropdown-item>删除</el-dropdown-item>
	          </el-dropdown-menu>
	        </el-dropdown>
	      </el-header>
	      
	      <el-main>
          <div style="margin: 10px 0px">
            <el-input style="width: 200px;" suffix-icon="el-icon-search" placeholder="请输入姓名"></el-input>
            <el-input style="width: 200px;margin-left: 5px" suffix-icon="el-icon-edit" placeholder="请输入邮箱"></el-input>
            <el-input style="width: 200px;margin-left: 5px" suffix-icon="el-icon-position" placeholder="请输入地址"></el-input>
            <el-button style="margin-left: 5px" type="primary">搜索</el-button>
          </div>
          <div style="margin: 10px 0">
            <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="danger">批量删除 <i class="el-icon-remove-outline"></i></el-button>
            <el-button type="primary">导入 <i class="el-icon-bottom"></i></el-button>
            <el-button type="primary">导出 <i class="el-icon-top"></i></el-button>
          </div>
	        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
	          <el-table-column prop="date" label="日期" width="140">
	          </el-table-column>
	          <el-table-column prop="name" label="姓名" width="120">
	          </el-table-column>
	          <el-table-column prop="address" label="地址">
	          </el-table-column>

            <el-table-column label="操作" width="200" align="center">
              <template>
                <el-button type="success">编辑 <i class="el-icon-edit"></i></el-button>
                <el-button type="danger">删除 <i class="el-icon-remove-outline"></i></el-button>
              </template>
            </el-table-column>
	        </el-table>
          <div style="padding: 10px 0px">
            <el-pagination
                :page-sizes="[5, 10, 15, 20]"
                :page-size="10"
                layout="total, sizes, prev, pager, next, jumper"
                :total="400">
            </el-pagination>
          </div>
	      </el-main>

	    </el-container>
	  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(10).fill(item),
        collapseBtnClass: 'el-icon-s-fold',
        isCollapse: false,
        sideWidth: 200,
        logoTextShow: true,
        sidewidth:200,
        headerBg: 'headerBg'
      }
    },
  methods:{
    collapse(){
      this.isCollapse = !this.isCollapse
      if (this.isCollapse){
        this.sidewidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
      }
      else{
        this.sidewidth=200
        this.collapseBtnClass = 'el-icon-s-fold'
      }
    }
  }
  }
</script>
<style>
.headerBg{
  background-color: #ccc!important;
}
</style>