webpackJsonp([1],{189:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s(192),i=s(196),o=s(79),n=o(a.a,i.a,!1,null,null,null);e.default=n.exports},192:function(t,e,s){"use strict";e.a={data:function(){return{taskList:[],total:0,page:{offset:0,limit:15,jobName:"",status:""},dialogVisible:!1,expression:{a1:"*",a2:"*",a3:"*",a4:"*",a5:"*"},task:{id:"",jobName:"",jobCronExpression:"",jobClass:""}}},created:function(){var t=this;this.$post(this.$store.state.root+"/task/list",this.page,function(e){t.taskList=e.data.rows,t.total=e.data.total})},methods:{handleSizeChange:function(t){this.page.limit=t,this.initTable()},handleCurrentChange:function(t){this.page.offset=t,this.initTable()},handleClose:function(t){this.$confirm("确认关闭？").then(function(e){t()}).catch(function(t){})},initTable:function(){var t=this;this.$post(this.$store.state.root+"/task/list",this.page,function(e){t.taskList=e.data.rows,t.total=e.data.total})},mul:function(t){var e=this;this.$post(this.$store.state.root+"/task/manual",{id:t},function(t){0==t.code?e.$alert("拉取成功"):e.$alert(t.msg)})},open:function(t){var e=this;this.$get(this.$store.state.root+"/task/open",{id:t},function(t){0==t.code?e.initTable():e.$alert(t.msg)})},stop:function(t){var e=this;this.$get(this.$store.state.root+"/task/stop",{id:t},function(t){0==t.code?e.initTable():e.$alert(t.msg)})},add:function(){this.dialogVisible=!0,this.task={id:"",jobName:"",jobCronExpression:"",jobClass:""},this.expression={a1:"*",a2:"*",a3:"*",a4:"*",a5:"*"}},edit:function(t){var e=this;this.$get(this.$store.state.root+"/task/detail",{id:t},function(t){if(0==t.code){e.task=t.data;var s=t.data.jobCronExpression.split(" ");e.expression.a1=s[0],e.expression.a2=s[1],e.expression.a3=s[2],e.expression.a4=s[3],e.expression.a5=s[4],e.dialogVisible=!0}else e.$alert(t.msg)})},save:function(){var t=this;this.task.jobCronExpression="";for(var e in this.expression)this.task.jobCronExpression=this.task.jobCronExpression+this.expression[e]+" ";this.task.jobCronExpression=this.task.jobCronExpression+"?",this.$post(this.$store.state.root+"/task/save",this.task,function(e){0==e.code?(t.dialogVisible=!1,t.$alert("保存成功"),t.initTable()):t.$alert(e.msg)})},del:function(t){var e=this;this.$confirm("此操作将删除该任务, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.$get(e.$store.state.root+"/task/del",{id:t},function(t){0==t.code?(e.initTable(),e.$message({type:"success",message:"删除成功!"})):e.$alert(t.msg)})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})}},filters:{convStatus:function(t){switch(t){case 0:return"禁用";case 1:return"启用";case 2:return"删除"}}}}},196:function(t,e,s){"use strict";var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticStyle:{padding:"20px"}},[s("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0}},[s("el-form-item",{attrs:{label:"任务名称"}},[s("el-input",{attrs:{placeholder:"任务名称"},model:{value:t.page.jobName,callback:function(e){t.$set(t.page,"jobName",e)},expression:"page.jobName"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"状态"}},[s("el-select",{attrs:{placeholder:"状态"},model:{value:t.page.status,callback:function(e){t.$set(t.page,"status",e)},expression:"page.status"}},[s("el-option",{attrs:{label:"",value:""}}),t._v(" "),s("el-option",{attrs:{label:"禁用",value:"0"}}),t._v(" "),s("el-option",{attrs:{label:"启用",value:"1"}})],1)],1),t._v(" "),s("el-form-item",[s("el-button",{attrs:{type:"primary"},on:{click:function(e){t.initTable()}}},[t._v("查询")])],1)],1),t._v(" "),s("el-button",{attrs:{type:"success"},on:{click:function(e){t.add()}}},[t._v("新增")]),t._v(" "),s("el-table",{staticStyle:{width:"1150px"},attrs:{data:t.taskList,border:"",stripe:""}},[s("el-table-column",{attrs:{fixed:"",type:"index",width:"50",label:"序号"}}),t._v(" "),s("el-table-column",{attrs:{prop:"jobName",label:"任务名称",width:"150"}}),t._v(" "),s("el-table-column",{attrs:{prop:"jobClass",label:"任务class",width:"200"}}),t._v(" "),s("el-table-column",{attrs:{prop:"jobCronExpression",label:"任务时间",width:"120"}}),t._v(" "),s("el-table-column",{attrs:{label:"状态",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n                "+t._s(t._f("convStatus")(e.row.status))+"\n            ")]}}])}),t._v(" "),s("el-table-column",{attrs:{prop:"updateDt",label:"更新时间",width:"200"}}),t._v(" "),s("el-table-column",{attrs:{fixed:"right",label:"操作",width:"350"},scopedSlots:t._u([{key:"default",fn:function(e){return[s("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(s){t.edit(e.row.id)}}},[t._v("修改")]),t._v(" "),1==e.row.status?s("el-button",{attrs:{type:"success",size:"mini"},on:{click:function(s){t.stop(e.row.id)}}},[t._v("停止")]):t._e(),t._v(" "),0==e.row.status?s("el-button",{attrs:{type:"info",size:"mini"},on:{click:function(s){t.open(e.row.id)}}},[t._v("启动")]):t._e(),t._v(" "),s("el-button",{attrs:{type:"warning",size:"mini"},on:{click:function(s){t.del(e.row.id)}}},[t._v("删除")]),t._v(" "),s("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(s){t.mul(e.row.id)}}},[t._v("手动执行")])]}}])})],1),t._v(" "),s("el-pagination",{attrs:{"current-page":t.page.offset+1,"page-sizes":[15,20,30,50],"page-size":15,layout:"total, sizes, prev, pager, next, jumper",total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}}),t._v(" "),s("el-dialog",{attrs:{title:"任务",visible:t.dialogVisible,width:"30%","before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},[s("el-form",{ref:"form",attrs:{rules:t.rulesFilter,"label-width":"90px"}},[s("el-form-item",{attrs:{label:"任务名称",required:""}},[s("el-input",{model:{value:t.task.jobName,callback:function(e){t.$set(t.task,"jobName",e)},expression:"task.jobName"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"任务Class",required:""}},[s("el-input",{model:{value:t.task.jobClass,callback:function(e){t.$set(t.task,"jobClass",e)},expression:"task.jobClass"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"任务时间",required:""}},[s("el-col",{attrs:{span:4}},[s("el-input",{staticStyle:{width:"95%"},model:{value:t.expression.a1,callback:function(e){t.$set(t.expression,"a1",e)},expression:"expression.a1"}})],1),t._v(" "),s("el-col",{attrs:{span:4}},[s("el-input",{staticStyle:{width:"95%"},model:{value:t.expression.a2,callback:function(e){t.$set(t.expression,"a2",e)},expression:"expression.a2"}})],1),t._v(" "),s("el-col",{attrs:{span:4}},[s("el-input",{staticStyle:{width:"95%"},model:{value:t.expression.a3,callback:function(e){t.$set(t.expression,"a3",e)},expression:"expression.a3"}})],1),t._v(" "),s("el-col",{attrs:{span:4}},[s("el-input",{staticStyle:{width:"95%"},model:{value:t.expression.a4,callback:function(e){t.$set(t.expression,"a4",e)},expression:"expression.a4"}})],1),t._v(" "),s("el-col",{attrs:{span:4}},[s("el-input",{staticStyle:{width:"95%"},model:{value:t.expression.a5,callback:function(e){t.$set(t.expression,"a5",e)},expression:"expression.a5"}})],1)],1)],1),t._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary"},on:{click:function(e){t.save()}}},[t._v("确 定")])],1)],1)],1)},i=[],o={render:a,staticRenderFns:i};e.a=o}});
//# sourceMappingURL=1.js.map?5b284f950761cb3a69fb