<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Đăng ký tài khoản</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/assets/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="view/assets/img/favicon.ico">
</head>

<body>
<div id="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <a class="navbar-brand m-4" href="trang-chu"> <img src="view/assets/img/favicon.png" width="30" height="30"
                                                   class="d-inline-block align-top" alt=""><strong> Quản Lý Chi Tiêu</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="quan-ly">Quản Lý<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="nhap-du-lieu">Nhập dữ liệu</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div id="login">
    <div class="login-dark">
        <form method="post" action="dang-ky" style="padding:40px">
            <c:if test="${notify}equ false">
                <a href="#" class="forgot">Đăng nhập thất bại</a>
            </c:if>
            <div class="illustration"><i class="fa fa-lock" aria-hidden="true"></i></div>
            <div class="form-group"><input class="form-control" type="text" name="username" placeholder="Tài khoản">
            </div>
            <div class="form-group"><input class="form-control" type="password" name="password"
                                           placeholder="Mật khẩu"></div>
            <div class="form-group"><input class="form-control" type="password" name="re-password"
                                           placeholder="Xác nhận mật khẩu"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Đăng ký</button></div>
            <a href="#" class="forgot">Đăng ký</a>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="view/assets/main.js"></script>
<script src="https://kit.fontawesome.com/ae7c745789.js" crossorigin="anonymous"></script>
</body>

</html>
