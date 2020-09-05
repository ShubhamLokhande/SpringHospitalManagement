var userList = userList || (function(){
	return {
		loadPage : function(){
			$.ajax({
				url : Api.prepareUrl('/user/listTrue'),
				method : 'POST',
				contextType : 'application/json',
				success : function(data){
					Api.showActiveUser(true);
					userList.populateTbl(data, 'delete');
				}
			});
		},
		
		populateTbl : function(data, status){
			for(var i = 0; i < data.length; i++){
				var row = $('<tr>');
				var arr = [];
				
				arr.push(data[i].userId);
				arr.push(data[i].name);
				arr.push(data[i].email);
				arr.push(data[i].password);
				arr.push(data[i].gender);
				arr.push(data[i].qual);
				arr.push(data[i].dob);
				arr.push(data[i].mobileNo);
				arr.push(data[i].address);
				
				$.each(arr, function(index, td) {
					row.append('<td>' + td + '</td>');
			 	});
				var delBtn = null;
				if(status == 'delete'){
					delBtn = $("<td class='btn-group'><p><button type='button' class='btn btn-warning mx-1' value=" + data[i].email+
						" onclick='userList.editUser(this.value)'>Edit</button></p>" +
						"<p><button type='button' class='btn btn-danger  mx-1' value=" + data[i].userId+
						" onclick='userList.deleteUser(this.value)'>Delete</button></p></td>");
				} else {
					delBtn = $("<td><button type='button' class='btn btn-success  mx-1' value=" + data[i].userId+
						" onclick='userList.activeUser(this.value)'>Active</button></td>");
				}
				row.append(delBtn);
				$("#userTbl").append(row);
			}
		},
		
		view : function(status){
			var path = Api.prepareUrl('/user/listTrue');
			if(status == 'deleted'){
				path = Api.prepareUrl('/user/listFalse');
			}
			$.ajax({
				url : path,
				method : 'POST',
				contextType : 'application/json',
				success : function(data){
					$("#userTbl td").remove();
					if(status == 'deleted'){
						Api.showActiveUser(false);
						userList.populateTbl(data, "active");
					} else {
						Api.showActiveUser(true);
						userList.populateTbl(data, "delete");
					}
				}
			});
		},
		
		deleteUser : function(id){
			$.ajax({
				url : Api.prepareUrl('/user/delete/'+id),
				method : 'POST',
				success : function(data){
					userList.view('active');
				}
			});
		},
		
		activeUser : function(id){
			$.ajax({
				url : Api.prepareUrl('/user/active/'+id),
				method : 'POST',
				success : function(data){
					userList.view('deleted');
				}
			});
		},
		
		editUser : function(email){
			userList.clearModal();
			$.ajax({
				url : Api.prepareUrl('/user/'+email),
				method : 'POST',
				success : function(data){
					$('#inputUserId').val(data.userId);
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
					$('input[name="inputAddress"]').val(data.address);
					$('#userModal').modal('show');
				}
			});
		},
		
		save : function(){
			var userId = $('#inputDoctorId').val();
			var name = $('input[name="inputName"]').val();
			var email = $('input[name="inputEmail"]').val();
			var password = $('input[name="inputPassword"]').val();
			var gender = $('input[name="inputGender"]:checked').val();
			var qual = $('input[name="inputQual"]').val();
			var dob = $('input[name="inputDob"]').val();
			var mobileNo = $('input[name="inputMobileNo"]').val();
			var address = $('input[name="inputAddress"]').val();
			
			var user = {
				userId : userId,
				name : name,
				email : email,
				password : password,
				gender : gender,
				qual : qual,
				dob : dob,
				mobileNo : mobileNo,
				address : address
			}
			
			$.ajax({
				url : Api.prepareUrl('/user/save'),
				method : 'POST',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(user),
				success : function(data){
					$('#userModal').modal('hide');
					userList.view('active');
					userList.clearModal();
				}
			});
		},
		
		clearModal : function(){
			$('#inputUserId').val('');
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
