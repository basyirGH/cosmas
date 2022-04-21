<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Courses</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Courses.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.2.6, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/templogo2.jpg"
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Courses">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body"><header class="u-clearfix u-header u-header" id="sec-2657"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="294" data-image-height="103">
          <img src="images/templogo2.jpg" class="u-logo-image u-logo-image-1">
        </a>
        <nav class="u-align-right u-menu u-menu-dropdown u-offcanvas u-menu-1">
          <div class="menu-collapse u-custom-font u-font-open-sans" style="font-size: 1rem; letter-spacing: 0px; font-weight: 700; text-transform: uppercase;">
            <a class="u-button-style u-custom-active-border-color u-custom-active-color u-custom-border u-custom-border-color u-custom-borders u-custom-hover-border-color u-custom-hover-color u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
              <svg viewBox="0 0 24 24"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
              <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><symbol id="menu-hamburger" viewBox="0 0 16 16" style="width: 16px; height: 16px;"><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
            </a>
          </div>
          <div class="u-custom-menu u-nav-container">
            <ul class="u-custom-font u-font-open-sans u-nav u-spacing-30 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-border-2 u-border-active-palette-1-base u-border-hover-palette-1-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="Home.html" style="padding: 10px 0px;">Home</a>
</li><li class="u-nav-item"><a class="u-border-2 u-border-active-palette-1-base u-border-hover-palette-1-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="About.html" style="padding: 10px 0px;">About</a>
</li><li class="u-nav-item"><a class="u-border-2 u-border-active-palette-1-base u-border-hover-palette-1-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="Contact.html" style="padding: 10px 0px;">Contact</a>
</li></ul>
          </div>
          <div class="u-custom-menu u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-inner-container-layout u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Home.html" style="padding: 10px 0px;">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="About.html" style="padding: 10px 0px;">About</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Contact.html" style="padding: 10px 0px;">Contact</a>
