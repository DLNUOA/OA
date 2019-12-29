var myInfo = new Vue({
    el:'#myInfo',
    data(){
      return{
          data:''
      }
    },
    methods:{
        lunchUpdate:function () {
            updateInfoModal.loginName = this.data.login_name;
            updateInfoModal.tel = this.data.tel;
            updateInfoModal.email = this.data.email;
            updateInfoModal.intro = this.data.intro;
        }
    },
    mounted: function () {
        axios
            .get('/api/personCenter/personInfo')
            .then(response => (this.data = response.data))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
        DTO = this.data;
    }
});

var updateInfoModal = new Vue({
    el:'#updateInfoModal',
    data:{
        id:'',
        loginName:'',
        tel:'',
        email:'',
        intro:''
    },
    methods: {
        saveUpdate: function () {
            axios
                .put('/api/personCenter/updateMyInfo',{
                    loginName:this.loginName,
                    tel:this.tel,
                    email:this.email,
                    intro:this.intro
                })
                .then(function (response) {
                    //这里使用了匿名函数，而不是箭头函数，因为我们要写多条语句（用箭头也可以啦）。返回数据为1则修改部门成功
                    if (response.data==1){
                        toastr.success('个人信息修改成功');
                    }else {
                        toastr.error('修改失败，请联系管理员反馈问题');
                    }
                })
                .catch(function(error) {
                    console.log(error);
                });
        }
    }
});


let validCodeButton = new Vue({
    el:'#ValidCodeButton',
    data(){
        return{
            content:'点击发送验证码',
            totalTime:3,
            canClick:true,
            data:null
        }
    },
    methods:{
        countDown(){
            if (this.canClick===true){
                axios
                    .post('/api/personCenter/sendValidEmail')
                    .then(response => this.data = response.data)
                    .catch(function(error) {
                        console.log(error);
                    });
            }
            if (!this.canClick) return;
            this.canClick = false;
            this.content = this.totalTime+'s后重新发送';
            let clock = window.setInterval(()=>{
                this.totalTime--;
                this.content = this.totalTime+'s后重新发送';
                if (this.totalTime<0){
                    window.clearInterval(clock);
                    this.content = '重新发送验证码';
                    this.totalTime = 3;
                    this.canClick = true;
                }

            },1000)
        }
    }
});


let updatePwdModal = new Vue({
    el:"#updatePwdModal",
    data(){
        return{
            oldPwd:null,
            newPwd:null,
            code:null,
        }
    },
    methods:{
        updatePwd(){
            if (this.oldPwd!=null&&this.newPwd!=null&&this.code!=null){
                axios
                    .post('/api/personCenter/updatePwd',{
                        oldPwd:this.oldPwd,
                        newPwd:this.newPwd,
                        code:this.code
                    })
                    .then(response => {
                        if (response.data==1){
                            toastr.success('修改密码成功');
                        }else {
                            toastr.error('这个时候你要打电话给客户了！');
                        }
                    })
                    .catch(function(error) {
                        console.log(error);
                    });
            }
            else {
                toastr.error('格式错误');
            }
        }
    }
});




















