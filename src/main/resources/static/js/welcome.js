var nav = new Vue({
    el:'#sessionInfo',
    data () {
        return {
            empId:null,
            empName:'未登录',
            empRoleId:null,
            avatar:''
        }

    },
    methods: {
        getSessionInfo:function () {
            axios
                .get('/sessionInfo')
                .then(function (response) {
                    this.empId =  response.data.empId;
                    this.empName = response.data.empName;
                    this.empRoleId = response.data.empRoleId;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        }
    },
    mounted () {
        //当Vue实例挂载完成时，自动调用后端接口获取所有dept数据并且将数据渲染到html
        axios
            .get('/sessionInfo')
            .then(response => (this.empName = response.data.empName))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });

        axios
            .get('/api/personCenter/myAvatar')
            .then(response => (this.avatar = response.data))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
    }
});