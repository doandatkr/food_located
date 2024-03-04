<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <form   action="DangKyController" method="post" class="mb-md-5 mt-md-4 pb-5">
                            	<% 
                            	String m = request.getParameter("kt");
                            	long n = Long.parseLong(m);
                            	String str = (String)request.getAttribute("tb");	
                            	%>
                                <h2 class="fw-bold mb-2 text-uppercase mb-5">Đăng ký</h2>
								<% if(n==0){%>
									<p class="text-warning"> <i class="bi bi-exclamation-circle"></i></i> <%=str%></p>
								<%}else if(n==1){%>
									<p class="text-success"> <i class="bi bi-check-circle"></i> <%=str%></p>
								<%}else if(n==2){%>	
									<p class="text-danger"> <i class="bi bi-x-circle"></i> <%=str%></p>
								<%}else {%>	
									<p class="text-info"> <i class="bi bi-pen-fill"></i></i> Hãy nhập đầy đủ thông tin!</p>
								<%} %>
								<div class="form-outline form-white mb-4">
                                    <input type="text" id="typeName" class="form-control form-control-lg" name="txtname"/>
                                    <label class="form-label" for="typeName">Họ tên</label>
                                </div>
                                
                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="typePhone" class="form-control form-control-lg" name="txtphone"/>
                                    <label class="form-label" for="typePhone">Số điện thoại</label>
                                </div>
                                
                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="typeAddress" class="form-control form-control-lg" name="txtaddress"/>
                                    <label class="form-label" for="typeAddress">Địa chỉ</label>
                                </div>
                                
                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="typeUn" class="form-control form-control-lg" name="txtun"/>
                                    <label class="form-label" for="typeUn">Tài khoản</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg" name="txtpass"/>
                                    <label class="form-label" for="typePasswordX">Mật khẩu</label>
                                </div>
                                
                                <div class="form-outline form-white mb-4">
                                    <input type="password" id="typeRepeatPasswordX" class="form-control form-control-lg" name="txtrepeatpass"/>
                                    <label class="form-label" for="typeRepeatPasswordX">Nhập lại mật khẩu</label>
                                </div>

                                <button class="btn btn-outline-light btn-lg px-5" type="submit">register</button>
                            </form>

                            <div>
                                <p class="mb-0"> Trở về 
                                    <a href="DangNhapController" class="text-white-50 fw-bold">đăng nhập</a>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%if(request.getAttribute("kt")!=null){ %>
    	<h2>Đăng nhập sai</h2>
    <%} %>
    <script type="text/javascript">
    @import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css");
    </script>
</body>
</html>