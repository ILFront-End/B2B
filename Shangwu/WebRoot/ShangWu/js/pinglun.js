(function(){
	
	getCookie('imgurl');
	$('.content img').attr('src',getCookie('imgurl'));
   // alert(getCookie('imgurl'));
	//点击发表按钮，把服务信息提交到服务器提交到服务器
	$('.fabiao').click(function(){
		var select=$('.select input:checked').val();
		var commont=$('textarea').val();
		if(commont.trim()==''){
			alert('请填写评价内容');
		}else{
			//alert();
			$.ajax({
				type:'post',
				url:'../servlet/PinLunAction',
				data:'productname='+getCookie('prouct_name')+'&commont='+commont+'&select='+select+"&username="+getCookie('username'),
				success:function(res){
					var res=res.trim();
					if(res==1){  //说明发表成功
						$('textarea').val('');
						alert('发表评论成功');
					}
				},
				error:function(){
					consle.log('Ajax bug');
				}
			});
		}
	});






})();