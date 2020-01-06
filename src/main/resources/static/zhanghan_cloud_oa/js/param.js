function getParam(key) {
				
	//返回当前url
	var url = location.href;
	
	//截取？之后的内容
	var index = url.indexOf('?');				
	url = url.substr(index + 1);
	
	//分解字符串形成数组
	var params = url.split('&');
	
	for (var i = 0;i < params.length;i ++) {
		var ss = params[i].split('=');
		
		if (ss[0] == key)
			return ss[1];
	}								
}