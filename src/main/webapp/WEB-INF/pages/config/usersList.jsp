<%@ include file = "../common/customBaseUrl.jsp" %>
<%@ include file = "userModal.jsp" %>

<div class="container my-3">
  <div class="row">
    <div class="col-sm-6"><h4>All User List</h4></div>
    <div class="col-sm-6 text-right">
        <button class="btn btn-success" type="button" class="" id="newUser" data-toggle="modal" 
            onclick="userList.clearModel();" data-target="#userModal">Add User</button>
        <button class="btn btn-primary" id="deletedUser" onclick="userList.view('deleted')">View Deleted User</button>
        <button class="btn btn-primary" id="activeUser" onclick="userList.view('active')">View Active User</button>
    </div>
  </div>
</div>
  
<div class="container table-responsive">
  <table class="table" id="userTbl">
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
        <th scope="col">Address</th>
        <th scope="col">Action</th>
      </tr>
    </thead> 
  </table>
</div>
<script type="text/javascript" src="js/userList.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
  	userList.loadPage();
  });
</script>