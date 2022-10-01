<?php 
 include_once('koneksi.php'); 

 $result = array();
 $result['data'] = array();
 $select= "SELECT KodeDosen,Nidn,NamaDosen,TmptLahir,DATE_FORMAT(TglLahir,'%d/%m/%Y') as TglLahir,Status,Alamat,Kelurahan,Kecamatan,Kota_Kab,Provinsi,KodePos,NoHp,Pendidikan,JabatanAkademik,Golongan,Prodi,BidangKeahlian from dosen";
 $response = mysqli_query($koneksi,$select);

 while ($row = mysqli_fetch_array($response)) 
 {
 	$index['KodeDosen'] = $row['0'];
 	$index['Nidn'] = $row['1'];
 	$index['NamaDosen'] = $row['2'];
 	$index['TmptLahir'] = $row['3'];
 	$index['TglLahir'] = $row['4'];
 	$index['Status'] = $row['5'];
 	$index['Alamat'] = $row['6'];
 	$index['Kelurahan'] = $row['7'];
 	$index['Kecamatan'] = $row['8'];
 	$index['Kota_Kab'] = $row['9'];
 	$index['Provinsi'] = $row['10'];
 	$index['KodePos'] = $row['11'];
 	$index['NoHp'] = $row['12'];
 	$index['Pendidikan'] = $row['13'];
 	$index['JabatanAkademik'] = $row['14'];
 	$index['Golongan'] = $row['15'];
 	$index['Prodi'] = $row['16'];
 	$index['BidangKeahlian'] = $row['17'];

 	array_push($result['data'], $index);
 }

 	$result["success"]="1";
 	echo json_encode($result);
 	mysqli_close($koneksi);

 ?>