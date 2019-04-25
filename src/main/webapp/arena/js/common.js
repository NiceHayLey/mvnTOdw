$(function(){
	var $tabBtn = $(".tabmenu .btn-area a");
	var $tabCon = $('.tab-area .cont');
	$tabBtn.on('click', function(){
		var idx =$(this).index();
		$tabCon.css('display','none');
		$tabBtn.removeClass('on');
		$tabCon.eq(idx).css('display','block');
		$tabBtn.eq(idx).addClass('on');
	});
});