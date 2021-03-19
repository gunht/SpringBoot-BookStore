$('#login-form').submit(false);

function login() {
    $('.invalid-feedback').css('display', 'none');
    let emailFormat = new RegExp(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/);

    let isValid = true;
    let email = $("#email");
    let emailVal = email.val();
    let emailInvalid = email.next();

    let password = $("#password");
    let passwordVal = password.val();
    let passwordInvalid = password.next();

    if (emailVal === "") {
        emailInvalid.css('display', 'block');
        emailInvalid.html('Vui lòng nhập email.');
        isValid = false;
    } else if (!emailFormat.test(emailVal)) {
        emailInvalid.css('display', 'block');
        emailInvalid.html('Email không hợp lệ.');
        isValid = false;
    }
    if (passwordVal === "") {
        passwordInvalid.css('display', 'block');
        passwordInvalid.html('Vui lòng nhập password.');
        isValid = false;
    }

    if (isValid === true) {
        req = {
            email: emailVal,
            password: passwordVal
        }
        var myJSON = JSON.stringify(req);
        $.ajax({
            url: '/api/login',
            type: 'POST',
            data: myJSON,
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                setTimeout(function () {
                    location.href = "/";
                }, 2000);
                signedValidate(true, data.fullName);
            },
            error: function (data) {
                toastr.warning(data.responseJSON.message);
            }
        })
    }
}

