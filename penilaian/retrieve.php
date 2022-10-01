<?php 
 include_once('koneksi.php'); 

 $result = array();
 $result['data'] = array();
 $select= "SELECT * from penilaian";
 $response = mysqli_query($koneksi,$select);

 while ($row = mysqli_fetch_array($response)) 
 {
 	$index['id'] = $row['0'];
 	$index['nama_dosen'] = $row['1'];
 	$index['pertanyaan1'] = $row['2'];
 	$index['pertanyaan2'] = $row['3'];
 	$index['pertanyaan3'] = $row['4'];
 	$index['pertanyaan4'] = $row['5'];
 	$index['pertanyaan5'] = $row['6'];
 	$index['pertanyaan6'] = $row['7'];
 	$index['pertanyaan7'] = $row['8'];
 	$index['pertanyaan8'] = $row['9'];

 	array_push($result['data'], $index);
 }

 	$result["success"]="1";
 	echo json_encode($result);
 	mysqli_close($koneksi);

 ?>