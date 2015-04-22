var textarea = $("textarea");
   
textarea.attr('overflow', 'hidden');

textarea.keyup(function textAreaAdjust() {
	this.style.height = "1px";
	this.style.height = (25+this.scrollHeight)+"px";	
});