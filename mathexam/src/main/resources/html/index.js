function insert(){
	console.log("insert")
	var options = $("#options")
	var html = options.html()
	//获取div中input标签的数量，再与'A'的acsii相加，然后转化为字母
	var ch = String.fromCharCode(65 + options.children("input").length)
	var str = '<input type="radio" name="options" value="' + ch + '">' + ch + '</input>'
	options.append(str)
}