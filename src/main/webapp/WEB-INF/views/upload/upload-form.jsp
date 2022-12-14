<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ibini books</title>

    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- fontawesome css: https://fontawesome.com -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">

    <!-- linear icons -->
    <!-- https://linearicons.com/free#cdn -->
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">

    <!-- naver font -->
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css" rel="stylesheet">
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-barun-gothic.css" rel="stylesheet">



    <!-- slick css || https://kenwheeler.github.io/slick/  -->
    <link rel="stylesheet" href="/css/slick-1.8.1.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- custom css -->
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/post-reg.css">


    <!-- jquery -->
    <script src="/js/jquery-3.3.1.min.js"></script>


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- custom js -->
    <script src="/js/common.js" defer></script>
    <script src="/js/upload.js" defer></script>

    <!-- jquery -->
    <script src="/js/jquery-3.3.1.min.js"></script>

    <style>
        .fileDrop {
            width: 800px;
            height: 400px;
            border: 1px dashed gray;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 1.5em;
        }

        .uploaded-list {
            display: flex;
        }

        .img-sizing {
            display: block;
            width: 100px;
            height: 100px;
        }
    </style>

</head>

<body>


    <div id="wrap">

        <%@ include file="../include/header.jsp" %>


        <!-- ??? ????????? ?????? ?????? -->
        <section class="post-reg-section">
            <div class="inner-section">
                <form id="write-form" action="/upload" method="post" autocomplete="off" enctype="multipart/form-data">

                    <!-- ?????? : ??????-->
                    <input type="hidden" name="account" id="" value="${account}">
                    <!-- postNo(??????) -->
                    <input type="hidden" name="postNo" id="" value=30>


                    <!-- ?????????, ??????, ??????, ??????-->
                    <div id="reg-1">
                        <!-- ????????? -->
                        <div class="img-wrap">
                            <div class="img-box">
                                <span class="box-msg">???????????? ????????? ?????????</span>
                                <!-- <span class="box-msg hide">???????????? ????????? ?????????</span> -->
                                <!-- <img class="post-img" src="https://pbs.twimg.com/media/FagFBNhUsAUzvho?format=jpg&name=4096x4096" alt=""> -->
                            </div>
                            <label class="file-box">
                                <div class="file-box-left">
                                    ?????? ??????
                                </div>
                                <div class="file-box-right">
                                    ????????? ???????????? ????????????.
                                </div>
                                <input type="file" name="files" id="ajax-file" class="file-input thumb-input">
                            </label>
                        </div>

                        <!-- ??????, ??????, ?????? -->
                        <div class="tw-wrap">
                            <div class="span-wrap">
                                <span class="reg-span">??? ??????</span>
                                <span class="explain-span">????????? ????????? ?????????</span>
                            </div>
                            <input class="white-box title-input" type="text" name="postTitle" placeholder="????????? ????????? ?????????"
                                disabled>

                            <div class="span-wrap">
                                <span class="reg-span">??????</span>
                                <span class="explain-span">????????? ????????? ?????????</span>
                            </div>
                            <input class="white-box writer-input" type="text" name="postWriter"
                                placeholder="????????? ????????? ?????????" disabled>

                            <div class="span-wrap">
                                <span class="reg-span">??????</span>
                                <span class="explain-span">1~5 ????????? ????????? ????????? ?????????</span>
                            </div>
                            <input class="white-box title-input" type="number" name="starRate" placeholder="??????) 5"
                                disabled>
                        </div>
                    </div> <!-- // end reg-1 -->

                    <div id="reg-6">
                        <span class="reg-span">????????? ????????????</span>
                        <label class="file-box">
                            <div class="file-box-left">
                                ?????? ??????
                            </div>
                            <div class="file-box-right"  data-imgs-num="0">
                                ????????? ???????????? ????????????.
                            </div>
                            <input type="file" name="files" id="ajax-file-multi" class="file-input imgs-input" multiple>
                        </label>
                        <div class="uploaded-list">
                            <!-- <div class="upload-img-box">
                                <img class="upload-img" src="https://pbs.twimg.com/media/FbQJPxYUcAI11FU?format=jpg&name=large" alt="">
                            </div> -->
                        </div>

                    </div>


                    <div id="reg-btn">
                        <button class="white-box">??????</button>
                    </div>
                </form> <!-- // end write-form -->
            </div> <!-- // end inner-section -->
        </section> <!-- // end section -->

    </div> <!-- end wrap -->


    <script>
        // start jQuery(jQuery ???????????? ??????, jQuery ?????? ??????)
        $(document).ready(function () {

            const account = "${account}";
            console.log(account);

            // ????????? ?????? ??? ?????? ?????????
            const $regBtn = $('#post-reg-btn');
            $regBtn.click(e => {
                $('#post-reg-form').submit();
            })



            // ?????? ????????? ?????? ????????? ?????????
            const $imgsInput = $('.imgs-input');

            $imgsInput.change(e => {
                // ?????? ?????? ????????? ????????? ??????
                // 1. ????????? ?????? ????????? ??????
                const files = e.originalEvent.target.files;
                console.log('input file data: ', files);

                // ?????? ?????? ??????
                const originNames = [];
                // ????????? ????????? ????????? ??????
                for (const f of files) {
                    if (!isImageFile(f.name)) {
                        alert('????????? ????????? ????????? ???????????????.');
                        return;
                    }
                    originNames.push(f.name);
                }
                console.log(originNames);

                // 2. ?????? ?????? ???????????? input[type=file]????????? ??????
                const $fileInput = $('#ajax-file-multi');
                console.log($fileInput[0].files);

                // 3. ?????? ???????????? ????????? ???????????? ???????????? FormData????????? ??????
                const formData = new FormData();

                // 4. ????????? ???????????? ?????? FormData?????? ??????
                for (let file of $fileInput[0].files) {
                    formData.append('files', file);
                }
                console.log(formData);

                // 5. ????????? ?????? ??????
                const reqInfo = {
                    method: 'POST',
                    body: formData
                };
                fetch('/ajax-upload', reqInfo)
                    .then(res => {
                        console.log(res.status);
                        return res.json();
                    })
                    .then(fileNames => {
                        console.log(fileNames);
                        showImgs(fileNames);
                    });
            });





            // ????????? ?????? ????????? ?????????
            const $thumbInput = $('.thumb-input');

            $thumbInput.change(e => {
                console.log('????????? ????????? ??????!');
                // ????????? ?????? ????????? ????????? ??????
                // 1. ????????? ?????? ????????? ??????
                const files = e.originalEvent.target.files;
                console.log('input file data: ', files);

                // ?????? ???????????? ??????
                const fileOriginName = files[0].name;
                console.log('fileOriginName : ', fileOriginName);

                // ????????? ???????????? ???????????? ????????? ??????
                if (!isImageFile(fileOriginName)) {
                    alert('????????? ????????? ????????? ???????????????.');
                    return;
                }

                // 2. ?????? ?????? ???????????? input[type=file]????????? ??????
                const $fileInput = $('#ajax-file');
                $fileInput.prop('files', files); // ????????? ??????????????? input??? name ????????? ?????????
                console.log($fileInput[0].files);

                // 3. ?????? ???????????? ????????? ???????????? ???????????? FormData????????? ??????
                const formData = new FormData();
                // 4. ????????? ???????????? ?????? FormData?????? ??????
                for (let file of $fileInput[0].files) {
                    formData.append('files', file);
                }

                // 5. ????????? ?????? ??????
                const reqInfo = {
                    method: 'POST',
                    body: formData
                };
                fetch('/ajax-upload', reqInfo)
                    .then(res => {
                        console.log(res.status);
                        return res.json();
                    })
                    .then(fileNames => {
                        console.log(fileNames);
                        showThumbImg(fileNames, fileOriginName);
                    });
            }); // end ????????? ?????? ????????? ?????????




        }); // end jQuery
    </script>


</body>

</html>