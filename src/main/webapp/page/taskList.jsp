<%--
  Created by IntelliJ IDEA.
  User: wangmt
  Date: 2017/11/23
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1 class="page-header">任务调度</h1>
<div class="table-responsive">
    <button type="button" class="btn btn-success" v-on:click="add()">添加</button>
    <table class="table table-striped table-bordered" >
        <thead>
        <tr>
            <th>id</th>
            <th>任务名称</th>
            <th>任务class</th>
            <th>任务时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in taskList">
            <td>{{item.id}}</td>
            <td>{{item.jobName}}</td>
            <td>{{item.jobClass}}</td>
            <td>{{item.jobCronExpression}}</td>
            <td>{{item.status | convStatus }}</td>
            <td>
                <button type="button" class="btn btn-primary" v-on:click="edit(item.id)">修改</button>
                <button  type="button" class="btn btn-warning" v-if="item.status == 1" v-on:click="stop(item.id)">停止</button>
                <button  type="button" class="btn btn-info" v-if="item.status == 0" v-on:click="open(item.id)">启动</button>
                <button type="button" class="btn btn-danger" v-on:click="del(item.id)">删除</button>
                <button type="button" class="btn btn-default" v-on:click="mul(item.id)">手动执行</button>
            </td>
        </tr>
        </tbody>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li v-on:click="setPage(1)">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <li v-if="0 != page.offset" v-on:click="setPage(page.offset)">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li v-for="it in total"  v-on:click="setPage(it)" :class="{active:it == page.offset+1}" v-if="it>page.offset-4 && it<page.offset+6"><a href="#">{{it}}</a></li>
            <li v-if="total != page.offset+1" v-on:click="setPage(page.offset+2)">
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li v-on:click="setPage(total)">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<div class="modal fade" tabindex="-1" role="dialog" v-show="true" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增调度</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">任务名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" v-model="task.jobName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">任务Class</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  v-model="task.jobClass">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">任务时间</label>
                        <div class="col-sm-2" v-for="(child,index) in expression">
                            <input type="text" class="form-control input-sm"  v-model="child" v-on:change="changeVue(child,index)">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" v-on:click="save">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script src="<%=basePath %>js/taskList.js"></script>