</li></ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
      </div></header>
    <section class="u-align-center u-clearfix u-section-1" id="sec-5ad4">
      <div class="u-clearfix u-sheet u-sheet-1">
        <form action="${request.contextPath}/COSMAS/ControllerUser" method="post">
        	<h5 style="color:#5085BA" class="u-text u-text-default u-text-1"><a><input type="submit" name="command" value="Home" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"></a> <span style="color:black"> > Courses </span></h5>
        </form>
        <h4 class="u-text u-text-default u-text-2">
          <a class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-palette-1-base u-btn-1" href="add-new-course.jsp" data-page-id="13610887"><span class="u-file-icon u-icon u-icon-1"><img src="images/1237946.png" alt=""></span>&nbsp; &nbsp;Add New Course
          </a>
        </h4>
        <h3 class="u-text u-text-default u-text-3"><span class="u-file-icon u-icon u-icon-2"><img src="images/482631.png" alt=""></span>&nbsp;Ctrl + F
        </h3>
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
          <table class="u-table-entity u-table-entity-1">
            <colgroup>
              <col width="7.3%">
              <col width="42.8%">
              <col width="25%">
              <col width="24.900000000000006%">
            </colgroup>
            <thead class="u-black u-table-header u-table-header-1">
              <tr style="height: 26px;">
                <th class="u-border-1 u-border-black u-table-cell"></th> 
                <th class="u-border-1 u-border-black u-table-cell">Name</th>
                <th class="u-border-1 u-border-black u-table-cell">Code</th>
                <th class="u-border-1 u-border-black u-table-cell">Credit Value</th> 
              </tr>
            </thead>
            <tbody class="u-table-body">
            	<c:forEach items="${courseList}" var="course">
	            	<tr style="height: 75px;">
	                <td class="u-border-2 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell"> </td>
	                <td class="u-border-2 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell">
	                  <form id="view-course-form" action="${request.contextPath}/COSMAS/ControllerCourse" method="post"> 
		                  <input id="submit-course-code" type="hidden" value="${course.courseCode}" name="courseCode"> 
		                  <a><input id="submit-view-course" type="submit" value="${course.courseName}" name="command" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"></a>
	                  </form> 
	                </td>
	                <td class="u-border-2 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell">${course.courseCode}</td>
	                <td class="u-border-2 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell">${course.courseCredit}</td>
	              	</tr>
				</c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </section>
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-835c"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-default u-text-variant u-text-1">MOHAMAD BASYIR BIN ZAINUDDIN</p>
      </div></footer>
  
  <section class="u-black u-clearfix u-container-style u-dialog-block u-opacity u-opacity-70 u-section-9" id="carousel_a51f">
      <div class="u-container-style u-dialog u-white u-dialog-1">
        <div class="u-container-layout u-container-layout-1">
          <h4 class="u-text u-text-default u-text-1">Last Modified of "CSF3107 SMART SYSTEM"</h4>
          <div class="u-form u-form-1">
            <form action="#" method="POST" class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 10px;">
              <div class="u-form-group u-form-name u-label-left">
                <label for="name-8f37" class="u-label u-spacing-0 u-label-1">Action</label>
                <input type="text" id="name-8f37" name="name" class="u-border-1 u-border-grey-30 u-grey-10 u-input u-input-rectangle u-input-1" required="">
              </div>
              <div class="u-form-group u-label-left">
                <label for="email-8f37" class="u-label u-spacing-0 u-label-2">Date</label>
                <input type="text" id="email-8f37" name="email" class="u-border-1 u-border-grey-30 u-grey-10 u-input u-input-rectangle u-input-2" required="required">
              </div>
              <div class="u-form-group u-label-left">
                <label for="message-8f37" class="u-label u-spacing-0 u-label-3">Modified by</label>
                <input rows="4" cols="50" id="message-8f37" name="message" class="u-border-1 u-border-grey-30 u-grey-10 u-input u-input-rectangle u-input-3" required="required" type="text">
              </div>
              <div class="u-form-group u-label-left u-form-group-4">
                <label for="text-61a5" class="u-label u-spacing-0 u-label-4">Permitted By</label>
                <input type="text" placeholder="" id="text-61a5" name="text" class="u-border-1 u-border-grey-30 u-grey-10 u-input u-input-rectangle u-input-4">
              </div>
              <div class="u-form-group u-label-left u-form-group-5">
                <label for="text-5dd9" class="u-label u-spacing-0 u-label-5">Permitted On</label>
                <input type="text" placeholder="" id="text-5dd9" name="text-1" class="u-border-1 u-border-grey-30 u-grey-10 u-input u-input-rectangle u-input-5">
              </div>
              <div class="u-align-left u-form-group u-form-submit">
                <a href="#" class="u-btn u-btn-submit u-button-style">Done</a>
                <input type="submit" value="submit" class="u-form-control-hidden">
              </div>
              <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
              <div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>
              <input type="hidden" value="" name="recaptchaResponse">
            </form>
          </div>
          <div class="u-list u-list-1">
            <div class="u-repeater u-repeater-1">
              <div class="u-container-style u-custom-item u-list-item u-repeater-item">
                <div class="u-container-layout u-similar-container u-container-layout-2">
                  <a href="#carousel_d49a" class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-dialog-link u-hover-feature u-none u-text-palette-1-base u-btn-2"><span class="u-file-icon u-icon u-icon-1" data-animation-name="" data-animation-duration="0" data-animation-delay="0" data-animation-direction=""><img src="images/7249332.png" alt=""></span>&nbsp;<br>Download Entire&nbsp;<br>Modification Log for This Course
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div><button class="u-dialog-close-button u-icon u-text-grey-40 u-icon-2"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 16 16" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-efe9"></use></svg><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content" viewBox="0 0 16 16" x="0px" y="0px" id="svg-efe9"><rect x="7" y="0" transform="matrix(0.7071 -0.7071 0.7071 0.7071 -3.3138 8.0002)" width="2" height="16"></rect><rect x="0" y="7" transform="matrix(0.7071 -0.7071 0.7071 0.7071 -3.3138 8.0002)" width="16" height="2"></rect></svg></button>
      </div>
      <style class="u-block-2a9b-30 u-state-style">.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]), .u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):before {
    transition-property: fill, color, background-color, stroke-width, border-style, border-width, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position
}
.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):hover {
    box-shadow: 2px 2px 8px 0 rgba(var(--grey-50-r),var(--grey-50-g),var(--grey-50-b),1) !important
}
.u-block-2a9b-30.u-block-2a9b-30.u-block-2a9b-30.hover {
    box-shadow: 2px 2px 8px 0 rgba(var(--grey-50-r),var(--grey-50-g),var(--grey-50-b),1) !important
} </style>
      <style class="u-btn-2 u-state-style">.u-section-9 .u-btn-2, .u-section-9 .u-btn-2:before {
    transition-property: fill, color, background-color, stroke-width, border-style, border-width, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position
}
.u-section-9 .u-btn-2.u-btn-2.u-btn-2:hover {
    box-shadow: 2px 2px 8px 0 rgba(var(--grey-50-r),var(--grey-50-g),var(--grey-50-b),1) !important
}
.u-section-9 .u-btn-2.u-btn-2.u-btn-2.hover {
    box-shadow: 2px 2px 8px 0 rgba(var(--grey-50-r),var(--grey-50-g),var(--grey-50-b),1) !important
} </style>
      <style class="u-block-2a9b-31 u-state-style">.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]), .u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):before {
    transition-property: fill, color, background-color, stroke-width, border-style, border-width, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position
}
.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):hover {
    box-shadow: 2px 2px 8px 0 rgba(var(--grey-50-r),var(--grey-50-g),var(--grey-50-b),1) !important
}
.u-block-2a9b-31.u-block-2a9b-31.u-block-2a9b-31.hover {
    box-shadow: 2px 2px 8px 0 rgba(var(--grey-50-r),var(--grey-50-g),var(--grey-50-b),1) !important
} </style>
    </section><style> .u-section-9 {
  min-height: 840px;
}

