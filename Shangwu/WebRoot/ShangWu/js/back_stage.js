(function() {

	$('.aa').eq(0).css({
		'color' : '#2280ca',
		'border' : 'solid 1px wheat',
		'background' : 'wheat'
	});

	$('.aa').click(function() {
		$('.aa').css({
			'color' : 'wheat',
			'border' : 'solid 1px #2280ca',
			'background' : '#2280ca'
		});
		$(this).css({
			'color' : '#2280ca',
			'border' : 'solid 1px wheat',
			'background' : 'wheat'
		});
	});

	// 点击大标题，显示小标题
	$('#accordion h3').click(function() {
		var xiao = $(this).next('.AccordionContent');
		if (xiao.css('display') == 'block') {
			xiao.hide();
		} else {
			xiao.show();
		}

	});

	// 会员隔行变色
	$(function() {
		$('.rank tbody>tr:odd').addClass('odd');
		$('.rank tbody>tr:even').addClass('even');

	});

	// 会员选中变色
	$('.rank tbody>tr').click(
			function() {
				if ($(this).hasClass('selected')) {
					$(this).css('color', '#666').removeClass('selected').find(
							':checkbox').attr('checked', false);
				} else {
					$(this).css('color', 'red').addClass('selected').find(
							':checkbox').attr('checked', true);
				}
			});

	// 审核信息隔行变色
	function shehegehang() {
		$('.shenhe tbody>tr:odd').addClass('odd');
		$('.shenhe tbody>tr:even').addClass('even');
	}
	;

	// 点击slide小标题内容切换
	$('.xiaofen').click(function() {
		var value = $.trim($(this).text());
		$('.xiaofen').css('background', '#ddedfa');
		$(this).css('background', '#ccc');
		$('.allcontent').children().hide();
		if (value == 'VIP会员') {
			$('#huiyuan').show();
		} else if (value == '普通会员') {
			$('#huiyuan').show();
		} else if (value == '提醒卖家发货') {
			$('#tixingfahuo').show();
			if ($('.dingdan tbody').text().trim() == '') {
				loadproductfahuo();
			}
		} else if (value == '商品发布信息审核') {
			$('#xinxishenhe').show();
			if ($('.shenhe tbody').text().trim() == '') {
				loadproductshenhe();
			}
		} else if (value == '订单退订审核') {

		}
	});

	// 点击侧面信息审核，加载未审核的商品发布信息
	function loadproductshenhe() {
		$.ajax({
			type : 'post',
			url : '../servlet/AuditDao',
			data : '',
			success : function(res) {
				if(res.length>5)
					{
				var res = res.trim();
				var arry = res.split(';');
				var html = [];
				for (var i = 0; i < arry.length; i++) {
					var h = '		<tr>' + '			<td>' + arry[i].split(',')[0]
							+ '</td>' + '			<td>' + arry[i].split(',')[1]
							+ '</td>' + '			<td>' + '				<span>通过</span>'
							+ '				<span>不通过</span>' + '			</td>' + '		</tr>';
					html.push(h);
				}
					}
				$('.shenhe tbody').html(html.join(''));
				shehegehang();
				// 还有加入一个点击通过不通过的事件
				shenheclick();
			},
			error : function() {
				console.log('Ajax bug');
			}
			
		});
		
	}
	;

	// 点击通过或是不通过
	function shenheclick() {
		$('.shenhe td span').click(function() {
			var parent = $(this).parents('tr');
			var index = parent.index();
			var biaotu = parent.find('td').eq(0).text();
			var time = parent.find('td').eq(1).text();
			var str = $(this).text().trim()
			if (str == '通过') {
				$.ajax({
					type : 'post',
					url : '../servlet/ChangStateAction',
					data : 'flag=1&title=' + biaotu, // 1表示通过
					success : function(res) {
						if ((res.trim()) == "1") {
							$('.shenhe tbody tr').eq(index).remove();
						}
					},
					error : function() {
						console.log('Ajax bug');
					}
				});
			} else if (str == '不通过') {
				$.ajax({
					type : 'post',
					url : '../servlet/ChangStateAction',
					data : 'flag=0&title=' + biaotu, // 0表示通过
					success : function(res) {
						if ((res.trim()) == "1") {
							$('.shenhe tbody tr').eq(index).remove();
						}
					},
					error : function() {
						console.log('Ajax bug');
					}
				});
			}
		});
	}

	// 订单管理信息隔行变色
	function dingdanhang() {
		$('.dingdan tbody>tr:odd').addClass('odd');
		$('.dingdan tbody>tr:even').addClass('even');
	}
	;

	// 点击侧面订单管理，加载可发货信息
	function loadproductfahuo() {
		$.ajax({
			type : 'post',
			url : '../servlet/TixingMaiJiaAction',
			data : '',
			success : function(res) {
				if(res.length>=1)
					{
				var res = res.trim();
				var arry = res.split(',');
				var result = dingdanmupan(arry);
				$('.dingdan tbody').html(result);
				// 加载发货完成，隔行变色
				dingdanhang();
				// 点击可发货，执行可发货代码
				kefahuoclick();
					}
			},
			error : function() {
				console.log('Ajax bug');
			}
		});
	}
	;

	// 制作订单管理模板
	function dingdanmupan(arry) {
		var gouwuchehtml = '		<tr>' + '			<td>%s</td>' + '			<td>%s</td>'
				+ '			<td>' + '				<span>可发货</span>' + '			</td>' + '		</tr>';
		var html = '';
		for (var i = 0; i < (arry.length / 2); i++) {
			html = html + gouwuchehtml;
		}
		var i = 0;
		return html.replace(/%s/g, function() {
			return (i < arry.length) ? arry[i++] : '';
		});
	}
	;

	// 点击可发货，让卖家发货
	function kefahuoclick() {
		$('.dingdan').find('span').click(function() {
			// 通知卖家，可以发货
			var dingdan = $(this).parents('tr').children().eq(0).text();
			var name = $(this).parents('tr').children().eq(1).text();
			$.ajax({
				type : 'post',
				url : '../servlet/FahuoAction',
				data : 'dingdan=' + dingdan,
				success : function(res) { // 返回1表示已通知卖家发货
					if (res.trim() == '1') {
						alert('已通知卖家发货');
					}
				},
				error : function() {
					console.log('Ajax bug');
				}
			});
		});
	}
	;

})()
