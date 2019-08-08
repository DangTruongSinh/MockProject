<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" href="css/Login.css">
</head>

<body>
    <div class="background-img">
        
        <div class="container-fluid bg">
            <div class="row justify-content-center">
                <div class="col-md-3 col-sm-6 col-xs-12 row-container">
                    <form action="/QuanLyBus/dang-nhap" method="post">
                        <div class="titlelogin">
                            <img  class="icon" src="img/icon.PNG" alt="icon">
                            <h1><strong>Login</strong></h1>

                            </div>
                            
                   
                            <span class="input input--kyo">
                                    <input class="input__field input__field--kyo" id="input-19" placeholder="Email" name = "userName"/>
                                    <label class="input__label input__label--kyo" for="input-19">
                                    </label>
                                </span><p class="emailError"></p>

             

                            <span class="input input--kyo"> 
                                    <input class="input__field input__field--kyo" type="password" id="input-19" placeholder="Password" name="password"/>
                                    <label class="input__label input__label--kyo" for="input-19">
                                    </label>
                            </span><p class="passwordError"></p>


                            <div class="form-check">
                                <label class="container"><p class="form-check-label">Check me out</p>
                                            <input type="checkbox" checked="checked" name = "checked">
                                            <span class="checkmark"></span>
                                </label>
                        </div>
                        <button type="submit" id="submitbtn" class="btn btn-success btn-block">Login</button>
                    </form>
                    <div>
                        <label><a href="#" class="lbLink">Registers</a></label>
                        <label><a href="#" id="passbtn" class="lbLink">Forgot Password?</a></label>
                    </div>
                    
                    <ul class="share">
                       <p>Sign in with</p>
                        <li class="middle">
                            <a class="share-icon" href="#"
                                style="background-image: url(img/world.png);background-size: cover"><i
                                    class="fa fa-share-square-o"></i></a>
                            <a class="facebook" href="#"
                                style="background-image: url(img/fbicon.png);background-size: cover"></a>
                            <a class="twitter" href="#"
                                style="background-image: url(img/twicon.png);background-size: cover"></a>
                        </li>

                    </ul>
                    <div id="backhomeText">
                        <label><a href="#" class="homeLink">Back to Home</a></label>
                    </div>
                </div>

            </div>

        </div>

       

    </div>
    <script src="js/classie.js"></script>
    <script>
        (function() {
            // trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
            if (!String.prototype.trim) {
                (function() {
                    // Make sure we trim BOM and NBSP
                    var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                    String.prototype.trim = function() {
                        return this.replace(rtrim, '');
                    };
                })();
            }

            [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
                // in case the input is already filled..
                if( inputEl.value.trim() !== '' ) {
                    classie.add( inputEl.parentNode, 'input--filled' );
                }

                // events:
                inputEl.addEventListener( 'focus', onInputFocus );
                inputEl.addEventListener( 'blur', onInputBlur );
            } );

            function onInputFocus( ev ) {
                classie.add( ev.target.parentNode, 'input--filled' );
            }

            function onInputBlur( ev ) {
                if( ev.target.value.trim() === '' ) {
                    classie.remove( ev.target.parentNode, 'input--filled' );
                }
            }
        })();
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>