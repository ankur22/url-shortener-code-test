function shortenUrl() {
    var urlVar = $('#original-url').val();
    var requestBody = {url: urlVar};
    $.ajax({
        type: 'POST',
        url: '/shorten',
        data: JSON.stringify(requestBody),
        success: function(data) {
            $('#response').val(data.url)
        },
        error: function(xhr,status,error) {
            $('#response').val("Please enter a valid url")
        },
        contentType: "application/json",
        dataType: 'json'
    });
}