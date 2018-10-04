var urlPrefix = 'http://localhost:8003'



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


function deleteByQuestionId(questionId){
	$.ajax({
		url: urlPrefix + "/question/delete?questionId=" + questionId,
		success: function(){
			listAllQuestion()
		}
	})
}

function listAllQuestion(){
	listQuestionsByUnitId(0)
	listQuestionsByUnitId(1)
	listQuestionsByUnitId(2)
}

function listQuestionsByUnitId(unitId){
	$.ajax({
		url: urlPrefix + "/question/listQuestionByUnitId?unitId=" + unitId,
		success: function(res){
			console.log(unitId, res)
			var div = $("#unit" + unitId)
			div.html("")
			for(obj in res){
				console.log(res[obj].content)
				div.append('----' + res[obj].content + '&nbsp;&nbsp;<button onclick="deleteByQuestionId(' + 
					res[obj].questionId + ')"s>删除</button><br>')
			}
			
		}
	})
}

function setInputVal(){
	var t = new Date().getTime()
	$("#hidden_input1").val(t)
	$("#hidden_input2").val(t)
}