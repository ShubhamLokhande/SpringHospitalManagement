var doctorList = doctorList || (function(){
	return {
		loadPage : function(){
			$.ajax({
				url : Api.prepareUrl('/doctor/listTrue'),
				method : 'POST',
				contextType : 'application/json',
				success : function(data){
					Api.showActiveDoc(true);
					doctorList.populateTbl(data, 'delete');
				}
			});
		},
		
		populateTbl : function(data, status){
			for(var i = 0; i < data.length; i++){
				var row = $('<tr>');
				var arr = [];
				
				arr.push(data[i].doctorId);
				arr.push(data[i].name);
				arr.push(data[i].email);
				arr.push(data[i].password);
				arr.push(data[i].gender);
				arr.push(data[i].qual);
				arr.push(data[i].dob);
				arr.push(data[i].expertIn);
				
				$.each(arr, function(index, td) {
					row.append('<td>' + td + '</td>');
			 	});
				var button = null;
				if(status == 'delete'){
					delBtn = $("<td class='btn-group'><p><button type='button' class='btn btn-warning mx-1' value=" + data[i].email+
						" onclick='doctorList.editDoc(this.value)'>Edit</button></p>" +
						"<p><button type='button' class='btn btn-danger  mx-1' value=" + data[i].doctorId+
						" onclick='doctorList.deleteDoc(this.value)'>Delete</button></p></td>");
				} else {
					delBtn = $("<td><button type='button' class='btn btn-success  mx-1' value=" + data[i].doctorId+
						" onclick='doctorList.activeDoc(this.value)'>Active</button></td>");
				}
				row.append(delBtn);
				$("#doctorTbl").append(row);
			}
		},
		
		view : function(status){
			var path = Api.prepareUrl('/doctor/listTrue');
			if(status == 'deleted'){
				path = Api.prepareUrl('/doctor/listFalse');
			}
			$.ajax({
				url : path,
				method : 'POST',
				contextType : 'application/json',
				success : function(data){
					$("#doctorTbl td").remove();
					if(status == 'deleted'){
						Api.showActiveDoc(false);
						doctorList.populateTbl(data, "active");
					} else {
						Api.showActiveDoc(true);
						doctorList.populateTbl(data, "delete");
					}
				}
			});
		},
		
		deleteDoc : function(id){
			$.ajax({
				url : Api.prepareUrl('/doctor/delete/'+id),
				method : 'POST',
				success : function(data){
					doctorList.view('active');
				}
			});
		},
		
		activeDoc : function(id){
			$.ajax({
				url : Api.prepareUrl('/doctor/active/'+id),
				method : 'POST',
				success : function(data){
					doctorList.view('deleted');
				}
			});
		},
		
		editDoc : function(email){
			doctorList.clearModel();
			$.ajax({
				url : Api.prepareUrl('/doctor/'+email),
				method : 'POST',
				success : function(data){
					$('#inputDoctorId').val(data.doctorId);
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
					$('input[name="inputExpertIn"]').val(data.expertIn);
					$('#doctorModel').modal('show');
				}
			});
		},
		
		save : function(){
			var doctorId = $('#inputDoctorId').val();
			var name = $('input[name="inputName"]').val();
			var email = $('input[name="inputEmail"]').val();
			var password = $('input[name="inputPassword"]').val();
			var gender = $('input[name="inputGender"]:checked').val();
			var qual = $('input[name="inputQual"]').val();
			var dob = $('input[name="inputDob"]').val();
			var expertIn = $('input[name="inputExpertIn"]').val();
			
			var doctor = {
				doctorId : doctorId,
				name : name,
				email : email,
				password : password,
				gender : gender,
				qual : qual,
				dob : dob,
				expertIn : expertIn
			}
			
			$.ajax({
				url : Api.prepareUrl('/doctor/save'),
				method : 'POST',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(doctor),
				success : function(data){
					$('#doctorModel').modal('hide');
					doctorList.view('active');
					doctorList.clearModel();
				}
			});
		},
		
		clearModel : function(){
			$('#inputDoctorId').val('');
			$('input[name="inputName"]').val('');
			$('input[name="inputEmail"]').val('');
			$('input[name="inputPassword"]').val('');
			$('#male').prop('checked', true);
			$('input[name="inputQual"]').val('');
			$('input[name="inputDob"]').val('');
			$('input[name="inputExpertIn"]').val('');
		}
	}
})();
