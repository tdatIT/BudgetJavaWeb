<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Quản lý</title>
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
                                                   class="d-inline-block align-top" alt=""><strong> Quản Lý Chi
            Tiêu</strong></a>
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

                <c:if test="${sessionScope.username ne null}">
                <li class="nav-item">
                    <a class="nav-link" href="dang-xuat">Thoát</a>
                </li>
                </c:if>

        </div>
    </nav>
</div>
<div id="dashboard">

    <div class="container mb-2">
        <div class="row">
            <div class="col-md-4">
                Tháng xem
                <select id="month-select">
                    <option hidden selected>${month_request}</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-blue order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Tổng khoản chi</h6>
                        <h2 class="text-right"><i class="fa fa-cart-plus f-left"></i><span
                                class="money-value-1">${total_pay}</span></h2>
                        <p class="m-b-0">Tháng 08<span class="f-right">VNĐ</span></p>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-green order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Tổng khoản thu</h6>
                        <h2 class="text-right"><i class="fa fa-rocket f-left"></i><span
                                class="money-value-2">${total_income}</span></h2>
                        <p class="m-b-0">Tháng 08<span class="f-right">VNĐ</span></p>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-yellow order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Tiền kế hoạch</h6>
                        <h2 class="text-right"><i class="fa fa-refresh f-left"></i><span
                                class="money-value-3">${total_plan}</span></h2>
                        <p class="m-b-0">Đơn vị<span class="f-right">VNĐ</span></p>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-pink order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Số dư</h6>
                        <h2 class="text-right"><i class="fa fa-credit-card f-left"></i><span
                                class="money-value-4">${total}</span></h2>
                        <p class="m-b-0">Tháng 08<span class="f-right">VNĐ</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        var n = 1;
        while (n < 5) {
            var value = $('.money-value-' + n).text();
            $('.money-value-' + n).text(value.replace(/\B(?=(\d{3})+(?!\d))/g, " "));
            n++;
        }
    })
   $('#month-select').on('change',function (){
       var value = $(this).val();
       window.location = 'quan-ly?month='+value;
   })
</script>
</body>

</html>
