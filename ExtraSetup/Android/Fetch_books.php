<?php 
	require_once "config.php";

	     $sem_books=@$_REQUEST['book_sem'];
	     $book_name=@$_REQUEST['book_name'];
	     $code=@$_REQUEST['book_code'];
		 $unit=array();

	if($sem_books!=null)
	{
		$sql="select * from books where b_sem = '".$sem_books."' ";
		
		$result=mysqli_query($con,$sql);
		@$record_sem_books=mysqli_fetch_all($result, MYSQLI_ASSOC);
		array_push($unit, array('book_data'=>$record_sem_books));
		echo json_encode($unit);
		
	}
	else if($book_name!=null)
	{
		$sql="select * from books where b_name = '".$book_name."' or b_author='".$book_name."' or b_dept='".$book_name."' ";
		
		$result=mysqli_query($con,$sql);
		@$record_book_name=mysqli_fetch_all($result, MYSQLI_ASSOC);
		array_push($unit, array('book_data'=>$record_book_name));
		echo json_encode($unit);
		
	}
	else if($code!=null)
	{
		$sql="select * from books where b_code = '".$code."' ";
		
		$result=mysqli_query($con,$sql);
		@$record_code=mysqli_fetch_all($result, MYSQLI_ASSOC);
		array_push($unit, array('book_data'=>$record_code));
		echo json_encode($unit);
		
	}
	else if($sem_books==null&&$book_name==null&&$code==null)
	{
		$sql="select * from books";
		
		$result=mysqli_query($con,$sql);
		@$record_sem_books=mysqli_fetch_all($result, MYSQLI_ASSOC);
		array_push($unit, array('book_data'=>$record_sem_books));
		echo json_encode($unit);
	}
	else if(false) {
		array_push($unit, array('book_data'=>'No data Found'));
		echo json_encode($unit);
	}

    
?>