$(document).ready(function () {
    // $('.eBtn, .nBtn, table').on('click', function (event) {// be mindful to use the comma
    $('.nBtn, table .eBtn').on('click', function (event) {
        event.preventDefault();// this prevents the get method findOne to be triggered automatically (remember we annotated with @ResponseBody>>> JSON)

        let targetHref = $(this).attr('href');
        let text = $(this).text();//gets name value
        if(text ==='Edit'){
        $.get(targetHref, function(employee, status){
            $('.myForm #id').val(employee.id);
            $('.myForm #firstName').val(employee.firstName);
            $('.myForm #lastName').val(employee.lastName);
            $('.myForm #email').val(employee.email);
        });

        $('.myForm #exampleModal').modal();// in an object(here its a div) with class myForm, there is an object with an id exampleModal
        }else{
            $('.myForm #id').val('');
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #email').val('');

            $('.myForm #exampleModal').modal();
        }

    });

    $('.table .delBtn').on('click', function(event){// in a table, there is a class with name delBtn
        event.preventDefault();
        let targetHref = $(this).attr('href');
        $('#staticBackdrop #delRef').attr('href', targetHref);
        $('#staticBackdrop').modal();
    });

    let currentID=0;
    $("tbody tr").on('click', function (event) {
        event.preventDefault();
        $('.selected').removeClass('selected');
        $(this).addClass("selected");
        currentID = $('.myId', this).html();
        console.log('beginner');
    });

    $('.editBtn, table').on('click', function (event) {
        event.preventDefault();
        if(event.target.id !== null){
            $.get("findOne/?id="+currentID, function(employee, status){
                $('.myForm #id').val(employee.id);
                $('.myForm #firstName').val(employee.firstName);
                $('.myForm #lastName').val(employee.lastName);
                $('.myForm #email').val(employee.email);
            });
            $('.myForm #exampleModal').modal();
        }

    });

});
