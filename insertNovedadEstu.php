<?PHP
$hostname_localhost ="localhost";  //nuestro servidor
$database_localhost ="movil(1)";//Nombre de nuestra base de datos
$username_localhost ="root";//Nombre de usuario de nuestra base de datos (yo utilizo el valor por defecto)
$password_localhost ="";//Contraseña de nuestra base de datos (yo utilizo por defecto)
$conexion= mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost );//Conexión a nuestro servidor mysql
 //mensaaje de 
//variables que almacenan los valores que enviamos por nuestra app, (observar que se llaman igual en nuestra app y aqui)
$id_curso=$_POST['id_curso'];
$cancelacionClase="";
$cambioSalon="";
$recordatorio=$_POST['recordatorio'];
$salidaCampo=$_POST['salidaCampo'];
$longitud='0';
$lactitud='0';


$query_search = "INSERT INTO novedades(cambioSalon, cancelacionClase, recordatorio, salidaCampo, longitud, lactitud, id_curso) VALUES ('".$cambioSalon."','".$cancelacionClase."','".$recordatorio."','".$salidaCampo."','".$longitud."','".$lactitud."','".$id_curso."')";//Sentencia sql a realizar
$resultado=$conexion->query($query_search);
echo"ejecucion ok";
?>
