(function() {

	// 鼠标移到商品分类，显示分类的商品
	$('.fenlei').hover(function() {
		$('.h_body_navi').show();
	}, function() {
		$('.h_body_navi').hide();
	});

	// 进入页面，先查看cookie product里面是什么，选择性的加载
	if (getCookie("productName") != null) {
		// alert(getCookie('productName'));
		$.ajax({
			type : 'post',
			url : '../servlet/GetKindofAction',
			data : 'message=' + getCookie('productName'),
			success : function(res) { // 返回的数据一定要是json数据
				if (res.length > 5) {
					var res = res.trim();
					var arry = res.split(',');
					var result = sprintf(arry);
					$('.contentul').html(result);
					theminforA();
					thenimgA();
				}
			},
			error : function() {
				console.log('Ajax bug');
			}
		});
	}

	// 提取页面中的模板,替换类容
	function sprintf(arry) {
		var text1 = $('.procuct_content .tO').html();
		var star = text1.indexOf('<') + 4;
		var last = text1.lastIndexOf('>') - 3;
		text1 = text1.slice(star, last);

		var text2 = $('.procuct_content .tW').html();
		star = text2.indexOf('<') + 4;
		last = text2.lastIndexOf('>') - 3;
		text2 = text2.slice(star, last);

		var text3 = $('.procuct_content .tT').html();
		star = text3.indexOf('<') + 4;
		last = text3.lastIndexOf('>') - 3;
		text3 = text3.slice(star, last);

		var text = '';
		for (var j = 0; j < arry.length / 4; j++) {
			if (j + 1 == 1) {
				text = text + text1;
			} else if ((j + 1) % 5 == 0) {
				text = text + text3;
				j++;
				if ((j + 1) < arry.length / 4) {
					text = text + text1;
				}
			} else {
				text = text + text2;
			}
		}
		var i = 0;
		return text.replace(/%s/g, function() {
			return (i < arry.length) ? arry[i++] : '';
		});
	}
	;

	// 点击文字连接，连接到下一页
	function theminforA() {
		$('.themeinfo a').click(function() {
			event.preventDefault();
			var imgURL = $(this).text();
			setCookie("productURL", imgURL, "./");
			window.open('product.html', '_parent');
		});
	}
	;

	// 点击图片连接，跳转到下一页
	function thenimgA() {
		$('.themeimg a').click(function() {
			event.preventDefault();
			var imgURL = $(this).parent().next().find('a').text();
			setCookie("productURL", imgURL, "./");
			window.open('product.html', '_parent');
		});
	}
	;

})();
