<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Nhập Khoản Chi Tiêu</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/assets/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css "/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="view/assets/img/favicon.ico">
</head>

<body>
<div id="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <a class="navbar-brand m-4" href="#"> <img src="view/assets/img/favicon.png" width="30" height="30"
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

            </ul>
        </div>
    </nav>
</div>
<div id="table">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-1 col-md-12 ">
                <div class="panel">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-sm-12 col-xs-12">
                                <a data-toggle="modal" data-target="#addModal"
                                   class="btn btn-sm btn-primary pull-left"><i class="fa fa-plus-circle"></i>
                                    Thêm</a>
                                <a class="btn btn-sm pull-left" href="xuat-du-lieu?date=${current_day}"
                                   style="margin-left: 20px; background-color: #dc3545;">
                                    <i class="fa fa-file-excel-o"></i> Xuất ra file Excel
                                </a>
                                <!--Modal add data-->
                                <div class="modal fade" id="addModal" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="registration-form">
                                                <form id="add-form" method="post" action="add-data">
                                                    <div class="form-header">
                                                        Thêm dữ liệu
                                                    </div>
                                                    <div class="form-group">
                                                        <input name="title-add" type="text" class="form-control item"
                                                               id="title-add"
                                                               placeholder="Tên khoản" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <input name="value-add" type="text" class="form-control item"
                                                               id="value-add" placeholder="Giá trị" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <select name="type-add" id="type-add" class="form-control item"
                                                                required>
                                                            <option value="1" selected>Thu</option>
                                                            <option value="2">Chi</option>
                                                            <option value="3">Kế hoạch</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <input name="day-add" type="date" class="form-control item"
                                                               id="day-add" placeholder="Ngày tạo" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="submit" class="btn btn-block create-account"
                                                               value="Thêm mới">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--Edit modal-->
                                <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="registration-form">
                                                <form id="edit-form">
                                                    <div class="form-header">
                                                        Cập nhật
                                                    </div>
                                                    <input hidden type="text" value="" id="edit-id" required
                                                           name="edit-id">
                                                    <div class="form-group">
                                                        <input id="edit-title" name="edit-title" type="text"
                                                               class="form-control item" placeholder="Tên khoản"
                                                               required>
                                                    </div>
                                                    <div class="form-group">
                                                        <input id="edit-value" name="edit-value" type="edit-value"
                                                               class="form-control item" placeholder="Giá trị"
                                                               required>
                                                    </div>
                                                    <div class="form-group">
                                                        <select id="edit-type" class="form-control item" required
                                                                name="edit-type">
                                                            <option selected value="1">Thu</option>
                                                            <option value="2">Chi</option>
                                                            <option value="3">Kế hoạch</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <input name="edit-date" type="date" class="form-control item"
                                                               id="edit-date" placeholder="Ngày tạo" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit"
                                                                class="btn btn-block create-account">
                                                            Cập nhật
                                                        </button>
                                                    </div>
                                                    <div class="form-group">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--Confirm delete record-->
                                <div class="modal fade" id="removeRecordModal" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Xác nhận xóa</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Bạn có muốn xóa dòng dữ liệu này !</p>
                                            </div>
                                            <div class="modal-footer">
                                                <form id="remove-record-id">
                                                    <input id='remove-id' name="remove-id" type="text" hidden>
                                                    <button type="submit" class="btn btn-warning"
                                                            style="background-color: #dc3545">Xóa
                                                    </button>
                                                </form>
                                                <button class="btn btn-dark" data-dismiss="modal">Hủy</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <form class="form-horizontal pull-right" method="post" action="sort-day">
                                    <div class="form-group">
                                        <label>Từ ngày </label>
                                        <input id="date-sort" type="date" name="date-sort" value="${current_day}">
                                        <input type="submit" class="btn btn-success" value="Lọc">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body table-responsive">
                        <table class="table" id="#table-data">
                            <thead>
                            <tr>
                                <th>Chức năng</th>
                                <th>Tên khoản</th>
                                <th>Ngày</th>
                                <th>Giá trị</th>
                                <th>Loại</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${data}" var="i">
                                <tr id="record-no-${i.id}">
                                    <td>
                                        <ul class="action-list">
                                            <li><a class="edit-btn btn btn-primary" data-id="${i.id}"><i
                                                    class="fa fa-pencil-alt"></i></a></li>
                                            <li><a class="remove-record-btn btn btn-danger" data-id="${i.id}"><i
                                                    class="fa fa-times"></i></a>
                                            </li>
                                        </ul>
                                    </td>
                                    <td>${i.title}</td>
                                    <td>${i.createDay}</td>
                                    <td>${i.value}</td>
                                    <td>
                                        <c:if test="${i.type eq 1}">
                                             <span class="badge badge-success">
                                            <i class="fa fa-credit-card" aria-hidden="true"></i>
                                        </span>
                                        </c:if>
                                        <c:if test="${i.type eq 2}">
                                             <span class="badge badge-danger">
                                            <i class="fa fa-credit-card" aria-hidden="true"></i>
                                        </span>
                                        </c:if>
                                        <c:if test="${i.type eq 3}">
                                             <span class="badge badge-primary">
                                            <i class="fa fa-credit-card" aria-hidden="true"></i>
                                        </span>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-sm-6 col-xs-6 text-primary">"By Hacker Lỏd"</div>
                            <div class="col-sm-6 col-xs-6">
                                <ul class="pagination hidden-xs pull-right">
                                    <li><a href="nhap-du-lieu">Tải lại trang</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="view/assets/main.js"></script>
<script src="https://kit.fontawesome.com/ae7c745789.js" crossorigin="anonymous"></script>
<script>
    $(document).on('click', '.edit-btn', function (e) {
        var $row = $(this).closest("tr");
        var record_id = $(this).data("id");
        $('#edit-id').val(record_id);
        $('#edit-title').val($row.find("td:nth-child(2)").text());
        $('#edit-value').val($row.find("td:nth-child(4)").text());
        $('#edit-date').val($row.find("td:nth-child(3)").text());

        $('#editModal').modal('show');
    })
    $(document).on('click', '.remove-record-btn', function (e) {
        var id_record = $(this).data('id');
        $("#remove-id").val(id_record);
        $('#removeRecordModal').modal('show');
    })
    $(document).ready(function () {
        $('#remove-record-id').submit(function (e) {
                e.preventDefault();
            var form = $('#remove-record-id');
            $.ajax({
                type: "post",
                url: 'remove-data',
                data: form.serialize(),
                success: function (data) {
                    $('#removeRecordModal').modal('hide');
                    var id = $("#remove-record-id #remove-id").val();
                    $('#record-no-' + id).remove();
                },
                error: function (data) {
                    alert('Xóa thất bại !');
                }
            })
        })
    })
    $(document).ready(function () {
        $('#edit-form').submit(function (e) {
            e.preventDefault();
            var form = $('#edit-form');
            $.ajax({
                type: "post",
                url: 'update-data',
                data: form.serialize(),
                success: function (data) {
                    var id = $('#edit-id').val();
                    var title = $('#edit-title').val();
                    var value = $('#edit-value').val();
                    var date = $('#edit-date').val();
                    $('#record-no-' + id).find('td:eq(1)').text(title);
                    $('#record-no-' + id).find('td:eq(2)').text(date);
                    $('#record-no-' + id).find('td:eq(3)').text(value);
                    $('#editModal').modal('hide');
                },
                error: function (data) {
                    alert('Cập nhật thất bại');
                }
            })
        })
    })
</script>
</body>

</html>