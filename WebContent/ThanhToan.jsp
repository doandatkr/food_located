<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="style.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-5">
		<% long mahd = (long)request.getAttribute("mahd"); %>
        
        <div class="d-flex mt-3">
            <div class="flex-fill mw-50"><img class="img-thumbnail" src="myQR.png" alt=""></div>
            <div class="flex-fill">
                <h6>Ngân hàng: Viettinbank</h6>
                <h6>Tên: DOAN THANH DAT</h6>
                <h6>STK: 1092783648</h6>
                <h6>Nội dung: [mã_hóa_đơn]-[họ_tên] </h></m></h6>
                <h6>Mã hóa đơn: </h6><%=mahd%>
            </div>
        </div>
        <a href="DichVuController" type="button" class="btn btn-secondary mt-5">
            Quay về trang chủ!
        </a>
    </div>
</body>
</html>