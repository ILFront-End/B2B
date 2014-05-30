(function(){

	//检查是否有用户
	//检查是否有用户
	$(function(){
		if(getCookie("username")!=null){
			var text=
					'<ul>'+
						'<li>'+
							'<span>'+
							getCookie("username")+'你好！欢迎来到we shop'+
							'</span>'+
						'<>'+
						'<li>'+
							'<span><a class="tuichu" href="homepage.html">退出</a></span>'+
						'<>'+
					'</ul>';
			$('.shortcut_right').html(text);
			//点击退出，退出当前用户
			$('a.tuichu').click(function(event){
				event.preventDefault();
				unsetCookie("username");
				var text=
							'<ul>'+
							'	<li>'+
							'		<span>'+
							'			<a href="login.html">[登录]</a>'+
							'			<a href="sign_up.html">[免费注册]</a>'+
							'		</span>'+
							'	<>'+
							'</ul>';
					$('.shortcut_right').html(text);
			});
		}else{
		}
	})

	//点击购物车和我的we shop进入个人管理页面
	$('.styletitle a').click(function(){
		event.preventDefault();
		if(getCookie("username")==null){
			window.open('login.html','_parent');
		}else{
			window.open('user.html','_blank');
		}
	});

	//加载下拉列表的值
	NaviContent();
	function NaviContent(){
		for(var n in navicontent){
			var htm=[];
			for(var i in navicontent[n]){
				for(var j in navicontent[n][i]){
					if(j=='strong'){
						var str=
							'           <p>'+
							'           <strong><a href="ProductIntro.html">'+navicontent[n][i][j]+'</a></strong> '
							'           </p>';
						htm.push(str);
					}else{
						var str='           <dl class="species_float wrap">';
						htm.push(str);
						for(var k=0;k<navicontent[n][i][j].length;k++){
							var str=
								'            	<dd>'+
								'            		<i></i>'+
								'             		<span><a href="ProductIntro.html">'+navicontent[n][i][j][k]+'</a></span>'+
								'            	</dd>';
							htm.push(str);
						}
						var str=	'	       	</dl>';
						htm.push(str);
						var str='           <hr>';
						htm.push(str);
					}
				}
			}
			htm.length=htm.length-1;
			$('.species_left').eq(n-1).html(htm.join(''));
			clickTwoA();
			clickthreeA();
		}		
	};

	//第一级中的a链接标签
	clickOneA();
	function clickOneA(){
		$('.body_navi_left a').click(function(){
			event.preventDefault();
			var text='1&s='+$(this).text();
		    setCookie("productName",text,"./");
			window.open('ProductIntro.html','_parent');
		});
	};

	//点击第二级中的a链接标签
	function clickTwoA(){
		$('.species_left strong a').click(function(){
			event.preventDefault();
			var text='2&s='+$(this).text();
		    setCookie("productName",text,"./");
			window.open('ProductIntro.html','_parent');
		});
	};	

	//点击第三级中的a链接标签
	function clickthreeA(){
		$('.species_float a').click(function(){
			event.preventDefault();
			var text='3&s='+$(this).text();
		    setCookie("productName",text,"./");
			window.open('ProductIntro.html','_parent');
		});
	};


})();