.u-section-9 .u-dialog-1 {
  width: 800px;
  min-height: 512px;
  margin: 30px auto 60px;
}

.u-section-9 .u-container-layout-1 {
  padding: 0;
}

.u-section-9 .u-text-1 {
  margin: 34px auto 0 30px;
}

.u-section-9 .u-form-1 {
  height: 352px;
  width: 740px;
  margin: 18px auto 0;
}

.u-section-9 .u-label-1 {
  width: 141px;
}

.u-section-9 .u-input-1 {
  background-image: none;
}

.u-section-9 .u-label-2 {
  width: 141px;
}

.u-section-9 .u-input-2 {
  background-image: none;
}

.u-section-9 .u-label-3 {
  width: 141px;
}

.u-section-9 .u-input-3 {
  background-image: none;
}

.u-section-9 .u-form-group-4 {
  margin-left: 0;
}

.u-section-9 .u-label-4 {
  width: 141px;
}

.u-section-9 .u-input-4 {
  background-image: none;
}

.u-section-9 .u-form-group-5 {
  margin-left: 0;
}

.u-section-9 .u-label-5 {
  width: 141px;
}

.u-section-9 .u-input-5 {
  background-image: none;
}

.u-section-9 .u-list-1 {
  width: 260px;
  margin: -64px 34px 0 auto;
}

.u-section-9 .u-repeater-1 {
  grid-gap: 0px 0px;
  grid-template-columns: 100%;
  min-height: 115px;
}

.u-section-9 .u-container-layout-2 {
  padding: 10px;
}

.u-section-9 .u-btn-2 {
  border-style: none none solid;
  transition-duration: 0.5s;
  box-shadow: 2px 0 0 0 rgba(0,0,0,0);
  margin: 0 auto;
  padding: 0;
}

.u-section-9 .u-icon-1 {
  font-size: 1.75em;
  color: rgb(0, 0, 0) !important;
  background-image: none;
}

.u-section-9 .u-icon-2 {
  width: 20px;
  height: 20px;
}

@media (max-width: 1199px) {
  .u-section-9 .u-dialog-1 {
    height: auto;
  }

  .u-section-9 .u-list-1 {
    width: 260px;
    margin-top: -64px;
  }

  .u-section-9 .u-repeater-1 {
    grid-template-columns: 33.3333% 33.3333% 33.3333%;
  }
}

@media (max-width: 991px) {
  .u-section-9 .u-dialog-1 {
    width: 720px;
  }

  .u-section-9 .u-form-1 {
    width: 720px;
  }

  .u-section-9 .u-list-1 {
    width: 223px;
    margin-right: 12px;
  }
}

@media (max-width: 767px) {
  .u-section-9 .u-dialog-1 {
    width: 540px;
    margin-top: 213px;
  }

  .u-section-9 .u-container-layout-1 {
    padding-top: 25px;
    padding-bottom: 25px;
  }

  .u-section-9 .u-text-1 {
    margin-top: -2px;
  }

  .u-section-9 .u-form-1 {
    width: 540px;
    margin-top: 11px;
  }

  .u-section-9 .u-list-1 {
    width: 206px;
    margin-top: -70px;
    margin-right: 13px;
  }
}

@media (max-width: 575px) {
  .u-section-9 .u-dialog-1 {
    width: 340px;
  }

  .u-section-9 .u-text-1 {
    margin-top: 68px;
  }

  .u-section-9 .u-form-1 {
    width: 340px;
    margin-top: -59px;
  }

  .u-section-9 .u-list-1 {
    width: 266px;
    margin-top: 0;
    margin-left: 0;
  }
}

.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]),
.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):before {
  transition-property: fill, color, background-color, stroke-width, border-style, border-width, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position;
}

.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):hover {
  box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important;
}

.u-block-2a9b-30.u-block-2a9b-30.u-block-2a9b-30.hover {
  box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important;
}

.u-section-9 .u-btn-2,
.u-section-9 .u-btn-2:before {
  transition-property: fill, color, background-color, stroke-width, border-style, border-width, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position;
}

.u-section-9 .u-btn-2.u-btn-2.u-btn-2:hover {
  box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important;
}

.u-section-9 .u-btn-2.u-btn-2.u-btn-2.hover {
  box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important;
}

.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]),
.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):before {
  transition-property: fill, color, background-color, stroke-width, border-style, border-width, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position;
}

.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):hover {
  box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important;
}

.u-block-2a9b-31.u-block-2a9b-31.u-block-2a9b-31.hover {
  box-shadow: 2px 2px 8px 0 rgba(128,128,128,1) !important;
}</style></body>
</html>