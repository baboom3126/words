<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="zh-TW">
<%@include file="../partial/header.jsp" %>
<style>
    audio {
        width: 100px;
    }
    red{
        color:red;
    }
</style>
<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <%@include file="../partial/topNavigation.jsp" %>


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Users <small>Some examples to get you started</small></h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">


                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Button Example <small>Users</small></h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Settings 1</a>
                                            </li>
                                            <li><a href="#">Settings 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <p class="text-muted font-13 m-b-30">
                                    The Buttons extension for DataTables provides a common set of options, API methods
                                    and styling to display buttons on a page that will interact with a DataTable. The
                                    core library provides the based framework upon which plug-ins can built.
                                </p>
                                <table id="wordTable"
                                       class="table table-striped table-bordered jambo_table dt-responsive nowrap center"
                                       cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>單字</th>
                                        <th>詞性</th>
                                        <th>createTime</th>
                                        <th>modifyTime</th>
                                        <th>remarks</th>
                                        <th>status</th>
                                        <th>action</th>
                                    </tr>
                                    </thead>
                                    <tbody id="wordTable_tbody">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- /page content -->

        <!-- footer content -->
        <%@include file="../partial/footer.jsp" %>
        <!-- /footer content -->
    </div>
</div>

<%@include file="../partial/scripts.jsp" %>
<script src="/public/js/moment.min.js"></script>

<script src="/public/js/SimpleWordList.js"></script>


<script src="/public/template/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/public/template/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/public/template/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="/public/template/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="/public/template/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="/public/template/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="/public/template/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="/public/template/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="/public/template/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="/public/template/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="/public/template/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="/public/template/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="/public/template/vendors/jszip/dist/jszip.min.js"></script>
<script src="/public/template/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="/public/template/vendors/pdfmake/build/vfs_fonts.js"></script>
<script>


    $(document).ready(function () {
        $('#wordTable').DataTable({
            // 參數設定[註1]
            "bPaginate": false, // 顯示換頁
            "searching": true, // 顯示搜尋
            "info": true, // 顯示資訊
            "fixedHeader": true, // 標題置頂
        });
    });
</script>
</body>

</html>



