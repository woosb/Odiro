console.log("memberDetail.........");

var getDetail = (function(){
	
	function getMyWishList(e_mail, callback){
		console.log("getMyWishList.....");
		
		$.ajax({
			url:"/memberDetail/getWishList/"+e_mail,
			data: e_mail,
			type:"GET",
			success : 
				function(data){
					if(callback){
						callback(data);
					}
			},
			error :
				function (data){
				alert("연결실패");
			}
		});
	}
	
	function getAPIList(url, callback){
		console.log("getList.....");
		$.getJSON(url, function(data){
			if(callback){
				callback(data);
			}
		});
	}
	
	function deleteList(contentId, contentTypeId){
		console.log("deleteList......");
		$.ajax({
			url:"/memberDetail/delete/"+contentId+"/"+contentTypeId,
			type:"delete",
			success:function(data){
			},
		});
	}

	return{
		getMyWishList : getMyWishList,
		getAPIList : getAPIList,
		deleteList : deleteList,
	};
})();