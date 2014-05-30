$.validator.addMethod("phones",function(value,element){
    var regex=/1[358][012356789][\d]{8}/
    return regex.test(value);
},'电话号码格式不正确')

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
                minlength:2,
                maxlength:4
            },
            gongsiname:{
                required:true,
                 minlength:4,
                maxlength:12
            },
            phone:{
            	required:true,
                phones:true
            },
             address:{
                required:true
            }
        }
    });
});

$('.user').blur(function(){
    var value=$(this).val();
    
    $.ajax({
        type:'post',
        url:'../servlet/ChecKUseraction',
        data:'user='+value,
        success:function(res){
            var res=res.trim();
            if(res=='1'){   //此人已经存在，不能在注册
                var text='<label for="username" class="error">此用户已存在</label>';
                $('.user').parent().append(text);
            }else{  //此人不存在，可以注册

            }
        },
        error:function(){
            console.log('Ajax bug')
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
            url:'../servlet/ResigerAction',
            data:$('Form').serialize(),
            success:function(res){
                var res=res.trim();
                if(res=='1'){   //注册成功
                     $('.A').show();
                }
            },
            error:function(){
                console.log('Ajax bug');
            }
        });
    }
});


