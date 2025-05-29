<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-car"/>
<c:url var="CarURL" value="/admin-car"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa xe</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="main-content container">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="/car/admin-home">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa xe</li>
            </ul>
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-${alert}">
                            ${messageResponse}
                        </div>
                    </c:if>
                    <form id="formSubmit" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Biển số xe</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="licensePlate" name="licensePlate" value="${model.licensePlate}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên xe</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Model</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="model" name="model" value="${model.model}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Brand</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="brand" name="brand" value="${model.brand}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Năm sản xuất</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" id="year" name="year" value="${model.year}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="description" name="description" value="${model.description}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Trạng thái</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="status" name="status" value="${model.status}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Giá thuê theo ngày</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" id="dayRate" name="dayRate" value="${model.dayRate}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Kiểu sở hữu</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="ownerType" name="ownerType" value="${model.ownerType}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12 text-center">
                                <c:choose>
                                    <c:when test="${not empty model.id}">
                                        <input type="button" class="btn btn-warning btn-bold" value="Cập nhật xe" id="btnAddOrUpdateCar"/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="button" class="btn btn-success btn-bold" value="Thêm xe" id="btnAddOrUpdateCar"/>
                                    </c:otherwise>
                                </c:choose>
                                <a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2 bigger-140" href="${CarURL}?type=list&page=1&maxPageItem=20&&sortName=licensePlate%20&&sortBy%20=asc">
											<i class="ace-icon fa fa-undo bigger-90"></i>
											Hủy </a> 
                            </div>
                        </div>
                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
$('#btnAddOrUpdateCar').click(function (e) {
    e.preventDefault();
    var data = {};
    var formData = $('#formSubmit').serializeArray();
   console.log(data),
    $.each(formData, function (i, v) {
    	if (v.name === "dayRate" || v.name === "year") {
            data[v.name] = parseInt(v.value);  // ép kiểu thành số nguyên
        } else {
            data[v.name] = v.value;
        }
    });
  
    var id = $('#id').val();
    if (id == null|| id=="") {
        addCar(data);
    } else {
        updateCar(data);
    } 
    

});
function addCar(data) {
	 console.log(data);
    $.ajax({
        url: '${APIurl}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        console.log (result),
        	window.location.href = "${CarURL}?type=edit&id="+result.id+"&message=insert_success";
        },
        error: function (er) {
        	console.log(er),
        	window.location.href = "${CarURL}?type=list&maxPageItem=20&page=1&message=error_system";
        }
    });
}
function updateCar(data) {
	
    $.ajax({
   
        url: '${APIurl}',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	
        	window.location.href = "${CarURL}?type=edit&id="+result.id+"&message=update_success";
        },
        error: function (er) {
        	

        	window.location.href = "${CarURL}?type=list&maxPageItem=20 &page=1&message=error_system";
        }
    });
}
</script>
</body>
</html>
