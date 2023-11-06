

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register account Email</title>
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
        <link rel="stylesheet" href="./css/registerAccountEmail.css"/>
    </head>
    <body>
        <!-- Login form -->
        <section class="forgotpassword">
            <div class="form-box-login">
                <div class="center justify-content-center align-items-center">
                    <h1 class="justify-content-center">
                        <span class="h1-reset">Register an account for IMS</span>
                        <span class="h1-tittle" style="">Welcome to <strong>ISSUE MANAGEMENT SYSTEM!</strong> Join us to find useful information needed to improve your IT skills. Please fill in your information in the form below to continue.
                        </span>
                    </h1>
                    <form action="registerAccount" method="post">
                        <div class="d-block text-danger"><b>${mess}</b></div>
                        <div class="row">
                            <div class="col-md-12" style="display:flex;">
                                <div class="mb-3" style="width:70%;margin-right:20px;">
                                    <label for="fullname" class="form-label">Full Name</label>
                                    <div class="position-relative">
                                        <input id="fullname" class="form-control" type="text" id="password" name="fullname" class="form-control"  required minlength="4" placeholder="Vui lòng nhập tên bạn">
                                        <span id="userNameError" class="error-message position-absolute"></span>
                                    </div> 
                                </div>
                                <div class="mb-3" style="width:30%">
                                    <label class="form-label">Gender</label><br>
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="male" name="gender" value="True" class="form-check-input">
                                        <label for="male" class="form-check-label">Male</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="female" name="gender" value="False" class="form-check-input">
                                        <label for="female" class="form-check-label">Female</label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12" style="display:none">
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>                               
                                    <input type="email" id="email" name="email" class="form-control" placeholder="Vui lòng nhập email bạn">                                                                 
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone</label>                               
                                    <input type="number" id="phone" name="phone" class="form-control" placeholder="Vui lòng nhập phone bạn">                                                                 
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>                               
                                    <input type="password" id="password" name="password" class="form-control" placeholder="Vui lòng nhập mật khẩu bạn">                                                                 
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="mb-3">
                                    <label for="confirmPassword" class="form-label">Confirm Password</label>                               
                                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Vui lòng nhập lại mật khẩu bạn">                                                                 
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="REGISTER ACCOUNT">

                        <a class="link-underline link-underline-opacity-0" href="login" style="display:flex; color: black; justify-content: center; align-items: center;margin-top:10px;">
                            <span><i class='bx bx-right-arrow-alt' style="display: flex;justify-content: center;align-items: center;"></i></span>
                            <span>Back to login</span></a>
                    </form>
                </div>
            </div>
        </section>

        <script type="module">
// Import the functions you need from the SDKs you need
            import { initializeApp } from "https://www.gstatic.com/firebasejs/10.5.2/firebase-app.js";
            import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.5.2/firebase-analytics.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
            const firebaseConfig = {
                apiKey: "AIzaSyAymSMrMahn50mVALFFLIcUE0XIr44_nOs",
                authDomain: "hypnotic-runway-404219.firebaseapp.com",
                projectId: "hypnotic-runway-404219",
                storageBucket: "hypnotic-runway-404219.appspot.com",
                messagingSenderId: "630914145333",
                appId: "1:630914145333:web:b97a6aeaf70ed52680257c",
                measurementId: "G-6D7RDTFJWT"
            };

// Initialize Firebase
            const app = initializeApp(firebaseConfig);
            const analytics = getAnalytics(app);
        </script>
    </body>
</html>
