<%@page import="Bean.DichVuBean"%>
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
    <div class="container mt-80">
		<form class="form-inline mt-5" action="AdminDichVuController">
			<div class="form-group">
				<label class="sr-only" for="madv">Mã dịch vụ:</label> 
				<input type="text" class="form-control" id="madv" name="txtmadv">
			</div>
			<div class="form-group">
				<label class="sr-only" for="tendv">Tên dịch vụ:</label> 
				<input type="text" class="form-control" id="tendv" name="txttendv">
			</div>
			<div class="form-group">
				<label class="sr-only" for="gia">Giá:</label> 
				<input type="text" class="form-control" id="gia" name="txtgia">
			</div>
			<div class="form-group">
				<label class="sr-only" for="gioithieu">Giới thiệu:</label> 
				<input type="text" class="form-control" id="gioithieu" name="txtgioithieu">
			</div>
			<div class="form-group">
				<label class="sr-only" for="anh">ảnh:</label> 
				<input type="text" class="form-control" id="anh" name="txtanh">
			</div>
			<div class="form-group">
				<label class="sr-only" for="maloai">Mã loại:</label> 
				<input type="text" class="form-control" id="maloai" name="txtmaloai">
			</div>
			<button type="submit" class="btn btn-default border border-dark mt-4" name="butadd">Thêm</button>
			<button type="submit" class="btn btn-default border border-dark mt-4" name="butupdate">Cập nhật</button>
		</form>
		<h4 class="mt-5">Danh sách Dịch Vụ:</h4>
		<table width="1000" align="center" class="mt-3 table table-hover">
			<tr>
				<th>Mã dịch vụ</th>
				<th>Tên dịch vụ</th>
				<th>Giá</th>
				<th>Giới thiệu</th>
				<th>Ảnh</th>
				<th>Mã loại</th>
				<th></th>
			</tr>
			<c:forEach var="dv" items="${dsdichvu}">
			<tr>
				<td>${dv.getMadv()}</td>
				<td>${dv.getTendv()}</td>
				<td>${dv.getGia()}</td>
				<td>${dv.getGioithieu()}</td>
				<td><img class="img-thumbnail" alt="chua them anh" src="${dv.getAnh()}"></td>
				<td>${dv.getMaloai()}</td>
				<td><a class="text-decoration-none" href="AdminDichVuController?mdv=${dv.getMadv()}&tab=xoa">Xóa</a> </td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>