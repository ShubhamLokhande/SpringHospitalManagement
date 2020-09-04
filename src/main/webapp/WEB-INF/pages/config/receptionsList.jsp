<%@ include file = "../common/customBaseUrl.jsp" %>
<%@ include file = "receptionModel.jsp" %>

<div class="container my-3">
  <div class="row">
    <div class="col-sm-6"><h4>All Reception List</h4></div>
    <div class="col-sm-6 text-right">
        <button class="btn btn-success" type="button" class="" id="newRecep" data-toggle="modal" 
            onclick="recepList.clearModel();" data-target="#recepModel">Add Reception</button>
        <button class="btn btn-primary" id="deletedRecep" onclick="recepList.view('deleted')">View Deleted Reception</button>
        <button class="btn btn-primary" id="activeRecep" onclick="recepList.view('active')">View Active Reception</button>
    </div>
  </div>
</div>
  
<div class="container table-responsive">
  <table class="table" id="recepTbl">
    <thead class="thead-light">
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
        <th scope="col">Gender</th>
        <th scope="col">Qualification</th>
        <th scope="col">Date Of Birth</th>
        <th scope="col">Mobile No</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 
  </table>
</div>
<script type="text/javascript" src="js/recepList.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
  	recepList.loadPage();
  });
</script>