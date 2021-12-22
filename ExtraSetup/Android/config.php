<?php

	require_once('constants.php');

	$con=mysqli_connect($server_name,$user_name,$password,$database_name);

	require_once('controller.php');

        $cat=new mylibrary;
?>