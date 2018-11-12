$(function(){
				$("form").submit(function(){
					
					//集中统一地做非空验证
					
					var flag=true;
					$("input[type!='submit']").each(function(element){
						
						if($(this).val()==""||$(this).val()==null){
							var $owner=$(this);
							$(this).next().text($owner.prop("id")+"不能为空").css({"display":"inline"});
							$owner.focus();
						    flag=false;
						    return false;
						}else{
							$(this).next().css({"display":"none"});
						}
						
					
					})
					
					if(parseInt($("#age").val())<18){
						var $owner=$("#age");
						$("#age").next().text($owner.prop("id")+"不能小于18").css({"display":"inline"});
						$owner.focus().select();
						flag=false;
					}
					
					return flag;

					
				})
			})