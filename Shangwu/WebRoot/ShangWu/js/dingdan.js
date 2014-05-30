(function(){

	//首先，进入页面，加载联系方式
	$.ajax({
		type:'post',
		url:'../servlet/GetArea',
		data:'name='+getCookie("username"),
		success:function(res){
		//	alert(res);
			//对地址经行切分
			var phone=res.substr(-11);
			var star=res.indexOf('(');
			var last=res.lastIndexOf(')');
			var address=res.slice(0,star);
			var name=res.slice(star+1,last);
			$('.add').text(address);
			$('.name').text(name);
			$('.phone').text(phone);
			var html=
			'		<img style="display:block" src="images/23.gif" alt="">'+
			'		<span class="to" style="display:block">寄送至</span>'+
			'		<input type="radio"> <font>'+res+'</font>';
			$('.address').html(html);
		},
		error:function(){
			console.log('Ajax bug');
		}
	});

	//单击使用新地址，把原来的滴地址替换
	$('.botton input').click(function(){
		var add;
		$('.waijia').show();
		$('.shi').click(function(){
			add=$(this).next().val();
			var phone=add.substr(-11);
			var star=add.indexOf('(');
			var last=add.lastIndexOf(')');
			var address=add.slice(0,star);
			var name=add.slice(star+1,last);
			$('.add').text(address);
			$('.name').text(name);
			$('.phone').text(phone);
			$(this).next().val('');
			$('.waijia').hide();
			var html=
			'		<img style="display:block" src="images/23.gif" alt="">'+
			'		<span class="to" style="display:block">寄送至</span>'+
			'		<input type="radio"> <font>'+add+'</font>';
			$('.address').html(html);
		});
	});

	//点击取消，取消使用新地址
	$('.qu').click(function(){
		$(this).nextAll('input').val('');
		$('.waijia').hide();
	});


	//加载我购买了什么商品，是从cookie里取得
	
	jiazaishangpin();

	function jiazaishangpin(){
		var shuju=getCookie('goumaicookie').split(',');
	    var result=sprintfshangpin(shuju);
	    $('#yimaide .mytop').next().html(result);
	};

	function sprintfshangpin(arry){
		var gouwuchehtml=$('#yimaide .mytop').next().html();
        var html='';

        var len=(arry.length-1)/6;
        for(var i=0;i<len;i++){
            html=html+gouwuchehtml;
        }
        $('.m').text(arry[arry.length-1]);
        var i=0;
        return html.replace(/%s/g,function(){
            return (i<arry.length-1) ? arry[i++] :'';
        });
    };


    //点击提交订单，把订单信息发送给服务器
   	$('.submit').click(function(){
   		var proMessage=getCookie('goumaicookie').split(',');
   		proMessage.length=proMessage.length-1;/*
   		//alert(proMessage);*/
   		var TjM='';
   		for(var i=0;i<proMessage.length/6;i++){
   			TjM=TjM+getCookie('username')+',';
   			for(var j=0;j<6;j++){
   				if(i==0){
   					TjM=TjM+proMessage[j]+',';
   				}else{
   					TjM=TjM+proMessage[6*i+j]+',';
   				}
   			}
   		}
   	//	alert(TjM.trim());
   		$.ajax({
   			type:'post',
   			url:'../servlet/SenProductAction',
   			data:'message='+TjM.trim(),
   			success:function(res){   //返回订单号
       			setCookie("dingdanhao",res.trim(),"./");
       			window.open('dingdantijao.html','_parent');
   			},
   			error:function(){
   				console.log("Ajax bug");
   			}
   		});
   	});
 












})();


