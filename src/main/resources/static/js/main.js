$(document).ready(function () {
    $('.nBtn, table .eBtn').on('click', function (event) {
        event.preventDefault();// this prevents the get method findOne to be triggered automatically (remember we annotated with @ResponseBody>>> JSON)

        let targetHref = $(this).attr('href');
        let text = $(this).text();
        if(text ==='Edit'){
        $.get(targetHref, function(employee, status){
            $('.myForm #id').val(employee.id);
            $('.myForm #firstName').val(employee.firstName);
            $('.myForm #lastName').val(employee.lastName);
            $('.myForm #email').val(employee.email);
        });

        $('.myForm #exampleModal').modal();
        }else{
            $('.myForm #id').val('');
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #email').val('');
            $('.myForm #exampleModal').modal();
        }

    });

    $('.table .delBtn').on('click', function(event){
        event.preventDefault();
        let targetHref = $(this).attr('href');
        $('#staticBackdrop #delRef').attr('href', targetHref);
        $('#staticBackdrop').modal();
    });
});