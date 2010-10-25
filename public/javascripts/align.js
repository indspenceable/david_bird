function getWindowHeight() {
  var windowHeight = 0;
  if (typeof(window.innerHeight) == 'number') {
    windowHeight = window.innerHeight;
  }
  else {
    if (document.documentElement && document.documentElement.clientHeight) {
      windowHeight = document.documentElement.clientHeight;
    }
    else {
      if (document.body && document.body.clientHeight) {
        windowHeight = document.body.clientHeight;
      }
    }
  }
  return windowHeight;
}
function f_scrollTop() {
  var ScrollTop = document.body.scrollTop;

  if (ScrollTop == 0)
  {
    if (window.pageYOffset)
      ScrollTop = window.pageYOffset;
    else
      ScrollTop = (document.body.parentElement) ? document.body.parentElement.scrollTop : 0;
  }
  return ScrollTop;
}
function setContent( el ) {
  if (document.getElementById) {
    var windowHeight = getWindowHeight();
    if (windowHeight > 0) {
      var contentElement = document.getElementById(el);
      var contentHeight = contentElement.offsetHeight;
      if (windowHeight - contentHeight > 0) {
        contentElement.style.position = 'relative';
        contentElement.style.top = f_scrollTop() + ((windowHeight * (1 / 2)) - (contentHeight / 2)) + 'px';
      }
      else {
        contentElement.style.position = 'static';
      }
    }
  }
}
window.onload = function() {
  setContent('navbar');
  setContent('content');
}
window.onresize = function() {
  setContent('navbar');
  setContent('content');
}
window.onscroll = function() {
  setContent('navbar');
}
