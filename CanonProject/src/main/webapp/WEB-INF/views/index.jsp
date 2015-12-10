<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.1.7/css/swiper.css">

    <style>
        html, body {
            position: relative;
            height: 100%;
        }
        body {
            background: #fff;
            font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
            font-size: 14px;
            color:#000;
            margin: 0;
            padding: 0;
        }
        .swiper-container {
            width: 100%;
            height: 50%;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 15px;
            margin-top: 15px;
        }
        .swiper-slide {
            background-size: cover;
            background-position: center;
        }
        .gallery-top {
            height: 600px;
            width: 600px;
        }
        .gallery-thumbs {
            height: 20%;
            box-sizing: border-box;
            padding: 10px 0;
        }
        .gallery-thumbs .swiper-slide {
            width: 25%;
            height: 100%;
            opacity: 0.4;
        }
        .gallery-thumbs .swiper-slide-active {
            opacity: 1;
        }

    </style>
</head>
<body>

<div class="swiper-container gallery-top">
    <div class="swiper-wrapper">
        <c:forEach var="i" begin="1" end="40">
            <div class="swiper-slide" style="background-image:url(<c:url value="/canon/rest/image/file/${i}"/>)"></div>
        </c:forEach>
    </div>
    <!-- Add Arrows -->
    <div class="swiper-button-next swiper-button-white"></div>
    <div class="swiper-button-prev swiper-button-white"></div>
</div>
<br>
<div class="swiper-container gallery-thumbs">
    <div class="swiper-wrapper">
        <c:forEach var="i" begin="1" end="40">
            <div class="swiper-slide" style="background-image:url(<c:url value="/canon/rest/image/file/${i}"/>)"></div>
        </c:forEach>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.1.7/js/swiper.js"></script>

<script>
    var galleryTop = new Swiper('.gallery-top', {
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        spaceBetween: 10,
        effect: 'cube',
        grabCursor: true,
        cube: {
            shadow: true,
            slideShadows: true,
            shadowOffset: 20,
            shadowScale: 0.94,
        },
        speed: 1000,
        autoplay: 2500,
        autoplayDisableOnInteraction: false,
        /*direction: 'vertical',*/
    });
    var galleryThumbs = new Swiper('.gallery-thumbs', {
        spaceBetween: 10,
        centeredSlides: true,
        slidesPerView: 'auto',
        touchRatio: 0.2,
        slideToClickedSlide: true
    });
    galleryTop.params.control = galleryThumbs;
    galleryThumbs.params.control = galleryTop;

</script>
</body>
</html>
