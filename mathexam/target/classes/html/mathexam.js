function insert(){
	console.log("insert")
	var options = $("#options")
	var answer = $("#answer")
	var html = options.html()
	//获取div中input标签的数量，再与'A'的acsii相加，然后转化为字母
	var ch = String.fromCharCode(65 + options.children("input").length)
	var str1 = ch + ' <input name="option' + ch + '"/><br>'
	options.append(str1)
	var str2 = '<input type="radio" name="answer" value="' + ch + '">' + ch + '</input>'
	answer.append(str2)
}

function listAllQuestion(){
	listQuestionsByUnitId(1)
	listQuestionsByUnitId(2)
	listQuestionsByUnitId(3)
}

function listQuestionsByUnitId(unitId){
	$.ajax({
		url: "http://localhost:8080/listQuestionByUnitId?unitId=" + unitId,
		success: function(res){
			var div = $("#unit" + unitId)
			div.html("hello" + unitId)
		}
	})
}