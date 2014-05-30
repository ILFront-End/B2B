(function(){

    //进入页面，先判断用户是谁
    if(getCookie("username")!=null){
        $('.ownname span').text(getCookie('username'));
    }

    //点击左边，显示对应的项
    $('.tab').click(function(){
        var value=$.trim($(this).text());
        var index;
        $('.myright').children().hide();
        if(value=='我的购物车'){
            $('.tab').removeClass('tabselect').eq(0).addClass('tabselect');
            $('#gouwuche').show();
        }else if(value=='我买到的宝贝'){
            $('.tab').removeClass('tabselect').eq(1).addClass('tabselect');
            $('#yimaide').show();
            //请求加载我买到的宝贝
            buybaobei();
        }else if(value=='我卖出的宝贝'){
            $('.tab').removeClass('tabselect').eq(2).addClass('tabselect');
            $('#yimaichu').show();
            //请求加载我卖出的宝贝
            sellbaobei();
        }else if(value=='发布商品信息'){
            $('.tab').removeClass('tabselect').eq(3).addClass('tabselect');
            $('#fabu').show();
            if($('.fabuthree .fabuotable').text().trim()==''){
                onloadConnect();
            }
        }
    });

    //三级连动下拉选择框加载
    (function(){

        var classes1Select = $('#selectone');
        var classes2Select = $('#selecttwo');
        var classes3Select = $('#selectthree');

        var linkage = {
            init: function(){
                this.addone();
                classes1Select.change(function(){
                    linkage.addtwo();
                });
                classes2Select.change(function(){
                    linkage.addthree();
                });
            },

            addone: function(){
                var html=[];
                for(var i in mulu){
                    var x=
                        '<option value="'+i+'">'+
                        mulu[i].txt+'</option>';
                    html.push(x);
                }
                document.getElementById('selectone').length=1;
                var yuhtml=classes1Select.html();
                classes1Select.html(yuhtml+html.join(''));
            },

            addtwo: function(){
                var selectvalue=$.trim(classes1Select.val());
                var classes2es = mulu[selectvalue].children;
                var html=[];
                for(var i in classes2es){
                    var x=
                        '<option value="'+i+'">'+
                        classes2es[i].txt+'</option>';
                    html.push(x);
                }
                document.getElementById('selecttwo').length=1;
                var yuhtml=classes2Select.html();
                classes2Select.html(yuhtml+html.join(''));
            },

             addthree: function(){
                var selectOneValue=$.trim(classes1Select.val());
                var selectTwoValue=$.trim(classes2Select.val());
                var classes3es = mulu[selectOneValue]
                    .children[selectTwoValue].children;
                var html=[];
                for(var i in classes3es){
                    var x=
                        '<option value="'+i+'">'+
                        classes3es[i].txt+'</option>';
                    html.push(x);
                }
                document.getElementById('selectthree').length=1;
                var yuhtml=classes3Select.html();
                classes3Select.html(yuhtml+html.join(''));
            }
        };
        linkage.init();
    })();

   // 点击上传文件上传图片
	$('.ulimg input:file').change(function() {
		// setImagePreview($(this));
		var id = $(this).attr('id');
		// alert(id);
		changImg(id);

	});
	

	// 用插件上传图片

	function changImg(id) {

		$.ajaxFileUpload({
			url : '../servlet/upload', // 上传文件的服务端
			secureuri : false, // 是否启用安全提交
			dataType : 'text', // 数据类型
			fileElementId : id, // 表示文件域ID

			// 提交成功后处理函数 html为返回值，status为执行的状态
			success : function(res) {
				var res = res.trim();
				$('.re input:file').each(function() {
					if ($(this).attr('id').trim() == id) {
						$(this).prev().attr('src', res);
					}
				});
				// alert(res);

			},

			// 提交失败处理函数
			error : function(html, status, e) {

			}
		})

	}
	
	

	// 页面打开，加载联系方式
	var lianxifangshi;
	function onloadConnect() {

		$.ajax({
			type : 'post',
			url : '../servlet/GetUserInfo',
			data : 'user=' + $('.ownname span').text(),
			success : function(res) {
				var res = res.trim();
				var reses = res.split(',');
				lianxifangshi = reses;
				var html = '               <tbody><tr>'
						+ '                   <th>姓名：</th>'
						+ '                   <td>'
						+ '                       <span>'
						+ reses[0]
						+ '</span>'
						+ '                    </td>'
						+ '                    </tr>'
						+ '                    <tr>'
						+ '                         <th>公司名称：</th>'
						+ '                         <td>'
						+ '                             <span>'
						+ reses[1]
						+ '</span>'
						+ '                         </td>'
						+ '                    </tr>'
						+ '                    <tr>'
						+ '                         <th>电话号码：</th>'
						+ '                         <td>'
						+ '                             <span>'
						+ reses[2]
						+ '</span>'
						+ '                         </td>'
						+ '                     </tr>'
						+ '                     <tr>'
						+ '                          <th>电子邮件：</th>'
						+ '                          <td>'
						+ '                             <span>'
						+ reses[3]
						+ '</span>'
						+ '                          </td>'
						+ '                     </tr>'
						+ '                </tbody>';
				$('.fabuthree .fabuotable').html(html);
			},
			error : function() {
				console.log('ajax bug');
			}
		});
	}
	;

	// 点击发布信息，信息得到发布

	$('.fabufour').click(function() {
		var Data;
		var who = $('.ownname').text().trim();
		var pale = decodeURIComponent($('#fabuForm').serialize(), true)
		Data = pale + 'fenge' + who;
		var shu = $('#shuxing').val();

		for (var i = 0; i < 5; i++) {
			Data = Data + ',' + $('.uliamstyle').eq(i).attr('src');
		}

		for (var i = 0; i < 4; i++) {
			Data = Data + ',' + lianxifangshi[i];
		}/*
			 * alert(Data);
			 */
		// alert(Data);
		$.ajax({
			type : 'post',
			url : '../servlet/ProductAction',
			data : Data,
			success : function(res) {
				var res = res.trim();
				if (res == '1') { // 发布信息成功
					window.open('fabusuccess.html', '_parent');
				}
			},
			error : function() {
				console.log('Ajax bug');
			}
		});
	});

    //点击购物车里的删除，删除此项(如果此项是选中的，减钱)
    function Karremove(){
       $('.karselect').click(function(){
        var price=$(this).parents('tr').find('.fikar ')
                    .text();
        if($(this).parents('tr').find('.okar input').attr('checked')=='checked'){
            priceChage(price,"-");
       }
        var who=getCookie('username');
        var productname=$(this).parents('tr').find('.tkar').text();
        var shuxing=$(this).parents('tr').find('.thkar').text();
        var that=$(this);
        $.ajax({
        	type:'post',
        	url:'../servlet/DeleteShopAction',
        	data:'who='+who+'&product_name='+productname+'&shuxing='+$.trim(shuxing),
        	success:function(res){
        		
        		if(res.trim()==1){    //代表操作成功
        			  that.parents('tr').remove();
        		}
        	}
        });
          
        });
    };

    //点击购物车里的复选框，计算价钱
    function clickchebox(){
        $('.okar input').change(function(){
            var price=$(this).parents('tr').find('.xian').text();
           if($(this).attr('checked')=='checked'){
                priceChage(price,'+');
            }else{
                priceChage(price,'-');
            }
        });
    };
    
    //填写数量编辑框获得焦点，马上取得里面的值，
    //赋值给全局变量
    var prenum;
    function focusinput(){
        $('.fkar input').focus(function(){
            prenum=$(this).val();
        });
    };
    
    //填写数量，价钱改变
    function writeinput(){
       $('.fkar input').change(function(){
            var num=$(this).val();
            var danjia=$(this).parents('tr').find('.fkar span').text();
            var newmoney=(parseFloat(danjia)*num).toFixed(2);
            $(this).parents('tr').find('.fikar .xian').text(newmoney);
           if($(this).parents('tr').find('.okar') 
            .find('input').attr('checked')=='checked'){
            if(prenum>num){
                var n=prenum-num;
                var m=parseFloat(danjia).toFixed(2)*n;
                priceChage(m,'-');
            }else{
                var n=num-prenum;
                var m=parseFloat(danjia).toFixed(2)*n;
                priceChage(m,'+');
            }
           }
        }); 
    };
    
    //总计的价格改变，全传价钱和操作方式+或-
    function priceChage(price,str){
        var now=$('.hemoney').text(); 
        var newprice;
        if(str=='+'){
            newprice=parseFloat(now)+parseFloat(price);
        }else if(str=='-'){
            newprice=parseFloat(now)-parseFloat(price);
        }
        $('.hemoney').text(newprice.toFixed(2));
    };

    //点击结算，把名字和数量提交
    $('#button h1').click(function(){
        var goumaicookie='';
        var message='';
        $('.rank tbody .okar input').each(function(){
            if($(this).attr('checked')=='checked'){
                message=message+$(this).parents('tr').find('.tkar').text()+',';
                message=message+$(this).parents('tr').find('.fkar input').val()+','
                goumaicookie=goumaicookie+$(this).parents('tr').find('.karimg').attr('src')+',';
                goumaicookie=goumaicookie+$(this).parents('tr').find('.tkar').text()+',';
                goumaicookie=goumaicookie+$(this).parents('tr').find('.thkar').text()+',';
                goumaicookie=goumaicookie+$(this).parents('tr').find('.fkar span').text()+',';
                goumaicookie=goumaicookie+$(this).parents('tr').find('.fkar input').val()+',';
                goumaicookie=goumaicookie+$(this).parents('tr').find('.fikar ').text()+',';
            }
        });
        goumaicookie=goumaicookie+$('.hemoney').text();
        setCookie("goumaicookie",goumaicookie,"./");
        //alert(message);
        //得到数据，发送到服务器,服务器返回库存量是否超支
        $.ajax({
            type:'post',
            url:'../servlet/ComputeShop',
            data:'message='+message,
            success:function(res){
                var res=res.trim();
                if(res==0){     //0代表没有超支，可以
                    window.open('dingdan.html','_parent');
                }else{    //返回给我商品名字--代表此商品库存不足
                    alert('亲！'+res+'---商品库存不足噢(@﹏@)~ ');
                }
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    });

    //进入购物车页面，向服务器请求是谁要看自己的购物车，
    //请把数据给他
    $.ajax({
        type:'post',
        url:'../servlet/GetShopAction',
        data:'who='+getCookie('username'),
        success:function(res){
        	//alert(res);
        	if(res.length>5)
            var res=res.trim().split(',');  
            var result=sprintfgouwuche(res);
            $('.rank tbody').html(result);
            Karremove();
            clickchebox();
            focusinput();
            writeinput();
        },
        error:function(){
            console.log("Ajax bug");
        }
    });

    //提取页面中的购物车模板,替换类容
    function sprintfgouwuche(arry){
        var gouwuchehtml=
        	'              <tr>'+
			'					<td class="okar"><input type="checkbox"> <img'+
			'						class="karimg" src="%s" alt=""></td>'+
			'					<td class="tkar"><span> <a class="message" href="">%s</a>'+
			'					</span></td>'+
			'					<td class="thkar c"><span>%s</span></td>'+
			'					<td class="fkar c"><span class="yuan">%s</span> <br>'+
			'						数量： <input type="text" value="1"></td>'+
			'					<td class="fikar c"><span class="xian">%s</span></td>'+
			' 				<td class="skar c"><span class="karselect">删除</span></td>'+
			'				</tr>'	;
        var html='';
        for(var i=0;i<(arry.length/5);i++){
            html=html+gouwuchehtml;
        }
        var i=0;
        return html.replace(/%s/g,function(){
            return (i<arry.length) ? arry[i++] :'';
        });
    };

    //当点击侧边已买到的宝贝，请求-加载已买到的宝贝
    function buybaobei(){
        $.ajax({
            type:'post',
            url:'../servlet/BuyAction',
            data:'name='+getCookie('username'),
            success:function(res){
            	if(res.length>5)
            		{
               var res=res.trim().split(',');
               var result=sprintfuimaidao(res);
               $('#yimaide .aa').remove();
               $('#yimaide').append(result);
               jiaoyicaozuo();
               delect();
            		}
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    };

    //提取页面中已买到的宝贝模板,替换类容
    function sprintfuimaidao(arry){
        var gouwuchehtml=yimaidaode;
        var html='';
        for(var i=0;i<(arry.length/11);i++){
            html=html+gouwuchehtml;
        }
        var i=0;
        return html.replace(/%s/g,function(){
            return (i<arry.length) ? arry[i++] :'';
        });
    };

    //点击买家中交易操作，执行该操作
    function jiaoyicaozuo(){
        $('.pinlun a').click(function(){
            event.preventDefault();
            if($(this).text().trim()=='付款'){
                fukuangclick($(this));
            }else if($(this).text().trim()=='提醒卖家发货'){
                window.open('tixingfahuo.html','_parent');
            }else if($(this).text().trim()=='确认收货'){
                querenshouhuo($(this));
            }else if($(this).text().trim()=='追加评论'){
            	var imgurl=$(this).parents('.productmessage').find('.baobei img')
                .attr('src');
            setCookie("imgurl",imgurl,"./");
            var name=$(this).parents('.productmessage').find('.baobei span a')
                .text();
            setCookie("prouct_name",name,"./");
            //alert(name);
            window.open('pinglun.html','_blank');

            }
        });
    };

    //点击确认付款，把付款信息发送到服务器
    function fukuangclick(obj){//1表示是买家发的
        var dindanhao=obj.parents('.productmessage').prev().find('.num').text();
        $.ajax({
            type:'post',
            url:'../servlet/BuyToMoney',
            data:'dingdan='+dindanhao,
            success:function(res){   
                if (res.trim()==1) {  //表示订单信息更改成功
                    obj.parents('.product ').find('.zhuantai').text('等待发货');
                    obj.parents('.product ').find('.pinlun a').text('提醒卖家发货');
                };
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    };

    //点击买家中确认收货，把付款信息发送到服务器
    function querenshouhuo(obj){
        var dindanhao=obj.parents('.productmessage').prev().find('.num').text();
       // alert(dindanhao);
        $.ajax({
            type:'post',
            url:'../servlet/BuyShouhuoAction',
            data:'dingdan='+dindanhao,
            success:function(res){   
                if (res.trim()==1) {  //表示订单信息更改成功
                    obj.parents('.product ').find('.zhuantai').text('交易成功');
                    obj.parents('.product ').find('.pinlun a').text('追加评论');
                };
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    };

    
    //点击侧边我卖出的宝贝，请求我卖出的宝贝
    function sellbaobei(){
    	//alert(getCookie('username'));
        $.ajax({
            type:'post',
            url:'../servlet/SellAction',
            data:'name='+getCookie('username'),
            success:function(res){
            	//alert(res);
            	if(res.length>2)
            		{
               var res=res.trim().split(',');
               var result=sprintfmaichu(res);
            		
               $('#yimaichu .aa').remove();
               $('#yimaichu').append(result);
            		
               maichucaozuo();
            		
               delect();
            		}
            		
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    };

    //提取页面中已卖出宝贝模板,替换类容
    function sprintfmaichu(arry){
        var gouwuchehtml=yimaichu;
        var html='';
        for(var i=0;i<(arry.length/11);i++){
            html=html+gouwuchehtml;
        }
        var i=0;
        return html.replace(/%s/g,function(){
            return (i<arry.length) ? arry[i++] :'';
        });
    };

     //点击卖出交易操作，执行该操作
    function maichucaozuo(){
        $('.pinlun a').click(function(){
            event.preventDefault();
            if($(this).text().trim()=='发货'){
                fahuoclick($(this));
            }else if($(this).text().trim()=='无操作'){

            }else if($(this).text().trim()=='追加评论'){
                //先要把图片和名字保存起来，放在cookie中
            	var imgurl=$(this).parents('.productmessage').find('.baobei img')
                .attr('src');
                setCookie("imgurl",imgurl,"./");
            var name=$(this).parents('.productmessage').find('.baobei span a')
                .text();
            setCookie("prouct_name",name,"./");
            
            window.open('pinglun.html','_blank');

            }
        });
    };


    /*//点击追加评论，把订单号和商品名保存在cookie中
    function pingluncookie(){

    };*/

    //点击确认发货，把付款信息发送到服务器
    function fahuoclick(obj){//1表示是买家发的
        var dindanhao=obj.parents('.productmessage').prev().find('.num').text();
       // alert(dindanhao);
        $.ajax({
            type:'post',
            url:'../servlet/SellFahuoAction',
            data:'dingdan='+dindanhao,   //2代表卖家
            success:function(res){   
                if(res.trim()==1){   //1表示订单信息更改成功
                    obj.parents('.product ').find('.zhuantai').text('等待买家收货');
                    obj.parents('.product ').find('.pinlun a').text('无操作');
                }
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    }

    //点击订单中的删除，执行删除操作
    function delect(){
       $('.delete').click(function(){
            var zhuantai=$(this).parents('.product ').find('.zhuantai').text();
            if(zhuantai.trim()=='交易完成'){
                shanchufangfa($(this));
            }else{
                alert('交易进行中，不能删除此订单！');
            }
        });
    };
    

    //想服务器发送请求，提交删除这条订单
    function shanchufangfa(obj){
         var dindanhao=obj.parents('.productmessage').prev().find('.num').text();
        // alert(dindanhao);
         $.ajax({
            type:'post',
            url:'Ajax/shanchu.txt',
            data:dindanhao,
            success:function(res){
                var res=res.trim();
                if(res=='1'){  //1代表后台已经删除完成
                    obj.parents('.aa').remove();
                }
            },
            error:function(){
                console.log('Ajax bug');
            }
         });
    };


    //这是我买到的宝贝和我卖出的宝贝的模板
    var yimaidaode=
        '      <div class="aa">'+
        '            <div class="bianma">'+
        '               <ul class="wrap">'+
        '                  <li>'+
        '                        <span>订单编号：</span>'+
        '                        <span class="num">%s</span>'+
        '                    </li>'+
        '                    <li>'+
        '                       <span>成交时间：</span>'+
        '                       <span class="time">%s</span>'+
        '                    </li>'+
        '                   <li>'+
        '                      <span>卖主：</span>'+
        '                        <span>%s</span>'+
        '                    </li>'+
        '                </ul>'+
        '            </div>'+
        '            <div class="productmessage">'+
        '                <ul class="product wrap">'+
        '                    <li class="baobei li">'+
        '                        <img src="%s" alt="">'+
        '                        <span>'+
        '                            <a href="">%s</a>'+
        '                        </span>'+
        '                        <div class="shenme">'+
        '                            <span>%s</span>'+
        '                        </div>'+
        '                    </li>'+
        '                    <li class="danjia li">'+
        '                       <span class="monet">%s</span>'+
        '                        <br>数量%s'+
        '                    </li>'+
        '                    <li class="shifu li">'+
        '                        <span class="shijimoney">%s</span>'+
        '                    </li>'+
        '                    <li class="jiaoyi li">'+
        '                        <span class="zhuantai">%s</span>'+
        '                    </li>'+
        '                    <li class="caozuo li">'+
        '                        <span class="pinlun">'+
        '                            <a href="">%s</a>'+
        '                       </span>'+
        '                    </li>'+
        '                    <li class="qita li">'+
        '                        <span class="delete">删除</span>'+
        '                    </li>'+
        '                </ul>'+
        '            </div>'+
        '        </div>';
    
    
    
    
    var yimaichu=
        '      <div class="aa">'+
        '            <div class="bianma">'+
        '               <ul class="wrap">'+
        '                  <li>'+
        '                        <span>订单编号：</span>'+
        '                        <span class="num">%s</span>'+
        '                    </li>'+
        '                    <li>'+
        '                       <span>成交时间：</span>'+
        '                       <span class="time">%s</span>'+
        '                    </li>'+
        '                   <li>'+
        '                      <span>买主：：</span>'+
        '                        <span>%s</span>'+
        '                    </li>'+
        '                </ul>'+
        '            </div>'+
        '            <div class="productmessage">'+
        '                <ul class="product wrap">'+
        '                    <li class="baobei li">'+
        '                        <img src="%s" alt="">'+
        '                        <span>'+
        '                            <a href="">%s</a>'+
        '                        </span>'+
        '                        <div class="shenme">'+
        '                            <span>%s</span>'+
        '                        </div>'+
        '                    </li>'+
        '                    <li class="danjia li">'+
        '                       <span class="monet">%s</span>'+
        '                        <br>数量%s'+
        '                    </li>'+
        '                    <li class="shifu li">'+
        '                        <span class="shijimoney">%s</span>'+
        '                    </li>'+
        '                    <li class="jiaoyi li">'+
        '                        <span class="zhuantai">%s</span>'+
        '                    </li>'+
        '                    <li class="caozuo li">'+
        '                        <span class="pinlun">'+
        '                            <a href="">%s</a>'+
        '                       </span>'+
        '                    </li>'+
        '                    <li class="qita li">'+
        '                        <span class="delete">删除</span>'+
        '                    </li>'+
        '                </ul>'+
        '            </div>'+
        '        </div>';





})();























