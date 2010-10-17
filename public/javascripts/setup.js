$(document).ready(function() {
  $("#nav .target").click(function(e) {
      e.preventDefault();
      alert(e.relatedTarget);
    });
  });
