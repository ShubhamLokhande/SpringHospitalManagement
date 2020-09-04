var recepList = recepList || (function(){
	return {
		loadPage : function(){
			$.ajax({
				url : Api.prepareUrl('/reception/listTrue'),
				method : 'POST',
				contextType : 'application/json',
				success : function(data){
					Api.showActiveRecep(true);
					recepList.populateTbl(data, 'delete');
				}
			});
		},
		
		populateTbl : function(data, status){
			for(var i = 0; i < data.length; i++){
				var row = $('<tr>');
				var arr = [];
				
				arr.push(data[i].recepId);
				arr.push(data[i].name);
				arr.push(data[i].email);
				arr.push(data[i].password);
				arr.push(data[i].gender);
				arr.push(data[i].qual);
				arr.push(data[i].dob);
				arr.push(data[i].mobileNo);
				
				$.each(arr, function(index, td) {
					row.append('<td>' + td + '</td>');
			 	});
				var delBtn = null;
				if(status == 'delete'){
					delBtn = $("<td class='btn-group'><p><button type='button' class='btn btn-warning mx-1' value=" + data[i].email+
						" onclick='recepList.editReception(this.value)'>Edit</button></p>" +
						"<p><button type='button' class='btn btn-danger  mx-1' value=" + data[i].recepId+
						" onclick='recepList.deleteReception(this.value)'>Delete</button></p></td>");
				} else {
					delBtn = $("<td><button type='button' class='btn btn-success  mx-1' value=" + data[i].recepId+
						" onclick='recepList.activeReception(this.value)'>Active</button></td>");
				}
				row.append(delBtn);
				$("#recepTbl").append(row);
			}
		},
		
		view : function(status){
			var path = Api.prepareUrl('/reception/listTrue');
			if(status == 'deleted'){
				path = Api.prepareUrl('/reception/listFalse');
			}
			$.ajax({
				url : path,
				method : 'POST',
				contextType : 'application/json',
				success : function(data){
					$("#recepTbl td").remove();
					if(status == 'deleted'){
						Api.showActiveRecep(false);
						recepList.populateTbl(data, "active");
					} else {
						Api.showActiveRecep(true);
						recepList.populateTbl(data, "delete");
					}
				}
			});
		},
		
		deleteReception : function(id){
			$.ajax({
				url : Api.prepareUrl('/reception/delete/'+id),
				method : 'POST',
				success : function(data){
					recepList.view('active');
				}
			});
		},
		
		activeReception : function(id){
			$.ajax({
				url : Api.prepareUrl('/reception/active/'+id),
				method : 'POST',
				success : function(data){
					recepList.view('deleted');
				}
			});
		},
		
		editReception : function(email){
			recepList.clearModel();
			$.ajax({
				url : Api.prepareUrl('/reception/'+email),
				method : 'POST',
				success : function(data){
					$('#inputRecepId').val(data.recepId);
					$('input[name="inputName"]').val(data.name);
					$('input[name="inputEmail"]').val(data.email);
					$('input[name="inputPassword"]').val(data.password);
					if(data.gender == 'Female'){
						$('#female').prop('checked', true);
					} else {
						$('#male').prop('checked', true);
					}
					$('input[name="inputQual"]').val(data.qual);
					$('input[name="inputDob"]').val(data.dob);
					$('input[name="inputMobileNo"]').val(data.mobileNo);
					$('#receptionModel').modal('show');
				}
			});
		},
		
		save : function(){
			var recepId = $('#inputRecepId').val();
			var name = $('input[name="inputName"]').val();
			var email = $('input[name="inputEmail"]').val();
			var password = $('input[name="inputPassword"]').val();
			var gender = $('input[name="inputGender"]:checked').val();
			var qual = $('input[name="inputQual"]').val();
			var dob = $('input[name="inputDob"]').val();
			var mobileNo = $('input[name="inputMobileNo"]').val();
			
			var recep = {
				recepId : recepId,
				name : name,
				email : email,
				password : password,
				gender : gender,
				qual : qual,
				dob : dob,
				mobileNo : mobileNo
			}
			
			$.ajax({
				url : Api.prepareUrl('/reception/save'),
				method : 'POST',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(recep),
				success : function(data){
					$('#receptionModel').modal('hide');
					recepList.view('active');
					recepList.clearModel();
				}
			});
		},
		
		clearModel : function(){
			$('#inputRecepId').val('');
			$('input[name="inputName"]').val('');
			$('input[name="inputEmail"]').val('');
			$('input[name="inputPassword"]').val('');
			$('#male').prop('checked', true);
			$('input[name="inputQual"]').val('');
			$('input[name="inputDob"]').val('');
			$('input[name="inputMobileNo"]').val('');
			$('input[name="inputAddress"]').val('');
		}
	}
})();
