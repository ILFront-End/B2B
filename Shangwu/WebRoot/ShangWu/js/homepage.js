(function(){

	function zuoyou(){

		var page=1;
		var imgnum=5;
		//右边滑过
		$('.jsscrollR').click(function(){
			var $_parent=$(this).parents('.jsscroll');
			var $_content=$_parent.find('.jsscrollcontent');
			var $_imgcroll=$_parent.find('.jsscrollwrap');
			var width=$_content.width()-2;
			var len=$_imgcroll.find('dd').length;
			var pag_count=Math.ceil(len/imgnum);
			if(!$_imgcroll.is(':animated')){
				if(pag_count==page){
				 $_imgcroll.animate({
				 	'left':'0px'
				 },'normal');
				 page=1;
			}else{
				$_imgcroll.animate({
				 	'left':'-='+width
				 },'normal');
				page++;
			}
			}
		});

		//左边的滑过
		$('.jsscrollL').click(function(){
			var $_parent=$(this).parents('.jsscroll');
			var $_content=$_parent.find('.jsscrollcontent');
			var $_imgcroll=$_parent.find('.jsscrollwrap');
			var width=$_content.width()-2;
			var len=$_imgcroll.find('dd').length;
			var pag_count=Math.ceil(len/imgnum);
			if(!$_imgcroll.is(':animated')){
				if(page==1){
				 $_imgcroll.animate({
				 	'left':'-='+width*(pag_count-1)
				 },'normal');
				 page=pag_count;
			}else{
				$_imgcroll.animate({
				 	'left':'+='+width
				 },'normal');
				page--;
			}
			}
		});
	};


	//秀场滑过
	$('.imgmove').hover(function(){
		var $_parent=$(this).parents('.tablelist');
		if(!$_parent.find('img').is(':animated')){
			var img=$_parent.find('img').animate({
			'left':'-10px'
			},200);
		}
	},function(){
		var $_parent=$(this).parents('.tablelist');
		var img=$_parent.find('img').animate({
			'left':'0'
		},200);
	});

	//最新上市小动画
	function huoguoshanshi () {
		$('.tanbutton span').hover(function(){
	    var $_parents=$(this).parent();
	    var $_cenpa=$_parents.parent();
	    var $_tabsortli=$_cenpa.find('.tabsortli');
		var index=$(this).index();
		var width=$_tabsortli.find('li').eq(index).width();
		var len=width*index;
		$_cenpa.find('span').css('background','#aaa').eq(index).css('background','#7ABD54');
		if(!$_tabsortli.is(':animated')){
			$_tabsortli.animate({
			 	'left':'-'+len
				 },'fast');
			}
	},function(){
	});
	}
	

	//打开页面，加载最新上市商品
	$.ajax({
		type:'post',
		url:'../servlet/HomePageNew',
		date:'1',
		success:function(res){
            //alert(res);
			var res=res.trim().split(',');
			res.length=res.length-1;
			var result=xin(res);
			$('.sortcontent').html(result);
			huoguoshanshi();
			xingren();
		},
		error:function(){
			console.log('Ajax bug');
		}
	});

	//提取页面中已买到的宝贝模板,替换类容
    function xin(arry){/*
    		alert(arry);*/
        var gouwuchehtml=zuixing;
        var i=0;
        return gouwuchehtml.replace(/%s/g,function(){
            return (i<arry.length) ? arry[i++] :'';
        });
    };



//打开页面，加载最新上市商品
	$.ajax({
		type:'post',
		url:'../servlet/HotProductAction',
		date:'2',
		success:function(res){
			var res=res.trim().split(',');
			res.length=res.length-1;
			var result=ren(res);
			$('.jsscroll').html(result);
			zuoyou();
			xingren();
		},
		error:function(){
			console.log('Ajax bug');
		}
	});


    //提取页面中热销的产品,替换类容
    function ren(arry){/*
    		alert(arry);*/
        var gouwuchehtml=rexiao;
        var i=0;
        return gouwuchehtml.replace(/%s/g,function(){
            return (i<arry.length) ? arry[i++] :'';
        });
    };

    var rexiao=
'			<div class="jsscroll_control jsscrollL">'+
'				<i></i>'+
'		</div>'+
'			<div class="jsscroll_control jsscrollR">'+
'				<i></i>'+
'			</div>'+
'			<div class="jsscrollcontent">'+
'				<dl class="jsscrollwrap">'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd class="s">'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd class="s">'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd class="s">'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd class="s">'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd class="s">'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'					<dd>'+
'						<a href="">'+
'							<img src="%s" alt="%s"></a>'+
'					</dd>'+
'				</dl>'+
'			</div>'+
'		</div>';


	var zuixing=
'		<div class="sortcontentul wrap" style="display:block">'+
'				<div class="sortli">'+
'					<a href="">'+
'						<img src="%s" alt="%s"></a>'+
'				</div>'+
'				<div class="sortli">'+
'					<div class="tabsorul">'+
'						<ul class="tabsortli wrap">'+
'							<li>'+
'								<a href="">'+
'									<img src="images/537ebc20Ne9614b31.jpg" alt=""></a>'+
'							</li>'+
'							<li>'+
'								<a href="">'+
'									<img src="images/537ebbebN7bf4953a.jpg" alt=""></a>'+
'							</li>'+
'							<li>'+
'								<a href="">'+
'									<img src="images/537ebc0dNaa5721d4.jpg" alt=""></a>'+
'							</li>'+
'							<li>'+
'								<a href="">'+
'									<img src="images/537ebbfdNb76f0859.jpg" alt=""></a>'+
'							</li>'+
'						</ul>'+
'					</div>'+
'					<div class="tanbutton">'+
'						<span class="spanselect"></span>'+
'						<span></span>'+
'						<span></span>'+
'						<span></span>'+
'					</div>'+
'				</div>'+
'				<div class="sortli">'+
'					<a href="">'+
'						<img src="%s" alt="%s"></a>'+
'				</div>'+
'				<div class="sortli">'+
'					<a href="">'+
'						<img src="%s" alt="%s"></a>'+
'				</div>'+
'			</div>';


	//鼠标点击秀场里的a链接标签
	clickxiuchangA();
	function clickxiuchangA(){
		$('a.imgmove').click(function(){
			event.preventDefault();
			var index=$(this).parent().index();
			var name;
			if(index==0){
				name='服饰内衣';
			}
			if(index==1){
				name='手机';
			}
			if(index==2){
				name='汽车用品';
			}
			if(index==3){
				name='运动户外';
			}
			if(index==4){
				name='家居';
			}
			if(index==5){
				name='个护化妆';
			}
			if(index==6){
				name='箱包';
			}
			if(index==7){
				name='母婴';
			}
			var text='1&s='+name;
		    setCookie("productName",text,"./");
			window.open('ProductIntro.html','_parent');
		});
	};

	//点击最新上架链接或者是热销商品链接

	function xingren(){
		$('.sortli a,.jsscrollwrap a').click(function(){
			event.preventDefault();
			var imgURL=$(this).children().attr('alt');
			setCookie("productURL",imgURL,"./");
			window.open('product.html','_parent');
		});
	};
		

	







})();