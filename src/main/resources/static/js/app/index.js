var main ={
    init : function(){
        var _this = this;
    //functions
        $('#btn-postCreate').on('click', function () {
            _this.savePost();
            });
        $('#btn-postUpdate').on('click', function (){
            _this.postUpdate();
        });
    },
    //function Impl
     savePost : function () {
            var data = {
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/post',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 등록되었습니다.');
                window.location.href = '/post/all';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    postUpdate : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/post/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/post/all';
        }).fail(function(error){
        alert(JSON.stringify(error));
        });
    }
};
main.init();