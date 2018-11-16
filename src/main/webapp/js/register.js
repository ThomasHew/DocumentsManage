/**
 * 
 */

function checkUser() {
	var userName = $("#userName").val();
	if (userName.replace(/^ +| +$/g, '') == '') {
		document.getElementById('userSpan').innerHTML = "用户名不能为空！"
	} else if (/^\d.*$/.test(userName)) {
		document.getElementById('userSpan').innerHTML = "用户名" + userName
				+ "格式不正确，用户名不能以数字开头"
		return;
	} else if (!/^[\u4E00-\u9FA5]{1,5}$|^[A-Za-z]{1,10}$/.test(userName)) {
		document.getElementById('userSpan').innerHTML = "用户名" + userName
				+ "格式不正确，最多5个中文或10个字母"
		return;
	}
	$.ajax({
		url : "/DocumentsManage/user/queryByUser.do",
		type : "post",
		data : {
			"userName" : userName
		},
		dataType : "json",
		success : function(data) {
			if (data != null) {
				$("#userSpan").text("用户名" + userName + "已存在");
				$("#userName").val('');
			} else if (data == null && userName != '') {
				$("#userSpan").text("");
			}
		}

	});
}
function checkPassword() {
	var password = document.getElementById("password").value;
	var spanNode = document.getElementById("passwordspan");
	// 密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
	var reg = /^([a-zA-Z0-9]){6,16}$/i;
	if (reg.test(password)) {
		// 符合规则  
		spanNode.innerHTML = ""

		return true;
	} else {
		// 不符合规则  
		spanNode.innerHTML = "密码的长度为 6-16，包含任意的字母、数字，不可以使用其他符号"
				.fontcolor("red");

		return false;
	}
}
// 确认密码
function checkSame() {
	var password = document.getElementById("password").value;
	var password2 = document.getElementById("password2").value;
	var spanNode = document.getElementById("passwordspan2");

	if (password == password2) {
		spanNode.innerHTML = "".fontcolor("green");
		document.getElementById("passwordclass2").className = "icon ticker";
		return true;
	} else {
		spanNode.innerHTML = "两次输入的密码不一致！".fontcolor("red");
		document.getElementById("passwordclass2").className = "icon into";
		return false;

	}
}

function checkmajorClass() {
	var majorClass = document.getElementById("majorClass").value;
	var spanNode = document.getElementById("majorClassSpan");

	var reg = /^\s*$/g;
	if (!reg.test(majorClass)) {
		// 符合规则  
		spanNode.innerHTML = ""

		return true;
	} else {
		// 不符合规则  
		spanNode.innerHTML = "班级不能为空".fontcolor("red");

		return false;
	}
}
function checkTelephone() {
	var telephone = document.getElementById("telephone").value;
	var spanNode = document.getElementById("TelephoneSpan");
	var reg = /^1[34578]\d{9}$/;
	if (reg.test(telephone)) {
		// 符合规则  
		spanNode.innerHTML = ""

		return true;
	} else if (/^[a-z0-9]\w+@[a-z0-9]+(\.[a-z]{2,3}){1,2}$/i.test(telephone)) {
		// 符合规则  
		spanNode.innerHTML = "".fontcolor("green");
		document.getElementById("emailclass").className = "icon ticker";
		return true;

	} else

	{
		// 不符合规则  
		spanNode.innerHTML = "请输入正确联系方式".fontcolor("red");

		return false;
	}

}
function checkGroupName() {
	var groupName = document.getElementById("groupName").value;
	var spanNode = document.getElementById("groupNameSpan");
	var reg = /^\s*$/g;
	if (!reg.test(groupName)) {
		// 符合规则  
		spanNode.innerHTML = ""

		return true;
	} else {
		// 不符合规则  
		spanNode.innerHTML = "小组名不能为空".fontcolor("red");

		return false;
	}

}
function checkAll() {
	var psw = checkPassword();

	var mjc = checkmajorClass();

	var tel = checkTelephone();
	var gn = checkGroupName();
//注册信息全部符合条件才能提交数据
	if (psw && mjc && tel && tel && gn) {

		return true;
	} else {
		return false;
	}

}
