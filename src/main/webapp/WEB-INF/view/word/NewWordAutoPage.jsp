<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="zh-TW">
<%@include file="../partial/header.jsp" %>
<style>
    input[type='checkbox'] {
        width: 30px;
        height: 30px;
        background: white;
        border-radius: 5px;
        border: 2px solid #555;
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
                                            <input type="text" class="form-control" id="theWord"
                                                   placeholder="Search for...">
                                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button" id="query">Go!</button>
                          </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="clearfix"></div>
                <div class="row" id="word_detail" style="display:none;">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">

                            <div class="x_content">
                                <br/>
                                <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">


                                    <h3 class="control-label col-md-3 col-sm-3 col-xs-12">詞性</h3>
                                    <br><br>
                                    <hr>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"><span
                                                    class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="input_speech" id="input_speech"
                                                       class="form-control col-md-7 col-xs-12">

                                            <!--  <div class="row">-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="noun">-->
<!--                                                    <label class="">noun</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="noun[C]">-->
<!--                                                    <label class="">n[C]</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="noun[U]">-->
<!--                                                    <label class="">n[U]</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="verb">-->
<!--                                                    <label class="">verb</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="vi">-->
<!--                                                    <label class="">vi</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="vt">-->
<!--                                                    <label class="">vt</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="adj">-->
<!--                                                    <label class="">adj</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="adv">-->
<!--                                                    <label class="">adv</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox" value="prep">-->
<!--                                                    <label class="">prep</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox"-->
<!--                                                           value="int">-->
<!--                                                    <label class="">int</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox"-->
<!--                                                           value="conj">-->
<!--                                                    <label class="">conj</label>-->
<!--                                                </div>-->
<!--                                                <div class="col-md-2 col-sm-2 col-xs-4" style="display: inline-block;">-->
<!--                                                    <input class="form-check-input" name="checkbox_speech"-->
<!--                                                           type="checkbox"-->
<!--                                                           value="phrase">-->
<!--                                                    <label class="">phrase</label>-->
<!--                                                </div>-->
<!--                                            </div>-->

                                        </div>

                                    </div>


                                    <div class="" id="div_description">

                                        <h3 class="control-label col-md-3 col-sm-3 col-xs-12">解釋</h3>
                                        <br><br>
                                        <hr>
                                        <div class="form-group" id="div_des-eng" name="div_des-eng">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                                   for="description-eng">英文解釋<span
                                                        class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="description-eng"
                                                       class="form-control col-md-7 col-xs-12">
                                            </div>
                                            <i class="fa fa-eye btn"
                                               onclick='javascript:autofill_arr(this,"_desEng")'></i>
                                            <i class="fa fa-plus btn"></i>
                                            <i class="fa fa-close btn" onclick="javascript:fa_remove(this)"
                                               style="display:none;color:red;"></i>
                                        </div>

                                        <div class="form-group" id="div_des-chi" name="div_des-chi">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                                   for="description-chi">中文解釋<span
                                                        class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="description-chi"
                                                       class="form-control col-md-7 col-xs-12">
                                            </div>
                                            <i class="fa fa-eye btn"
                                               onclick='javascript:autofill_arr(this,"_desChi")'></i>
                                            <i class="fa fa-plus btn"></i>
                                            <i class="fa fa-close btn" onclick="javascript:fa_remove(this)"
                                               style="display:none;color:red;"></i>
                                        </div>
                                    </div>

                                    <div class="" id="div_sentence">
                                        <h3 class="control-label col-md-3 col-sm-3 col-xs-12">例句</h3>
                                        <br><br>
                                        <hr>
                                        <div class="form-group" id="div_sen-eng" name="div_sen-eng">
                                            <label for="sentence-eng"
                                                   class="control-label col-md-3 col-sm-3 col-xs-12">英文例句</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input name="sentence-eng" class="form-control col-md-7 col-xs-12"
                                                       type="text">
                                            </div>
                                            <i class="fa fa-eye btn"
                                               onclick='javascript:autofill_arr(this,"_senEng")'></i>
                                            <i class="fa fa-plus btn"></i>
                                            <i class="fa fa-close btn" onclick="javascript:fa_remove(this)"
                                               style="display:none;color:red;"></i>
                                        </div>

                                        <div class="form-group" id="div_sen-chi" name="div_sen-chi">
                                            <label for="sentence-chi"
                                                   class="control-label col-md-3 col-sm-3 col-xs-12">中文例句</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input name="sentence-chi" class="form-control col-md-7 col-xs-12"
                                                       type="text">
                                            </div>
                                            <i class="fa fa-eye btn"
                                               onclick='javascript:autofill_arr(this,"_senChi")'></i>
                                            <i class="fa fa-plus btn"></i>
                                            <i class="fa fa-close btn" onclick="javascript:fa_remove(this)"
                                               style="display:none;color:red;"></i>
                                        </div>

                                    </div>

                                    <h3 class="control-label col-md-3 col-sm-3 col-xs-12">其他</h3>
                                    <br><br>
                                    <hr>
                                    <div class="form-group">
                                        <label for="word_note"
                                               class="control-label col-md-3 col-sm-3 col-xs-12">備註欄</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <textarea id="word_note" name="word_note" class="form-control col-md-7 col-xs-12" type="text"
                                    style="resize: none;"></textarea>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label for="word_proword_pronounce"
                                               class="control-label col-md-3 col-sm-3 col-xs-12">音檔(自動抓取)</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="word_pronounce" name="word_pronounce"
                                                   class="form-control col-md-7 col-xs-12"
                                                   type="text" value="/example.mp3" disabled>
                                            <br><br>
                                            <audio id="audio_pronounce" controls>

                                                <source src="" type="audio/mpeg" id='source_pronounce'>
                                                Your browser does not support the audio element.
                                            </audio>
                                        </div>
                                    </div>


                                    <div class="control-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hashtag</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="tags_1" type="text" class="tags form-control" value="#word"/>
                                            <div id="suggestions-container"
                                                 style="position: relative; float: left; width: 250px; margin: 10px;"></div>
                                        </div>
                                    </div>
                                    <div class="form-group">


                                    </div>


                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <button class="btn btn-primary" type="reset" id="btn_reset">Reset</button>
                                            <!-- Button trigger modal -->
                                            <button type="button" id="btn_confirm" class="btn btn-success">Submit
                                            </button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>


        <!-- Modal -->
        <!-- Modal -->
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title" id="exampleModalLongTitle">確認新增內容</h1>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modal_confirm_body">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="btn_save">存檔</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- /page content -->
        <%@include file="../partial/footer.jsp" %>


    </div>
</div>
<%@include file="../partial/scripts.jsp" %>


<script src="/public/js/newWordAuto.js"></script>


</body>
</html>
