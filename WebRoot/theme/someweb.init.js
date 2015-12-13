//设置全局ajax方式
$.ajaxSetup({
	type : "post",
	global: true,
	timeout : 120000,
	error : function(result,msg,obj)
	{
		mini.open({
          url: contextPath + "/theme/common/404.jsp",
          showMaxButton: false,
          title: "错误信息提示",
          width: 550,
          height: 400
       }); 
	},
	failure : function(result)
	{
		mini.open({
          url: contextPath + "/theme/common/404.jsp",
          showMaxButton: false,
          title: "错误信息提示",
          width: 550,
          height: 400
       }); 
	}
});