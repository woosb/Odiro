console.log("tourService ........");

var getAPI = (function(){
	
	function getList(listUrl, callback, errir){
		console.log("getList.....");
		
		$.getJSON(listUrl, function(data){
			if(callback){
				callback(data);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	return{
		getList : getList
	};
	
})();