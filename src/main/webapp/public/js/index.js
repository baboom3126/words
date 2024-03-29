var res = '';
var currentTarget;

$(document).ready(function () {


    ///
    $('#btn_confirm').click(function () {
        var appendHtml = '';
        var desEng = $('input[name=description-eng]');
        var desChi = $('input[name=description-chi]')
        var senEng = $('input[name=sentence-eng]');
        var senChi = $('input[name=sentence-chi]');
        var word_note = $('#word_note').val();
        var hashtags = $('.span_hashtag')


        var theWord = $('#theWord').val();
        var checkbox_speech = $('input[name=checkbox_speech]:checked');
        var desEng_length = desEng.length
        var desChi_length = desChi.length
        var senEng_length = senEng.length
        var senChi_length = senChi.length
        var word_pronounce = $('#word_pronounce').val()
        var arr_speech = []

        for(i of checkbox_speech){
            if(i.checked==true){
                arr_speech.push(i.value)
            }
        }


        if(checkbox_speech.length==0){
            swal.fire('請填選詞性');
            return;
        }else if( desEng_length == 1 && $(desEng[0]).val() ==''){
            swal.fire('請填選英文解釋');
            return;
        }else if( desChi_length == 1 && $(desChi[0]).val() ==''){
            swal.fire('請填選中文解釋');
            return;
        }

        appendHtml +=
            `
          <h1 class="heading cc_pointer " onclick="javascript:playAudio();">${theWord}&nbsp&nbsp<i class="fa fa-headphones"></i></h1>
          <h2 class="heading cc_pointer"><i class="fa fa-paperclip"></i>&nbsp ${arr_speech}</h2><hr>
          `

        for (var i = 0; i < desEng_length; i++) {
            appendHtml += `
            <blockquote class="message">
            ${$(desEng[i]).val()}<br>
            ${$(desChi[i]).val()}
            </blockquote><hr>
            `
        }

        // for (var i = 0; i < desChi_length; i++) {
        //     appendHtml +=
        //         `
        //     中文解釋${i + 1} : <br>${$(desChi[i]).val()}<br>
        //     `
        // }
        appendHtml += `<h3 class="heading cc_pointer">例句</h3><hr>`

        for (var i = 0; i < senEng_length; i++) {
            appendHtml += `
            <blockquote class="message">
            ${$(senEng[i]).val()}<br>
            ${$(senChi[i]).val()}
            </blockquote><hr>
            `
        }
        // ${word_pronounce}
        // for (var i = 0; i < senChi_length; i++) {
        //     appendHtml +=
        //         `
        //     中文例句${i + 1} : <br><br>
        //     `
        // }

        appendHtml += `
                    <h3 class="heading cc_pointer">備註</h3><hr>
                    <blockquote class="message">${word_note}</blockquote><hr>
                    <h3 class="heading cc_pointer">Hashtags</h3><hr>
                    <blockquote class="message">
                    `
        for (i of hashtags) {
            appendHtml+=`<span class="btn btn-outline-secondary"">${i.innerText}</span>`;
        }
        appendHtml+=`</blockquote>`;


        $('#modal_confirm_body').html(appendHtml)

        $('#exampleModalLong').modal('show');

    })


    ////////////////////////
    $('#tags_1').focusout(function (event) {
        var tag = $('#tags_1').val();
        if (tag.charAt(0) == '#' && tag.length > 1) {
            $('#suggestions-container').append(`<span class='btn btn-outline-secondary span_hashtag' onclick='remove(this)'>${tag}</span>`)
            $('#tags_1').val('')
        }
    })


    //////////////////////////////////////
    $('.fa-plus').click(function (event) {
        console.log()
        var temp = $(this).parent().clone()
        temp.find('.fa-plus').remove()
        temp.find('.fa-close').css('display', '');
        temp.find('div input').val('')
        temp.css('display', 'none');
        $(this).parent().parent().append(temp)

        // temp.insertAfter($(this).parent());
        temp.fadeIn();
        event.preventDefault();
    })
    /////////////////////////////////
    $('#query').click(function () {
        $('#demo-form2').trigger('reset');
        swal.showLoading();
        var para = $('#theWord').val();
        console.log(para)
        $.ajax({
            url: "http://paishienglish.com/api?para=" + para,
            crossDomain: true,
            type: "get",
            cache: "false",
            success: function (result) {
                $('#word_detail').fadeIn();

                if (result.chi_arr.length == 0 && result.eng_arr == 0) {
                    swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Word not found!'
                    })

                } else {
                    swal.close();
                    res = result;
                    $('#word_pronounce').val('https://dictionary.cambridge.org' + decodeURI(result.us_mp3))
                    $('#source_pronounce').attr('src', 'https://dictionary.cambridge.org' + result.us_mp3)
                }
            },
            error: function (err) {
                swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong!'
                })
            }
        }).then(() => {
            $("audio").load()
        })
        // http://paishienglish.com/api?para=hang

    })


});

function playAudio() {
    document.getElementById('audio_pronounce').play();
}


function fa_remove(that) {
    if (confirm("確定刪除?")) {
        $(that).parent().remove();
        return true;
    }
    return false
}

function swal_button_click(that) {
    $(currentTarget).val(that.innerText)
    console.log(that.innerText)
    swal.close()
}


function remove(that) {
    $(that).remove();
}

function autofill_arr(that, _arr) {
    currentTarget = $(that).parent().find('div input')
    if (res != '') {
        var appendHtml = '<h2>result</h2><hr>';

        switch (_arr) {
            case '_desEng':
                for (i of res.eng_arr) {
                    appendHtml += `
                                <button class='btn btn-default'
                                style='width:100%;text-align:left;
                                white-space: normal;'
                                onclick='swal_button_click(this)'>${i}</button>`
                }
                break;

            case '_desChi':
                for (i of res.chi_arr) {
                    appendHtml += `
                                <button class='btn btn-default'
                                style='width:100%;text-align:left;
                                white-space: normal;'
                                onclick='swal_button_click(this)'>${i}</button>`
                }
                break;

            case '_senEng':
                for (i of res.sen_arr) {
                    appendHtml += `
                                <button class='btn btn-default'
                                style='width:100%;text-align:left;
                                white-space: normal;'
                                onclick='swal_button_click(this)'>${i}</button>`
                }
                break;

            case '_senChi':
                for (i of res.sen_arr) {
                    appendHtml += `
                                <button class='btn btn-default'
                                style='width:100%;text-align:left;
                                white-space: normal;'
                                onclick='swal_button_click(this)'>${i}</button>`
                }
                break;


            case '_summary':
                for (i of res.summary_arr) {
                    appendHtml += `
                            <button class='btn btn-default'
                            style='width:100%;text-align:left;
                            white-space: normal;'
                            onclick='swal_button_click(this)'>${i}</button>`
                }
                break;
        }


        swal.fire({
            html: appendHtml
        })

    }
}
