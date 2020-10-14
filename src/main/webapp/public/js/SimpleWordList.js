$.ajax({
    url: window.location.origin + "/word/queryAllSimple",
    crossDomain: true,
    type: "get",
    cache: "false",
    success: function (result) {
        console.log(result)
        var appendHtml = '';
        for (var i in result) {
            appendHtml += `
<tr>
    <td id="${result[i].wordId}"><b>${result[i].theWord}</b></td>
    <td>${result[i].speech}</td>
    <td>${moment(result[i].createTime).format('YYYY/MM/DD hh:mm:ss')}</td>
    <td>${moment(result[i].modifyTime).format('YYYY/MM/DD hh:mm:ss')}</td>
    <td>${result[i].remarks}</td>remarks
    <td>${(result[i].status=='1')?'啟用中':'<red>未啟用</red>'}</td>
    <td>
        <button type="button" id="${result[i].theWord}" class="btn-xs btn-success">詳細資訊</button>
    </td>
</tr>
`
        }
        $('#wordTable_tbody').html(appendHtml)

    },
    error: function (err) {
        swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!'
        })
    }
})


