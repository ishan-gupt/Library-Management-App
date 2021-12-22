<?php 

	require_once "config.php";
	
	$enroll=@$_REQUEST['enroll'];
	$pass=@$_REQUEST['pass'];


	$sql="select * from studentdata where enroll = '".$enroll."' and password = '".$pass."';";
	$news="select * from news;";

	$result=mysqli_query($con,$sql);
	$news_result=mysqli_query($con,$news);
	$response=array();
	$news=array();
	
	if(@$rec=mysqli_fetch_array($result))
	{

		@$record_news=mysqli_fetch_all($news_result, MYSQLI_ASSOC);

		$code="Login";
		$message="Sucesss........";
		$book_code1=$rec['book_code1'];
		$book_code2=$rec['book_code2'];
		$book_issue1=$rec['book_issue1'];
		$book_issue2=$rec['book_issue2'];
		$book_submit1=$rec['book_submit1'];

		$book_submit2=$rec['book_submit2'];
		$book1_fine=$rec['book1_fine'];
		$book2_fine=$rec['book2_fine'];
		$enroll=$rec['enroll'];
		$surname=$rec['surname'];
		$mobile=$rec['mobile'];
		$sem=$rec['sem'];
		$dept=$rec['dept'];
		$name=$rec['name'];

		array_push($response, array('code' =>$code , 'message'=>$message, 'enroll'=>$enroll, 'name' =>$name , 'surname'=>$surname , 'mobile'=>$mobile , 
			'sem'=>$sem ,'dept'=>$dept , 'enroll'=>$enroll ,'book_code1'=>$book_code1 , 'book_issue1'=>$book_issue1 , 
			'book_submit1'=>$book_submit1 ,'book1_fine'=>$book1_fine,'book_code2'=>$book_code2 , 'book_issue2'=>$book_issue2 , 
			'book_submit2'=>$book_submit2 ,'book2_fine'=>$book2_fine,'news_name'=>$record_news  ));

		array_push($news, array('news_name'=>$record_news ));
        

		echo json_encode($response);
		
	}
	else
	{

		$code="Login fail or Id Password wrong";
		$message="Failed........";
		array_push($response, array('code' =>$code ,'message'=>$message));
		echo json_encode($response);

	}
	mysqli_close($con);
   

?>