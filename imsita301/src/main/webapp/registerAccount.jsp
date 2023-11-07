

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link rel="shortcut icon" type="image/png" href="./assets/img/favicon.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
        crossorigin="anonymous"></script>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="./css/registerAccount.css"/>
    </head>
    <body>
        <!-- Login form -->
        <section class="forgotpassword">
            <div class="form-box-login">
                <div class="center justify-content-center align-items-center">
                    <h1>
                        <span class="h1-reset">Register Account</span>
                    </h1>
                    <div style="padding:5px 20px 5px 20px;">
                        <div class="d-block text-danger" style="margin-top:10px;margin-bottom:10px"><b>${mess}</b></div>
                        <a href="registerAccountEmail.jsp" class="email link-underline link-underline-opacity-0">Email</a>
                        <p style="color:black;text-align: center;margin-bottom: 0px;padding: 10px;">OR</p>
                        <a href="registerAccountPhone.jsp" class="email link-underline link-underline-opacity-0">Phone</a>
                    </div>
                    <a class="link-underline link-underline-opacity-0" href="home" style="display:flex; color: black; justify-content: center; align-items: center;margin-top:10px;">
                        <span><i class='bx bx-right-arrow-alt' style="display: flex;justify-content: center;align-items: center;"></i></span>
                        <span>Back to home</span></a>
                </div>
            </div>
        </section>
    </body>
</html>
