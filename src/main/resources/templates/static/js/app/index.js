var main ={
    init : function(){
        var _this = this;
    //functions
        $('#btn-postUpdate').on('click', function (){
            _this.postUpdate();
        });


    },
    //function Impl
    postUpdate : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();
        $.ajax({
            type: 'POST',
            url: '/api/v1/post-update/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data);
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/allposts';
        }).fail(function(error){
        alert(JSON.stringify(error)+'수정실패')
        });
    }
};
main.init();