

// A $( document ).ready() block.
$( document ).ready(function() {
    console.log( "ready!" );
    
    var init = function(i){
    	$.ajax({
    		type: 'GET',                     //GET or POST
    		url: "./all",               //請求的頁面
    		cache: false,                     //防止抓到快取的回應
    		success :function(result){
    			
    			var object = JSON.parse(result);
    			for(var i in object){
    				console.log(object[i].userId);
    				console.log(object[i].name);
    				$("#userTable").after("<tr><td>"+object[i].userId+"</td><td>"+object[i].number+"</td><td>"+object[i].name+"</td></tr>");
    			}
    		}
    	});

    }

    init(1);


});
