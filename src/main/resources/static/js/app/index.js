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
        $('#btn-postDelete').on('click', function (){
            _this.postDelete();
        });
        $('#btn-todoCreate').on('click',function(){
            _this.todoCreate();
        });
        $('#btn-todoUpdate').on('click',function(){
            _this.todoUpdate();
        });
        $('#btn-todoDelete').on('click',function(){
            _this.todoDelete();
        });
    },
    //function Impl
    //게시물 저장
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
//게시물 업데이트
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
    },
    //게시물 삭제
    postDelete : function() {
        var id = $('#id').val();
        $.ajax({
            type:'DELETE',
            url: '/api/v1/post/'+id,
            dataType : 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(id)
        }).done(function(){
            alert('글이 삭제되었습니다');
            window.location.href= "/"
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    //할일 추가
    todoCreate : function(){
        var data = {
            author : $('#todoAuthor').val(),
            content : $('#todoContent').val()
        };
        $.ajax({
            type:'POST',
            url:'/api/v1/todo',
            dataType :'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function(){
            alert('할일 등록!');
            window.location.href="/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    //할일 수정
    todoUpdate : function(){
            var content = $('#todoContent').val();
            var id = $('#id').val();
            $.ajax({
                type:'PUT',
                url: '/api/v1/todo/'+id+'?content='+content,
            }).done(function(){
                alert('할일 수정!');
                window.location.href="/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    },
    todoDelete : function() {
            var id = $('#id').val();
            $.ajax({
                type:'DELETE',
                url: '/api/v1/todo/'+id,
                dataType : 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(id)
            }).done(function(){
                alert('할일이 삭제되었습니다');
                window.location.href= "/"
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }
}
main.init();