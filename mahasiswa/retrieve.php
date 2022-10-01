<?php 
 include_once('koneksi.php'); 

 $result = array();
 $result['data'] = array();
 $select= "SELECT nim, nama_mahasiswa, tempat_lahir, DATE_FORMAT(tanggal_lahir,'%d/%m/%Y') as tanggal_lahir, status, alamat, kecamatan, kota_kab, provinsi, kode_pos, no_hp, pendidikan_terakhir, prodi from mahasiswa";
 $response = mysqli_query($koneksi,$select);

 while ($row = mysqli_fetch_array($response)) 
 {
 	$index['nim'] = $row['0'];
 	$index['nama_mahasiswa'] = $row['1'];
 	$index['tempat_lahir'] = $row['2'];
 	$index['tanggal_lahir'] = $row['3'];
 	$index['status'] = $row['4'];
 	$index['alamat'] = $row['5'];
 	$index['kecamatan'] = $row['6'];
 	$index['kota_kab'] = $row['7'];
 	$index['provinsi'] = $row['8'];
 	$index['kode_pos'] = $row['9'];
 	$index['no_hp'] = $row['10'];
 	$index['pendidikan_terakhir'] = $row['11'];
 	$index['prodi'] = $row['12'];

 	array_push($result['data'], $index);
 }

 	$result["success"]="1";
 	echo json_encode($result);
 	mysqli_close($koneksi);

 ?>