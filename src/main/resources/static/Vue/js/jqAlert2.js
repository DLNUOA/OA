;(function ( $, window, document, undefined ){
    function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) ){
        //PC
        var deviceWidth;
        deviceHeight = document.documentElement.clientHeight || document.body.clientHeight;

        function refresh() {
            deviceWidth = document.documentElement.clientWidth || document.body.clientWidth;
            if (deviceWidth > 2000) {
                document.documentElement.style.fontSize = 2000 / 20 + "px";
                column = 2000 / 20;
            } else {
                document.documentElement.style.fontSize = deviceWidth / 30 + "px";
                column = deviceWidth / 30;
            }
        }

        refresh();
        window.onresize = function () {
            refresh();
        };

    } else {
        //手机
        var deviceWidth;
        deviceHeight = document.documentElement.clientHeight || document.body.clientHeight;

        function refresh() {
            deviceWidth = document.documentElement.clientWidth || document.body.clientWidth;
            if (deviceWidth > 2000) {
                document.documentElement.style.fontSize = 2000 / 20 + "px";
                column = 2000 / 20;
            } else {
                document.documentElement.style.fontSize = deviceWidth / 10.8 + "px";
                column = deviceWidth / 10.8;
            }
        }

        refresh();
        window.onresize = function () {
            refresh();
        };

    }
}
browserRedirect();


var maskbox,pMsg,maskLayer,alertBox,alertMsg,alertSure,alertErorr,prompt,column,deviceHeight;



var dz_maskbox = document.createElement("div");
var dz_pMsg = document.createElement("p");
dz_maskbox.id = 'dz_maskbox';
dz_pMsg.id = 'pMsg';
var area = $('body');
area.css({
    'margin': '0',
    'font-size': '0.45rem'
});
area.append(dz_maskbox);
dz_maskbox.appendChild(dz_pMsg);


var dz_maskLayer = document.createElement("div");
var dz_alertBox = document.createElement("div");
var dz_alertSure = document.createElement("div");
var dz_alertErorr = document.createElement("div");
var dz_alertMsg = document.createElement("p");
var dz_prompt = document.createElement("div");

dz_maskLayer.id = 'dz_maskLayer';
dz_alertBox.id = 'dz_alertBox';
dz_alertSure.id = 'dz_alertSure';
dz_alertErorr.id = 'dz_alertErorr';
dz_alertMsg.id = 'dz_alertMsg';
dz_prompt.id = 'dz_prompt';
area.append(dz_maskLayer);
area.append(dz_alertBox);
dz_alertBox.appendChild(dz_alertMsg);
dz_alertBox.appendChild(dz_alertSure);
dz_alertBox.appendChild(dz_alertErorr);
dz_alertBox.appendChild(dz_prompt);

maskbox = $('#dz_maskbox');
pMsg = $('#pMsg');
maskLayer = $('#dz_maskLayer');
alertBox = $('#dz_alertBox');
alertMsg = $('#dz_alertMsg');
alertSure = $('#dz_alertSure');
alertErorr = $('#dz_alertErorr');
prompt = $('#dz_prompt');


maskbox.css({
    'position': 'fixed',
    'left': '50%',
    'bottom': '-5rem',
    'text-align': 'center',
    'background': '#000',
    'color': '#fff',
    'font-size': '0.45rem',
    'opacity': '1',
    'padding': '0.2rem 0.5rem',
    'border-radius': '0.3rem'
});

maskLayer.css({
    'position': 'fixed',
    'top': '0',
    'width': '100%',
    'background': '#000',
    'opacity': '0.3',
    'display': 'none'
});
alertBox.css({
    'height': '4rem',
    'width': '8rem',
    'position': 'fixed',
    'left': '50%',
    'margin-left': '-4rem',
    'top': '5rem',
    'text-align': 'center',
    'background': '#ffffff',
    'font-size': '0.4rem',
    'border-radius': '0.2rem',
    'display': 'none',
    'z-index': '100000'
});
pMsg.css({
    'margin': '0'
});
alertMsg.css({
    'margin': '0.5rem'
});
alertSure.css({
    'position': 'absolute',
    'left': '0',
    'height': '1rem',
    'width': ' 2rem',
    'text-align': 'center',
    'background': '#1d82fe',
    'line-height': '1rem',
    'color': '#fff',
    'margin': '0.5rem 0 0 1.5rem',
    'border-radius': '0.2rem',
    'display': 'none'
});
alertErorr.css({
    'position': 'absolute',
    'left': '4.5rem',
    'height': '1rem',
    'width': ' 2rem',
    'text-align': 'center',
    'background': '#ccc',
    'line-height': '1rem',
    'color': '#fff',
    'margin-top': '0.5rem',
    'border-radius': '0.2rem',
    'display': 'none'
});
prompt.css({
    'position': 'absolute',
    'left': '2.5rem',
    'height': '1rem',
    'width': ' 3rem',
    'text-align': 'center',
    'background': '#1d82fe',
    'line-height': '1rem',
    'color': '#fff',
    'margin-top': '0.5rem',
    'border-radius': '0.2rem',
    'display': 'none'
});
alertSure.text('确定');
alertErorr.text('取消');
prompt.text('确定');
// alertErorr.click(function () {
//     jqAlert.CloseConfirm()
// });
prompt.click(function () {
    jqAlert.CloseConfirm()
});





