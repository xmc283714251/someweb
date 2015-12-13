/**
 * jquery 插件集合
 * @param {Object} $
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
(function($){
	$.fn.extend({
		/**
		 * Ajax方式提交表单
		 * @param opts {
		 * 	controller,控制ID
		 *  action,控制类方法
		 *  callback 会掉函数
		 * }
		 */
		ajaxSubmitForm : function(opts)
		{
			var formid = $(this).attr("id");
			var form = new mini.Form("#" + formid);
			
			form.validate();
	        if (form.isValid() == false)
	        {
	        	return;
	        }
			var data = form.getData();
			var json = mini.encode(data);
			$.ajax({
			    url: businessurl,
			    type: "post",
			    dataType:"json",
			    data: { 
			    	controller:opts.controller,
			    	action:opts.action,
			    	parameters:json
			    },
			    success: function (json) 
			    {
			    	if($.isFunction(opts.callback))
			    	{
			    		opts.callback(json)
			    	}
			    }
			});
		}
	});
	 
})(jQuery)