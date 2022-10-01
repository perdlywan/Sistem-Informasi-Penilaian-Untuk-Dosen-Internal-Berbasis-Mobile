<?php  
 include_once('koneksi.php'); 

 $KodeDosen=$_POST['KodeDosen'];
 $Nidn=$_POST['Nidn'];
 $NamaDosen=$_POST['NamaDosen'];
 $TmptLahir=$_POST['TmptLahir'];
 $TglLahir=date('Y-d-m', strtotime($_POST['TglLahir']));
 $Status=$_POST['Status'];
 $Alamat=$_POST['Alamat'];
 $Kelurahan=$_POST['Kelurahan'];
 $Kecamatan=$_POST['Kecamatan'];
 $Kota_Kab=$_POST['Kota_Kab'];
 $Provinsi=$_POST['Provinsi'];
 $KodePos=$_POST['KodePos'];
 $NoHp=$_POST['NoHp'];
 $Pendidikan=$_POST['Pendidikan'];
 $JabatanAkademik=$_POST['JabatanAkademik']; 
 $Golongan=$_POST['Golongan'];
 $Prodi=$_POST['Prodi'];
 $BidangKeahlian=$_POST['BidangKeahlian'];

 $sql = "UPDATE dosen SET Nidn='$Nidn', NamaDosen='$NamaDosen', TmptLahir='$TmptLahir', TglLahir='$TglLahir', Status='$Status', Alamat='$Alamat', Kelurahan='$Kelurahan', Kecamatan='$Kecamatan', Kota_Kab='$Kota_Kab', Provinsi='$Provinsi', KodePos='$KodePos', NoHp='$NoHp', Pendidikan='$Pendidikan', JabatanAkademik='$JabatanAkademik', Golongan='$Golongan',Prodi='$Prodi',BidangKeahlian='$BidangKeahlian' WHERE KodeDosen = '$KodeDosen'";

 $result = mysqli_query($koneksi,$sql);

 if($result){
  echo "Data dosen berhasil diupdate";
 }
 else{
  echo "Failed";
  mysqli_close($koneksi);
 }
?>