jqAlert = {
    Layer_t:0,
    Layer: function (msg, time) {
        clearTimeout(this.Layer_t-1);
        if (msg) {
            pMsg.text(msg);
            var width = pMsg.width();
            // console.log(width)
            // console.log(column)
            maskbox.css({
                'transition': 'all 0.5s',
                'margin-left': -(width / column) / 2 + 'rem',
                'bottom': '1rem',
                'opacity': '1'
            });

        } else {
            pMsg.text(' ');
        }


        if (time) {
            jqAlert.CloseLayer(time);
        } else {
            jqAlert.CloseLayer(2000);
        }
    },
    CloseLayer: function (time) {
        this.Layer_t = setTimeout(function () {
            maskbox.css({
                'opacity': '0',
                'bottom': '-5rem'
            });
        }, time);
        this.Layer_t++;
    },
    Confirm: function (msg, callback, el) {
        clearTimeout(this.Layer_t-1);
        if (callback && el) {
            maskLayer.height(deviceHeight);
            maskLayer.show();
            alertBox.show();
            alertSure.show();
            alertErorr.show();
            alertMsg.text(msg);
            // var id = el.target.id;
            if (typeof callback == 'function') {
                console.log(callback);
                // var _this = this;
                // this.Confirm.apply(id);
                alertSure.click(function () {
                    callback(el.target);
                    jqAlert.CloseConfirm(); //确认后隐藏弹层
                    jqAlert.init();
                });
                alertErorr.click(function () {
                    jqAlert.CloseConfirm(); //取消后隐藏弹层
                    jqAlert.init();
                });
            }
        }else if(typeof callback == 'number'){
            // console.log(callback);
            jqAlert.Prompt(msg);
            this.Layer_t = setTimeout(function () {
                jqAlert.CloseConfirm(); //隐藏弹层
                jqAlert.init();
            },callback);
            this.Layer_t++;
        } else {
            jqAlert.Prompt(msg);
        }
    },
    CloseConfirm: function () {
        maskLayer.hide();
        alertBox.hide();
        alertSure.hide();
        alertErorr.hide();
        prompt.hide();
    },
    Prompt: function (msg) {
        maskLayer.height(deviceHeight);
        maskLayer.show();
        alertBox.show();
        prompt.show();
        alertMsg.text(msg);
    },
    init: function () {
        //移除确定按钮
        $('#dz_alertSure').remove();
        //重新初始化确定按钮
        dz_alertSure = document.createElement("div");
        dz_alertSure.id = 'dz_alertSure';
        dz_alertBox.append(dz_alertSure);
        alertSure = $('#dz_alertSure');
        alertSure.css({
            'position': 'absolute',
            'left': '0',
            'height': '1rem',
            'width': ' 2rem',
            'text-align': 'center',
            'background': '#1d82fe',
            'line-height': '1rem',
            'color': '#fff',
            'margin': '0.5rem 0 0 1.5rem',
            'border-radius': '0.2rem',
            'display': 'none'
        });
        alertSure.text('确定');

        //移除取消按钮
        $('#dz_alertErorr').remove();
        //重新初始化取消按钮
        dz_alertErorr = document.createElement("div");
        dz_alertErorr.id = 'dz_alertErorr';
        dz_alertBox.append(dz_alertErorr);
        alertErorr = $('#dz_alertErorr');
        alertErorr.css({
            'position': 'absolute',
            'left': '4.5rem',
            'height': '1rem',
            'width': ' 2rem',
            'text-align': 'center',
            'background': '#ccc',
            'line-height': '1rem',
            'color': '#fff',
            'margin-top': '0.5rem',
            'border-radius': '0.2rem',
            'display': 'none'
        });
        alertErorr.text('取消');
    }
};
})(jQuery, window,document);