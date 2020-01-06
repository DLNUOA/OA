var nav = new Vue({
    el:'#sessionInfo',
    data () {
        return {
            empId:null,
            empName:'未登录',
<<<<<<< HEAD
            empRoleId:null
=======
            empRoleId:null,
            avatar:''
>>>>>>> 13c562ae6f524e798f73818135bf8ce80b9f2e44
        }

    },
    methods: {
        getSessionInfo:function () {
            axios
<<<<<<< HEAD
                .get('/sessionInfo')
=======
                .get('/sessionInfo',{
                    headers:{
                        'Authorization': window.localStorage.token
                    }
                })
>>>>>>> 13c562ae6f524e798f73818135bf8ce80b9f2e44
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
<<<<<<< HEAD
            .get('/sessionInfo')
=======
            .get('/sessionInfo',{
                headers:{
                    'Authorization': window.localStorage.token
                }
            })
>>>>>>> 13c562ae6f524e798f73818135bf8ce80b9f2e44
            .then(response => (this.empName = response.data.empName))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
<<<<<<< HEAD
=======

        axios
            .get('/api/personCenter/myAvatar')
            .then(response => (this.avatar = response.data))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
>>>>>>> 13c562ae6f524e798f73818135bf8ce80b9f2e44
    }
});