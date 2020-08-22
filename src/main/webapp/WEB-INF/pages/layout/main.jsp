<%@ taglib uri = "http://tiles.apache.org/tags-tiles" prefix = "tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file = "../common/customBaseUrl.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset = "utf-8">
  <meta http-equiv = "X-UA-Compatible" content = "IE=edge">
  <meta name = "viewport" content = "width = device-width, initial-scale = 1, shrink-to-fit = no">
  <title>ZHospitalMgmt</title>

  <script src = "${baseURL}/bootstrap/jquery.3.5.1.js" type = "text/javascript"></script>
  <link href = "${baseURL}/bootstrap/bootstrap.min.css" rel = "stylesheet" type = "text/css">
  <script src = "${baseURL}/bootstrap/bootstrap.min.js" type = "text/javascript"></script>
  <script src="${baseURL}/js/Api.js" type="text/javascript"></script>
  <link href="${baseURL}/css/style.css" rel="stylesheet" type="text/css">
  
  <script type="text/javascript">
    var baseURL = "${baseURL}";
    var baseUrlAjax = baseURL;
  </script>
</head>

<body id = "page-top" class="flex min-vh-100">
  <div class = "wrapper">
    <div id = "content-wrapper" class = "d-flex flex-column">
      <div id = "content">
        <tiles:insertAttribute name="header"/>
        <div class = "container-fluid">
          <tiles:insertAttribute name = "body"/>
        </div>
      </div>
      <tiles:insertAttribute name = "footer"/>
    </div>
  </div>
</body>
</html>