var res = '';
var currentTarget;

$(document).ready(function () {
    ///

    $('#btn_save').click(function () {

        swal.showLoading();
        let postData = {};

        let desEng = $('input[name=description-eng]');
        let desChi = $('input[name=description-chi]')
        let senEng = $('input[name=sentence-eng]');
        let senChi = $('input[name=sentence-chi]');
        let hashtags = $('.span_hashtag')
        let word_note = $('#word_note').val();
        let word_pronounce = $('#word_pronounce').val();


        var theWord = $('#theWord').val();
        var checkbox_speech = $('input[name=checkbox_speech]:checked');
        var desEng_length = desEng.length
        var desChi_length = desChi.length
        var senEng_length = senEng.length

        ////////word//////////
        let word = {}
        word.theWord = theWord;
        word.speech = $('input[name=input_speech]').val();
        word.remarks = word_note;
        word.audioPath = word_pronounce;

        postData.word = word;

        ////////word def///////////
        let arr_wordDef = [];
        for (var i = 0; i < desEng_length; i++) {
            let defs = {};
            defs.engDefinition = $(desEng[i]).val();
            defs.chiDefinition = $(desChi[i]).val();
            arr_wordDef.push(defs);
        }
        postData.wordDef = arr_wordDef;

        ///////word sen/////////////

        let arr_wordSen = [];

        for (var i = 0; i < senEng_length; i++) {
            let sens = {};
            sens.engSentence = $(senEng[i]).val();
            sens.chiSentence = $(senChi[i]).val();
            arr_wordSen.push(sens);
        }
        postData.wordSen = arr_wordSen;

        //////hash tag//////
        let tags = [];
        for (i of hashtags) {
            tags.push(i.innerText.split('#')[1]);
        }
        postData.wordHashtag = tags;

        $.ajax({
            url: "http://localhost:8080/word/new",
            crossDomain: true,
            type: "POST",
            contentType:"application/json",
            cache: "false",
            data: JSON.stringify(postData),
            success: function (result) {
                    Swal.fire({
                        title: 'Success',
                        text: result,
                        icon: 'success',
                        confirmButtonText: 'OK'
                    }).then((res) => {
                        window.location.reload();
                    })


            }, error: function (err) {
                Swal.fire({
                    title: 'Error',
                    text: err.responseText,
                    icon: 'Error',
                    confirmButtonText: 'OK'
                })
            }
        })


        // var settings = {
        //     "async": true,
        //     "crossDomain": true,
        //     "url": "http://localhost:8080/word/new",
        //     "method": "POST",
        //     "headers": {
        //         "content-type": "application/json",
        //         "cache-control": "no-cache",
        //     },
        //     "processData": false,
        //     data: JSON.stringify(postData)
        // }
        //
        // $.ajax(settings).done(function (response) {
        //     $('#exampleModalLong').modal('hide');
        //     return response;
        //
        // }).then((response)=>{
        //     Swal.fire({
        //         title: 'Success',
        //         text: response,
        //         icon: 'success',
        //         confirmButtonText: 'OK'
        //     }).then((res) => {
        //         window.location.reload();
        //     })
        //
        // });


    })

    ///
    $('#btn_confirm').click(function () {
        var appendHtml = '';
        var desEng = $('input[name=description-eng]');
        var desChi = $('input[name=description-chi]')
        var senEng = $('input[name=sentence-eng]');
        var senChi = $('input[name=sentence-chi]');
        var word_note = $('#word_note').val();
        var hashtags = $('.span_hashtag');


        var theWord = $('#theWord').val();
        var checkbox_speech = $('input[name=checkbox_speech]:checked');
        var desEng_length = desEng.length
        var desChi_length = desChi.length
        var senEng_length = senEng.length
        var senChi_length = senChi.length
        var word_pronounce = $('#word_pronounce').val()
        var arr_speech = []

        for (i of checkbox_speech) {
            if (i.checked == true) {
                arr_speech.push(i.value)
            }
        }


        if (desEng_length == 1 && $(desEng[0]).val() == '') {
            swal.fire('請填選英文解釋');
            return;
        } else if (desChi_length == 1 && $(desChi[0]).val() == '') {
            swal.fire('請填選中文解釋');
            return;
        }

        appendHtml +=
            `
          <h1 class="heading cc_pointer " onclick="javascript:playAudio();">${theWord}&nbsp&nbsp<i class="fa fa-headphones"></i></h1>
          <h2 class="heading cc_pointer"><i class="fa fa-paperclip"></i>&nbsp ${$('input[name=input_speech]').val()}</h2><hr>
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
            appendHtml += `<span class="btn btn-outline-secondary"">${i.innerText}</span>`;
        }
        appendHtml += `</blockquote>`;


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
        ////reset all form
        $('#demo-form2').trigger('reset');
        let div_desEng = $('div[name=div_des-eng');
        let div_desChi = $('div[name=div_des-chi');
        let div_senEng = $('div[name=div_sen-eng');
        let div_senChi = $('div[name=div_sen-chi');

        for (let i = 1; i < div_desEng.length; i++) {
            div_desEng[i].remove();
        }
        for (let i = 1; i < div_desChi.length; i++) {
            div_desChi[i].remove();
        }

        for (let i = 1; i < div_senEng.length; i++) {
            div_senEng[i].remove();
        }

        for (let i = 1; i < div_senChi.length; i++) {
            div_senChi[i].remove();
        }


        ///
        swal.showLoading();
        var para = $('#theWord').val();
        console.log(para)
        $.ajax({
            url: "http://www.paishienglish.com/api/v2?para=" + para,
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
                    ///////auto fill input
                    swal.close();
                    res = result;
                    $('#word_pronounce').val('https://dictionary.cambridge.org' + decodeURI(result.us_mp3))
                    $('#source_pronounce').attr('src', 'https://dictionary.cambridge.org' + result.us_mp3)

                    ///auto fill speech
                    $('#input_speech').val(res.speech_arr.join(", "))

                    ///auto fill description

                    let desEng_length = res.eng_arr.length;


                    let temp0 = $('input[name=description-eng]')[0];
                    $(temp0).val(res.eng_arr[0])
                    let temp1 = $('input[name=description-chi]')[0];
                    $(temp1).val(res.chi_arr[0])

                    for (let i = 1; i < desEng_length; i++) {
                        let desEng = res.eng_arr[i];
                        let desChi = res.chi_arr[i];

                        let div_desEng_Element = $('#div_des-eng').clone();
                        let div_desChi_Element = $('#div_des-chi').clone();

                        div_desEng_Element.find('.fa-plus').remove();
                        div_desEng_Element.find('.fa-close').css('display', '');
                        div_desEng_Element.find('div input').val(desEng)

                        div_desChi_Element.find('.fa-plus').remove()
                        div_desChi_Element.find('.fa-close').css('display', '');
                        div_desChi_Element.find('div input').val(desChi)

                        $('#div_description').append(div_desEng_Element);
                        $('#div_description').append(div_desChi_Element);

                    }

                    ////////auto fill sentence
                    let senArr_length = res.eng_sen_arr.length;

                    let temp2 = $('input[name=sentence-eng]')[0];
                    $(temp2).val(res.eng_sen_arr[0])
                    let temp3 = $('input[name=sentence-chi]')[0];
                    $(temp3).val(res.chi_sen_arr[0])


                    for (let i = 1; i < senArr_length; i++) {
                        let senEng = res.eng_sen_arr[i];
                        let senChi = res.chi_sen_arr[i];

                        let div_senEng_Element = $('#div_sen-eng').clone();
                        let div_senChi_Element = $('#div_sen-chi').clone();

                        div_senEng_Element.find('.fa-plus').remove()
                        div_senEng_Element.find('.fa-close').css('display', '');
                        div_senEng_Element.find('div input').val(senEng)

                        div_senChi_Element.find('.fa-plus').remove()
                        div_senChi_Element.find('.fa-close').css('display', '');
                        div_senChi_Element.find('div input').val(senChi)
                        $('#div_sentence').append(div_senEng_Element);
                        $('#div_sentence').append(div_senChi_Element);

                    }


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
                for (i of res.eng_sen_arr) {
                    appendHtml += `
                                <button class='btn btn-default'
                                style='width:100%;text-align:left;
                                white-space: normal;'
                                onclick='swal_button_click(this)'>${i}</button>`
                }
                break;

            case '_senChi':
                for (i of res.chi_sen_arr) {
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
