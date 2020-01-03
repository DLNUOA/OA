
var deptList = new Vue({
    el: '#deptInfoList',
    // 不使用return包裹的数据会在项目的全局可见，会造成变量污染；使用return包裹后数据中变量只在当前组件中生效，不会影响其他组件。
    data () {
        return {
            depts: null,
            dept:null
        }
    },

    methods: {
        deleteDept: function (index) {
            //使用let定义局部变量
            let deptId = this.depts[index].deptId;

            // jqAlert.Confirm('确定删除吗？',function () {
            // 	alert(djile);
            // 	axios
            // 			.delete('/api/dept/'+deptId)
            // 			.then(response => response.data==1?(toastr.success('删除成功')):toastr.error('删除失败'))
            // 			.catch(function(error){
            // 				console.log(error);
            // 			});
            // 	deptList.depts.splice(index,1);
            // });

            if(confirm('确定删除该部门吗？部门id为'+deptId)){
                axios
                    .delete('/api/dept/'+deptId)
                    .then(response => response.data==1?(toastr.success('删除成功')):toastr.error('删除失败'))
                    .catch(function(error){
                        console.log(error);
                    });
                this.depts.splice(index,1);

            }
        },
        getDepts:function(){
            axios
                .get('/api/dept')
                .then(response => console.log(response.data))
                .catch(function(error) {
                    console.log(error);
                });
        },
        LaunchUpdateDept:function(index){
            this.dept=(this.depts[index]);
            updateADeptModal.deptId = this.dept.deptId;
            updateADeptModal.deptName = this.dept.deptName;
            updateADeptModal.deptLoc = this.dept.deptLoc;
            updateADeptModal.deptIntro = this.dept.deptIntro;
            updateADeptModal.index = index;
        }
    },
    mounted () {
        //当Vue实例挂载完成时，自动调用后端接口获取所有dept数据并且将数据渲染到html
        axios
            .get('/api/dept')
            .then(response => (this.depts = response.data))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
    }
});

var updateADeptModal = new Vue({
    el:'#updateADeptModal',
    data:{
        deptId:null,
        deptName:null,
        deptLoc:null,
        deptIntro:null,
        index:null
    },
    // .then(function (response) {
    // 	this.empId =  response.data.empId;
    // 	this.empName = response.data.empName;
    // 	this.empRoleId = response.data.empRoleId;
    // })
    methods:{
        updateADept:function(){
            axios
                .put('/api/dept',{
                    deptId:this.deptId,
                    deptName:this.deptName,
                    deptLoc:this.deptLoc,
                    deptIntro:this.deptIntro
                })
                .then(function (response) {
                    if (response.data==1){
                        toastr.success('修改部门成功');
                        deptList.depts[this.index].deptName=this.deptName;
                        deptList.depts[this.index].deptLoc=this.deptLoc;
                        deptList.depts[this.index].deptIntro=this.deptIntro;
                    }else {
                        toastr.error('修改部门失败，请联系管理员');
                    }
                })
                .catch(function(error) {
                    console.log(error);
                });
            deptList.depts[this.index].deptName=this.deptName;
            deptList.depts[this.index].deptLoc=this.deptLoc;
            deptList.depts[this.index].deptIntro=this.deptIntro;


        }
    }
});


var addDept = new Vue({
    el:'#addDept',
    data:{
        bmm:'',
        bmdz:'',
        bmms:''
    },
    methods:{
        addADept:function (){
            axios
                .post('/api/dept',{
                    deptName:this.bmm,
                    deptLoc:this.bmdz,
                    deptIntro:this.bmms
                })
                .then(response => response.data==1?(toastr.success('成功')):toastr.error('失败'))
                .catch(function(error) {
                    console.log(error);
                });
            setTimeout(function () {
                window.location.href = "/systemManage/deptManage";
            },1000);

        }

    }
});
