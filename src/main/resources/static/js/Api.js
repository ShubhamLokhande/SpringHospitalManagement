var Api = Api || (function(){
	return {
		prepareUrl : function(url){
			return baseUrlAjax + url;
		},
		
		showActiveDoc : function(status){
			if(status){
				this.showHide('deletedDoc','activeDoc');
				$("#newDoc").show();
			} else {
				this.showHide('activeDoc','deletedDoc');
				$("#newDoc").hide();
			}
		},
		
		showActiveUser : function(status){
			if(status){
				this.showHide('deletedUser','activeUser');
				$("#newUser").show();
			} else {
				this.showHide('activeUser','deletedUser');
				$("#newUser").hide();
			}
		},
		
		showActiveRecep : function(status){
			if(status){
				this.showHide('deletedRecep','activeRecep');
				$("#newRecep").show();
			} else {
				this.showHide('activeRecep','deletedRecep');
				$("#newRecep").hide();
			}
		},
		
		showHide : function(firstId, secondId){
			$("#"+firstId).show();
			$("#"+secondId).hide();
		}
	}
})();