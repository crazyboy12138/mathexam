// var urlPrefix = 'http://localhost:8003'
// var urlPrefix = "http://119.29.9.243:8003"
var urlPrefix = "http://localhost:8003"



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

function listAllQuestionAndOptions(unitId){
	$.ajax({
		url: urlPrefix + "/question/listQuestionByUnitId?unitId=" + unitId,
		success: function(res){
			console.log(unitId, res)
			var div = $("#unit" + unitId + "_div")
			div.html("")
			var count = 1
			for(obj in res){
				console.log(res[obj].content)
				var str = '----题干：<textarea id="unit' + res[obj].questionId + '_modify">' + res[obj].content + 
					'</textarea>&nbsp;&nbsp;<button onclick="modifyContentByQuestionId(' + 
					res[obj].questionId + ')">修改</button><br>'
				div.append(str)
				console.log('questionStr', str)
				var options = JSON.parse(res[obj].options)
				var count = 0
				for(var o in options){
					var ch = String.fromCharCode(65 + count)
					var str = "--------选项：" + ch + ".&nbsp;<input type='text' value='" + options[o] + 
					"' id='" + (res[obj].questionId + '_' + count) +  "'></input>&nbsp;&nbsp;" +
					"<button onclick='modifyOptions(" + res[obj].questionId + ", " + count +
					")'>修改</button><br>"
					console.log('optionStr', str)
					div.append(str)
					count++
				}
			}
			
		}
	})
}

function modifyContentByQuestionId(questionId){
	var content = $("#unit" + questionId + "_modify").val()
	console.log('content', content)
	$.ajax({
		url: urlPrefix + "/question/modifyContentByQuestionId?questionId=" + questionId + "&content=" + content
	})
}

function modifyOptions(questionId, optionIndex){
	var content = $("#" + questionId + '_' + optionIndex).val()
	console.log('optionContent', content)
	$.ajax({
		url: urlPrefix + "/question/modifyOptions?questionId=" + questionId +
			"&optionIndex=" + optionIndex + "&content=" + content
	})
}



$(function(){
	$('#div_insert').click(function () {
		window.location.href='insert.html';
	});
	$('#div_delete').click(function () {
		window.location.href='delete.html';
	});
	$('#div_modify').click(function () {
		window.location.href='modify.html';
	});
})