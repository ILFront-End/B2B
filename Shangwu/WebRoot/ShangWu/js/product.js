(function(){

	//下拉列表展开
	$('.fenlei').hover(function(){
		$('.h_body_navi').show();
	},function(){
		$('.h_body_navi').hide();
	});

	//属性选中或者取消,如选择什么颜色
	function shuxingselect(){
		$('.style_r_ul li').click(function(){
			$(this).parent().find('b').hide();
			$(this).find('b').show();
		});
	};
	

	//好中差全评初始化，使第一个全评为选中状态
	function abc (){
		
	
	$('.aa').css('background','#eee');
	$('.aa').find('span').css('color','#666');
	$('.aa').find('b').hide();
	$('.aa').eq(0).css('background','white');
	$('.aa').eq(0).find('span').css('color','#e4393c');
	$('.aa').eq(0).find('b').show();
	$('.tab>.b').hide();
	$.ajax({
		
				type:'post',
				url:'../servlet/GetAllPinLunAction',
				data:'product_name='+$('.name h1').text(),
				success:function(res){
					if(res.length>5)
						{
					var res=res.split(',');
					var result=pingjiamuban(res);
					$('.alltab .haha').html(result);
					$('.tab>.b').eq(0).show();
						}
				},
				error:function(){
					console.log('Ajax bug');
				}
				
			});
	};
	//点击好中差全评替换
	$('.aa').click(function(){
		var index=$(this).index();
		$('.aa').css('background','#eee');
		$('.aa').find('span').css('color','#666');
		$('.aa').find('b').hide();
		$('.aa').eq(index).css('background','white');
		$('.aa').eq(index).find('span').css('color','#e4393c');
		$('.aa').eq(index).find('b').show();
		$('.tab>.b').hide();
		//显示好中差评之前先加载好中差评
		if(index==0){    //加载全部评论
			$.ajax({
				type:'post',
				url:'../servlet/GetAllPinLunAction',
				data:'product_name='+$('.name h1').text(),
				success:function(res){
					if(res.length>5)
						{
					var res=res.split(',');
					var result=pingjiamuban(res);
					$('.alltab .haha').html(result);
					$('.tab>.b').eq(index).show();
						}
				},
				error:function(){
					console.log('Ajax bug');
				}
			});
		}else if(index==1){    //加载好评
			$.ajax({
				type:'post',
				url:'../servlet/GetSomePinLun',
				data:'product_name='+$('.name h1').text()+'&flag=1',
				success:function(res){
					if(res.length>5)
						{
					var res=res.split(',');
					var result=pingjiamuban(res);
					$('.nicetab .haha').html(result);
					$('.tab>.b').eq(index).show();
						}
				},
				error:function(){
					console.log('Ajax bug');
				}
			});
		}else if(index==2){    //加载中评
			$.ajax({
				type:'post',
				url:'../servlet/GetSomePinLun',
				data:'product_name='+$('.name h1').text()+'&flag=2',
				success:function(res){
				
					if(res.length>5)
						{
						var res=res.split(',');
						var result=pingjiamuban(res);
						$('.center .haha').html(result);
						$('.tab>.b').eq(2).show();
						}
				},
				error:function(){
					console.log('Ajax bug');
				}
			});
		}else if(index==3){  	//加载差评
			$.ajax({
				type:'post',
				url:'../servlet/GetSomePinLun',
				data:'product_name='+$('.name h1').text()+'&flag=3',
				success:function(res){
					if(res.length>5)
						{
					var res=res.split(',');
					var result=pingjiamuban(res);
					$('.badtab .haha').html(result);
					$('.tab>.b').eq(index).show();
						}
				},
				error:function(){
					console.log('Ajax bug');
				}
			});
		}
		
	});


	//得到评价的模板，进行加载
	function pingjiamuban(arry){
		var pin=
		'	 <div class="conmeniten wrap">'+
		'		<div class="tableft">'+
		'			<div class="bound">'+
		'				<img src="%s" alt=""></div>'+
		'			<div class="who">'+
		'				<span>'+
		'					<a href="">%s</a>'+
		'				</span>'+
		'			</div>'+
		'		</div>'+
		'		<div class="tabright">'+
		'			<b></b>'+
		'			<i></i>'+
		'			<div class="tbritop wrap">'+
		'				<span class="star5"></span>'+
		'				<span class="time">%s</span>'+
		'			</div>'+
		'			<div class="tabconment">'+
		'				<p>%s</p>'+
		'			</div>'+
		'		</div>'+
		'	</div>';
		var html='';
		for(var i=0;i<(arry.length/4);i++){
            html=html+pin;
        }
        var i=0;
        return html.replace(/%s/g,function(){
            return (i<arry.length) ? arry[i++] :'';
        });
	}


	//进入页面，查看cookie，根据cookie加载需要的所有项
	if(getCookie("productURL")!=null){
		
		$.ajax({
			type:'post',
			url:'../servlet/SingleProductAction',
			data:'name='+getCookie('productURL'),
			success:function(res){
				var res=res.trim();
				var result=sprintfName(res.split('&')[0]);
				$('.name').html(result);
				result=sprintfMuch(res.split('&')[1]);
				$('.much').text(result);
				sprintfshuxing(res.split('&')[2]);
				result=sprintfImg(res.split('&')[3]);
				$('.product_img').html(result);
				smallImgClick();
				abc();
			},
			error:function(){
				console.log('Ajax bug');
			}
		});
	};

	//提取页面中的商品名称模板,替换类容
	function sprintfName(arry){
		var name=$('.name').html();
		return name.replace(/%s/g,arry);
	};


	//提取页面中的商品价格模板,替换类容
	function sprintfMuch(arry){
		var name=$('.much').text();
		return name.replace(/%s/g,arry);
	};

	function sprintfshuxing(arry){
		var Yleft='<div class="style_l">'+
			$('.shuxingwrap .style_l').html()+
			'</div>';
		var Yright=
			'	<li>'+
			'		<span>%s</span>'+
			'		<b></b>'+
			'	</li>';
		var content=arry.split(';');
		var html='';
		for(var i=0,len=content.length-1;i<len;i++){
			var xiaoshuxing=content[i].split(':')[1].split(',');
			var dashuxing=content[i].split(':')[0];
			var left=Yleft.replace(/%s/g,dashuxing);
			var right=''
			for(var j=0;j<xiaoshuxing.length;j++){
				right=right+Yright;
				right=right.replace(/%s/g,xiaoshuxing[j]);
			}
			right=
			'	<div class="style_r">'+
			'		<ul class="style_r_ul">'+
					right.trim()+	
			'		</ul>'+
			'	</div>';
			html=html+left+right;
		}
		$('.shuxingwrap').html(html.trim());
		shuxingselect();
	};

	//提取页面中的商品图片模板,替换类容
	function sprintfImg(arry){
		var imgURL=$('.product_img').html();
		var url=arry.split(',');
		var i=0;
		return imgURL.replace(/%s/g,function(){
			return (i<url.length) ? url[i++] :'';
		});
	};

	//鼠标点击小图片，使小图片放在大图位置
	function smallImgClick(){
		$('.product_imgul img').click(function(){
			var img=$(this).attr('src');
			$('.product_bimg img').attr('src',img);
		});
	};


	//点击加入购物车，把商品加入自己的购物车
	$('.buy').click(function(){
		if(getCookie('username')==null){
			$('.lock').show();
		}else{
			var who=getCookie('username');
			var name=$('.name').text();
			var price=$('.much').text();
			var shuxing='';
			$('.style_r_ul b').each(function(){
				if($(this).css('display')=='block'){
					shuxing=shuxing.trim()+$(this).parents('.style_r').prev().text().replace(/(^\s*)|(\s*$)/g,"");
					//alert(shuxing)
					shuxing=shuxing+$(this).prev().text().replace(/(^\n*)|(\n*$)/g,"")+';';
				}
			});
			//alert('buyer='+who+'poduct_name='+name+'product_price='+price+'product_oher='+shuxing);
			$.ajax({
				type:'post',
				url:'../servlet/productShopAction',
				data:'buyer='+who+'&poduct_name='+name+'&product_price='+price+'&product_oher='+shuxing,
				success:function(res){
					var res=res.trim();
					if(res==1){
						$('.onelock').show();
					}
				}
			});
		}
	});

	//点击关，关闭
	$('#sidepanal b').click(function(){
		$('.lock').hide();
	});
	













})();







