<%-- 
    Document   : Inicio
    Created on : 1 dic. 2022, 23:58:43
    Author     : Edgar Garibay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/style-incio.css">
    <script src="https://kit.fontawesome.com/1632a450cb.js" crossorigin="anonymous"></script>
     <!-- Bootstrap CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
     <link rel="stylesheet" href="style/style.css">
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
    <title>Iniciar</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
          <a class="navbar-brand" href="#"><img class="img-logo" src="img/Mark Tech1.png" width="70" height="50" alt=""></a> 
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="html/index.html">Inicio</a>
              </li>
           
              <li class="nav-item">
                <a class="nav-link" href="#">Ofertas</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Categorías
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Audio y video </a></li>
                  <li><a class="dropdown-item" href="#">Computo</a></li>
                  <li><a class="dropdown-item" href="#">Celulares </a></li>
                  <li><a class="dropdown-item" href="#">Videojuegos</a></li>
                  
                </ul>
              </li>
              
                <li class="nav-item">
                    <a class="nav-link btn btn-dark text-light me-2" href="html/Inicio.html">Ingresar</a>
                
            



                  <li>
                        <a href=""><img class="img-carrito" src="img/carrito-de-compras.png" width="32" height="32" alt=""></a>




                  </li>
            </ul>
           
          
          </div>
        </div>
      </nav>
    <!-- <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
          
            <a class="navbar-brand" href="/html/index.html">
                
                <span class="align-middle confetti"> Tech Mark</span>  
                
            </a>
          
        </div>
      </nav> -->
      
    <div class="bodyy">
        <div class="container">
            <div class="blueBg">
                <div class="box signin">
                    <h2>¿Ya tienes una cuenta?</h2>
                    <button class="siginBtn"> Inicia Sesion</button>
                </div>
                <div class="box signin">
                    <h2>¿No tienes una cuenta?</h2>
                    <button class="signupBtn"> Registrate </button>
                </div>
            </div>
            <div class="formBx">
                <div class="form signinForm">
                    <form>
                        <h3>Iniciar sesión</h3>
                        <input type="text" name= "nombre" placeholder="Nombre de Usuario">
                        <input type="password" name= "contraseña" placeholder="Contraseña">
                        <input type="submit" value="Iniciar Sesion">
                        <a href="#" class="forgot">¿Olvidaste tu contraseña?</a>
                    </form>
                </div>
    
                <div class="form signupForm">
                    <form method="post" action="RecuperarUsuario">
                        <h3>Registrarse</h3>
                     <abbr title="Campo obligatorio" aria-label="Campo obligatorio">  * <input type="text" name= "nombre" placeholder="Nombre de Usuario" ></abbr>
                        <abbr title="Campo obligatorio" aria-label="Campo obligatorio"> *<input type="email" name= "Correo" placeholder="Correo Electronico"></abbr>
                       <abbr title="Campo obligatorio" aria-label="Campo obligatorio">  *<input type="password" name= "Contrasenia" placeholder="Contraseña"></abbr>
                      <abbr title="Campo obligatorio" aria-label="Campo obligatorio">   *<input type="password"  name= "confirmar" placeholder="Confirmar Contraseña"></abbr>
                         <input type="submit"   value="Registrarse">
                    </form>
                </div>
            </div>
        </div>
    </div>
   

    <script>
        const siginBtn =document.querySelector('.siginBtn');
        const signupBtn =document.querySelector('.signupBtn');
        const formBx =document.querySelector('.formBx');
        const body =document.querySelector('body')

        signupBtn.onclick = function(){
            formBx.classList.add('active')
            body.classList.add('active')
        }
        siginBtn.onclick = function(){
            formBx.classList.remove('active')
            body.classList.remove('active')
        }
     
    </script>

</body>
</html>
