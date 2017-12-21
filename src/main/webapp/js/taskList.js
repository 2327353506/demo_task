new Vue({
    el: "#app",
    data: {
        taskList: [],
        total: 1,
        page:{
            offset: 0,
            limit: 15
        },
        task:{
            id: "",
            jobName: "",
            jobCronExpression: "",
            jobClass: "",
        },
        expression: ['*','*','*','*','*']
    },
    methods: {
        open: function(id){
            var _this = this;
            this.$get(root + "task/open?id="+id,function(res){
                if(res.code==0){
                    _this.initTable();
                }else{
                    alert(res.msg);
                }
            })
        },
        stop: function(id){
            var _this = this;
            this.$get(root + "task/stop?id="+id,function(res){
                if(res.code==0){
                    _this.initTable();
                }else{
                    alert(res.msg);
                }
            })
        },
        del: function(id){
            var _this = this;
            this.$get(root + "task/del?id="+id,function(res){
                if(res.code==0){
                    _this.initTable();
                }else{
                    alert(res.msg);
                }
            })
        },
        edit: function(id){
            var _this = this;
            this.$get(root + "task/detail?id="+id,function(res){
                if(res.code==0){
                    _this.task = res.data;
                    var arr = res.data.jobCronExpression.split(" ");
                    _this.expression[0]= arr[0];
                    _this.expression[1]= arr[1];
                    _this.expression[2]= arr[2];
                    _this.expression[3]= arr[3];
                    _this.expression[4]= arr[4];
                    $('#myModal').modal({});
                }else{
                    alert(res.msg);
                }
            })
        },
        add: function(){
            this.task={
                id: "",
                jobName: "",
                jobCronExpression: "",
                jobClass: "",
            };
            this.expression= ['*','*','*','*','*']
            $('#myModal').modal({})
        },
            save: function(){
                var _this = this;
                this.task.jobCronExpression = this.expression[0]+" "+this.expression[1]+" "+this.expression[2]+" "+this.expression[3]+" "+this.expression[4]+" ?"
                this.$post(root+"/task/save",this.task,function(res){
                    if(res.code==0){
                        $('#myModal').modal('hide')
                        _this.initTable();
                    }else{
                        alert(res.msg);
                    }
                })
            },
        mul: function(id){
            var _this = this;
            this.$get(root + "task/manual?id="+id,function(res){
                if(res.code==0){
                    $alert("拉取成功");
                }else{
                    $alert(res.msg);
                }
            })
        },
        initTable: function(){
            var _this = this;
            this.$post(root+"/task/list",this.page,function(res){
                _this.taskList = res.data.rows;
                var total = res.data.total;
                if(total>1){
                    total = total-1;
                }
                _this.total = parseInt(total/_this.page.limit + 1);
            })
        },
        setPage: function(index){
            this.page.offset = index-1;
            this.initTable();
        },
        changeVue: function(val,index){
            this.expression[index]= val;
        }
    },
    filters: {
        convStatus: function(value){
            switch (value){
                case 0 :
                    return "禁用";
                case 1 :
                    return "启用";
                case 2 :
                    return "删除";
            }
        }
    },
    created: function(){
        this.initTable();
    }
})