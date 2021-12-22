<?php 

	require_once "config.php";
	
	$response=array();

   	 $ssenroll=@$_REQUEST['ssenroll'];
      $ssname=@$_REQUEST['ssname'];
      $sssurname=@$_REQUEST['sssurname'];
      $sspass=@$_REQUEST['sspass'];
      $ssdept=@$_REQUEST['ssdept'];
      $sssem=@$_REQUEST['sssem'];
      $ssmobile=@$_REQUEST['ssmobile'];

      $sre=$cat->getdata($con," * "," studentdata","where enroll = '".$ssenroll."'","");
    if(!$srec=mysqli_fetch_array($sre))
    {
     $r=$cat->adddata($con, "studentdata", array("enroll"=>$ssenroll, "name"=>$ssname, "surname"=>$sssurname, "sem"=>$sssem, "mobile"=>$ssmobile, "password"=>$sspass, "dept"=>$ssdept));
     //  $r=mysqli_query($con,"insert into  studentdata set sem='".$sssem."', enroll='".$ssenroll."', name='".$ssname."', surname='".$sssurname."', mobile='".$ssmobile."', password='".$sspass."' , dept='".$ssdept."' ;");
     //echo "------------->".$r;
      if($r==null)
      {

        $code="Done";
		$message="Thank you.......";
		array_push($response, array('code' =>$code ,'message'=>$message));
	    echo json_encode($response);

      }

      else
      {

        $code1="Fail";
		$message1="Fail Due Some error.......";
		array_push($response, array('code' =>$code1 ,'message'=>$message1));
		echo json_encode($response); 

	  }
 
    }
     else 
      {
        $code2="404";
		$message2="User already exist.......";
		array_push($response, array('code' =>$code2 ,'message'=>$message2));
		echo json_encode($response);
   }

	mysqli_close($con);
 
?>