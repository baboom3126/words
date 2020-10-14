<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="zh-TW">
<%@include file="../partial/header.jsp" %>
<style>

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

                    </div>


                </div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Word</h2>

                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="theWord"><span
                                            class="required"></span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group pull-left">
                                        <div class="input-group">
                                            <textarea  class="form-control" id="TextareaForWords" rows="5">

                                            </textarea>
                                            <span class="input-group-btn">
                            <button class="btn btn-primary" type="button" id="query">Go!</button>
                          </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="clearfix"></div>
                <div class="row">

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


</body>

</html>
