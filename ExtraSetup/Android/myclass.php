<?php
class mylibrary
{
	function adddata($con, $tblname, $fldlist)		//adddata("member", array("name"=>$_POST['txtname'), "pass"=>$_POST['txtpass']));
	{
		$fdata="";
		foreach($fldlist as $k=>$v)
		{
			$fdata .= " $k='$v',";   //name='$nm',mobile='$mo',
			
		}
		$fdata=trim($fdata,",");  //name='$nm',mobile='$mo'
		//$fdata=substr($fdata,0,-1);
		mysqli_query($con, "INSERT INTO $tblname set $fdata");
	}



	function editdata($con,$tblname, $fldlist, $condition)		//editdata("member", array("name"=>$_POST['txtname'), "pass"=>$_POST['txtpass']), " where id='$id'");
	{
		$fdata="";
		foreach($fldlist as $k=>$v)
		{
			$fdata .= " $k='$v',";
		}
		
		//$fdata=substr($fdata,0,-1);
		$fdata=trim($fdata,",");
		$q="UPDATE $tblname set $fdata $condition";
		echo $q;
		if(mysqli_query($con,$q))
		{
			return 1;
		}
		else{
			return 0;
		}
	}




	function deldata($con,$tblname, $condition)		//deldata("member", " where id='$id'");
	{
		
		$query= "DELETE FROM $tblname $condition";
		echo $query;
		mysqli_query($con,$query);
	}


	function getdata($con, $fldlist, $tblname, $condition, $ord)		//getdata("member", "id,name,email,phone", " where cit='$cit'", " order b phonr");
	{
		return mysqli_query($con,"SELECT $fldlist FROM $tblname $condition $ord");
	}
}
?>