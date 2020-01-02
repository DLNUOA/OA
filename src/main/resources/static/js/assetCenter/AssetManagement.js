
var assetList = new Vue({
    el: '#assetInfoList',
    // 不使用return包裹的数据会在项目的全局可见，会造成变量污染；使用return包裹后数据中变量只在当前组件中生效，不会影响其他组件。
    data () {
        return {
            assets: null,
            asset:null
        }
    },

    methods: {
        deleteAsset: function (index) {
            //使用let定义局部变量
            let assetId = this.assets[index].assetId;

            // jqAlert.Confirm('确定删除吗？',function () {
            // 	alert(djile);
            // 	axios
            // 			.delete('/api/asset/'+assetId)
            // 			.then(response => response.data==1?(toastr.success('删除成功')):toastr.error('删除失败'))
            // 			.catch(function(error){
            // 				console.log(error);
            // 			});
            // 	assetList.assets.splice(index,1);
            // });

            if(confirm('确定删除该资产吗？资产id为'+assetId)){
                axios
                    .delete('/api/asset/'+assetId)
                    .then(response => response.data==1?(toastr.success('删除成功')):toastr.error('删除失败'))
                    .catch(function(error){
                        console.log(error);
                    });
                this.assets.splice(index,1);

            }
        },
        getAsset:function(){
            axios
                .get('/api/asset')
                .then(response => console.log(response.data))
                .catch(function(error) {
                    console.log(error);
                });
        },
        LaunchUpdateAsset:function(index){
            this.asset=(this.assets[index]);
            updateAssetModal.assetId = this.asset.assetId;
            updateAssetModal.assetName = this.asset.assetName;
            updateAssetModal.assetClasses = this.asset.assetLoc;
            updateAssetModal.assetSpecification = this.asset.assetIntro;
            updateAssetModal.assetUnitPrice = this.asset.assetUnitPrice;
            updateAssetModal.assetInventory = this.asset.assetInventory;
            updateAssetModal.index = index;
        }
    },
    mounted () {
        //当Vue实例挂载完成时，自动调用后端接口获取所有asset数据并且将数据渲染到html
        axios
            .get('/api/asset')
            .then(response => (this.assets = response.data))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
    }
});

var updateAssetModal = new Vue({
    el:'#updateAssetModal',
    data:{
        assetId:null,
        assetName:null,
        assetClasses:null,
        assetSpecification:null,
        assetUnitPrice:null,
        assetInventory:null,
        index:null
    },
    // .then(function (response) {
    // 	this.empId =  response.data.empId;
    // 	this.empName = response.data.empName;
    // 	this.empRoleId = response.data.empRoleId;
    // })
    methods:{
        updateAsset:function(){
            axios
                .put('/api/asset',{
                    assetId:this.assetId,
                    assetName:this.assetName,
                    assetClasses:this.assetClasses,
                    assetSpecification:this.assetSpecification,
                    assetUnitPrice:this.assetUnitPrice,
                    assetInventory:this.assetInventory
                })
                .then(function (response) {
                    if (response.data==1){
                        toastr.success('修改库存成功');

                        assetList.asset[this.index].assetName=this.assetName;
                        assetList.asset[this.index].assetClasses=this.assetClasses;
                        assetList.asset[this.index].assetSpecification=this.assetSpecification;
                        assetList.asset[this.index].assetUnitPrice=this.assetUnitPrice;
                        assetList.asset[this.index].assetInventory=this.assetInventory

                    }else {
                        toastr.error('修改库存失败，请联系管理员');
                    }
                })
                .catch(function(error) {
                    console.log(error);
                });
            assetList.asset[this.index].assetName=this.assetName;
            assetList.asset[this.index].assetClasses=this.assetClasses;
            assetList.asset[this.index].assetSpecification=this.assetSpecification;
            assetList.asset[this.index].assetUnitPrice=this.assetUnitPrice;
            assetList.asset[this.index].assetInventory=this.assetInventory

        }
    }
});


var addAsset = new Vue({
    el:'#addAsset',
    data:{
        bmm:'',
        bmz:'',
        bmx:'',
        bmc:'',
        bmv:'',
        bmb:''
    },
    methods:{
        addAsset:function (){
            axios
                .post('/api/asset',{
                    assetId:this.bmm,
                    assetName:this.bmdz,
                    assetClasses:this.bmx,
                    assetSpecification:this.bmc,
                    assetUnitPrice:this.bmv,
                    assetInventory:this.bmb
                })
                .then(response => response.data==1?(toastr.success('成功')):toastr.error('失败'))
                .catch(function(error) {
                    console.log(error);
                });
            setTimeout(function () {
                window.location.href = "/systemManage/assetManage";
            },1000);

        }

    }
});
