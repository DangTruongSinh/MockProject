
function validateForm() {

    var p = document.getElementById("password").value;
    var u = document.getElementById("repassword").value;

    if (p != u) {
        alert("Mật Khẩu Nhập Lại Không Trùng Khớp")
    }
}

p.onchange = validatePassword;
u.onkeyup = validatePassword;




function keyPhone(e) {
    var keyword = null;
    if (window.event) {
        keyword = window.event.keyCode;
    } else {
        keyword = e.which; //NON IE;
    }

    if (keyword < 48 || keyword > 57) {
        if (keyword == 48 || keyword == 127) {
            return;
        }
        return false;
    }
}

