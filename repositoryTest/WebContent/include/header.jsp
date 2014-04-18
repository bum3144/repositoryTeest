<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery UI -->
<link rel="stylesheet" href="../css/ui-lightness/jquery-ui-1.10.4.custom.css">
  <script src="../js/jquery-1.10.2.js"></script>
  <script src="../js/jquery-ui-1.10.4.custom.js"></script>






<link rel='stylesheet' type='text/css' href='../css.css'>
<script>
  $(function() {
	    $( "input[type=button], button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
	    $( "input[type=submit], button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
	    $( "input[type=reset], button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
  });
  
  
  $('#my-table').dynatable();  
 </script>