/*
 * 用户登录的js基本验证
 * 
 */

$(function() {

	$(".admin_login_btn").click(function() {
		var account = $("#account");
		var password = $("#password");
		if (account.val() == "") {
			account.focus();
			return false;
		}
		if (password.val() == "") {
			password.focus();
			return false;
		}

		$.ajax({
			url : "login.do",
			type : "POST",
			data : {
				"account" : account.val(),
				"password" : password.val(),
				"time" : new Date().getTime()
			},
			dataType : "json",
			success : function(msg) {
				//alert(msg);
				if (msg == 1) {
					$(".link_pwd").html("用户名错误");
					return false;
				} else if (msg == 2) {
					$(".link_pwd").html("密码错误");
					return false;
				} else if (msg == 3) {
					// 正确
					location.href = 'main.do';
				}
			},
			error : function(er) {
				console.log(er);
			}
		});

	});

});