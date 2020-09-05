<%@ include file = "../common/customBaseUrl.jsp" %>
<%@ include file = "doctorModal.jsp" %>

<div class="container my-3">
  <div class="row">
    <div class="col-sm-6"><h4>All Doctor List</h4></div>
    <div class="col-sm-6 text-right">
        <button class="btn btn-success" type="button" class="" id="newDoc" data-toggle="modal" 
            onclick="doctorList.clearModel();" data-target="#doctorModal">Add Doctor</button>
        <button class="btn btn-primary" id="deletedDoc" onclick="doctorList.view('deleted')">View Deleted Doctor</button>
        <button class="btn btn-primary" id="activeDoc" onclick="doctorList.view('active')">View Active Doctor</button>
    </div>
  </div>
</div>
  
<div class="container table-responsive">
  <table class="table" id="doctorTbl">
    <thead class="thead-light">
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
        <th scope="col">Gender</th>
        <th scope="col">Qualification</th>
        <th scope="col">Date Of Birth</th>
        <th scope="col">Specialization</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 
  </table>
</div>
<script type="text/javascript" src="js/doctorList.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
  	doctorList.loadPage();
  });
</script>