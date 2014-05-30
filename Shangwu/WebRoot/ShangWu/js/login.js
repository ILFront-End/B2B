$(document).ready(function(){
    $('.Form').validate({
        rules:{
            username:{
                required:true,
                minlength:2,
            },
            email:{
                required:true,
                email:true
            },
            rpsd:{
            	required:true,
            	minlength:6,
            	maxlength:12
            },
            rrpsd:{
            	required:true,
                minlength:6,
                maxlength:12
            },
            rusername:{
            	required:true,
                minlength:6,
                maxlength:12
            },
            phone:{
            	required:true,
                phones:true
            }
        }
    });
});


$('input.submit').click(function(event){
    $('input.submit').submit();
    var t=true;
    $('label').each(function(){
        if($(this).css('display')=='block'){
            t=false;
        }
    });      
    if(t){
  
        $.ajax({
            type:'post',
            url:'../servlet/LoginAction',
            data:$('Form').serialize(),
            success:function(res){
                var res=res.trim();
                if(res=='1'){   //登录成功
                    $('.A').show(); 
                    setCookie("username",$('.user ').val(),"./");
					setTimeout(function(){
				      	$('.A').show();
				      	window.open('user.html','_parent');
					},2000);
                }else{
                	alert('用户名或是密码错误');
                }
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    }
});
