<div class="modal fade" id="doctorModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">

    <div class="modal-content">
<!-- Model Header Start Here -->
      <div class="mx-5">
        <div class="modal-header">
          <h4 class="modal-title">New Doctor Form</h4>
        </div>
      </div>
<!-- Model Header End Here -->

      <form class="mx-5" id="DoctorForm">
<!-- Model Body start here -->
        <div class="modal-body">
          <input type="hidden" name="action" value="inputDoctor">
          <input type="hidden" name="inputDoctorId" id="inputDoctorId">
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Name</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" name="inputName" autocomplete="off" 
                  placeholder="Enter Doctor Name"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Email</label>
            <div class="col-sm-9">
              <input type="email" class="form-control" name="inputEmail" autocomplete="off"
                  placeholder="Enter Doctor Email"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Password</label>
            <div class="col-sm-9">
              <input type="password" class="form-control" name="inputPassword" autocomplete="off"
                  placeholder="Password"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Gender</label>
            <div class="col-sm-9 my-auto">
              <div class="form-check-inline">
                  <label class="form-check-label">
                    <input type="radio" class="toggle" name="inputGender" id="male" value="Male" checked>Male
                  </label>
                </div>
                <div class="form-check-inline">
                  <label class="form-check-label">
                    <input type="radio" class="toggle" name="inputGender" id="female" value="Female">Female
                  </label>
                </div>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Qualification</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" name="inputQual" autocomplete="off"
                  placeholder="Enter Doctor Qualification"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Date of Birth</label>
            <div class="col-sm-9">
              <input class="form-control" type="date" name="inputDob"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">Specialization</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" name="inputExpertIn" autocomplete="off"
                  placeholder="Enter Doctor Specialization"/>
            </div>
          </div>
        </div>
<!-- Model body end here -->

<!-- model footer start here -->
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" onclick="doctorList.save()">Save changes</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
<!-- model footer end here -->
      </form>
    </div>
  </div>
</div>