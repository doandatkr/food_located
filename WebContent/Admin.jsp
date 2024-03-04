<%@page import="Bo.LoaiBo"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ẩm thực Huế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<!--NAVIGATION -->
	<div class="container-fluid p-0 fixed-top shadow-lg">
        <nav class="navbar bg-main-color navbar-expand-lg navbar-light ">
            <div class="container">
                <div class="d-flex ">
                    <img src="logo.svg" alt="">
                    <h1 class="m-0 p-0 ms-3 text-black d-flex flex-column justify-content-center navbar-brand">Ẩm thực Huế</h1>    
                </div>
                <div>
                	<ul class="list-group list-group-horizontal">
						<li role='button' class="bg-main-color h6 list-group-item mb-0 border border-0">
							<a href="AdminLoaiController" class="w-100 h-100 text-decoration-none link-dark">Quản lý loại</a>
						</li>
						<li role='button' class="bg-main-color h6 list-group-item mb-0 border border-0" data-bs-toggle="modal" data-bs-target="#showgiohang">
							<a href="AdminDichVuController" class="w-100 h-100 text-decoration-none link-dark">Quản lý dịch vụ</a>
						</li>
						<li role='button' class="bg-main-color h6 list-group-item mb-0 border border-0">
							<a href="AdminXacNhanController" class="w-100 h-100 text-decoration-none link-dark">Xác nhận đơn hàng</a>
						</li>
						<li role='button' class="bg-main-color h6 list-group-item mb-0 border border-0">
							<a href="AdminThongKeController" class="w-100 h-100 text-decoration-none link-dark">Thống kê</a>
						</li>
						<%  
						if(session.getAttribute("dn") == null){
						%>
							<li role='button' class="bg-main-color h6 list-group-item mb-0 border border-0">
								<a href="AdminDangNhapController" class="w-100 h-100 text-decoration-none link-dark">Đăng nhập</a>
							</li>
						<%}else if(session.getAttribute("dn") != null) { %>
							<li role='button' class="bg-main-color h6 list-group-item mb-0 border border-0">
								<a href="AdminDangXuatController" class="w-100 h-100 text-decoration-none link-dark">Đăng xuất <i class="bi bi-box-arrow-right"></i></a>
							</li>
						<%} %>
					</ul>
                </div>
            </div>
        </nav>
    </div>
    <table width="1000" align="center" class="table table-hover container mt-80">
		<tr> 
			<th>Họ tên</th>
			<th>Tên dịch vụ</th>
			<th>Giá</th>
			<th>Số lượng mua</th>
			<th>Thành tiền</th>
			<th>Xác nhận</th>
		</tr>
	<c:forEach var="xn" items="${dshoadon}" > 
		<tr>
			<td>${xn.getHoten()}</td>
			<td>${xn.getTendv()}</td>
			<td>${xn.getGia()}</td>
			<td>${xn.getSoluongmua()}</td>
			<td>${xn.getThanhtien()}</td>
			<td> <a href="AdminXacNhanController?mact=${xn.getMact()}">Xác nhận</a> </td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>