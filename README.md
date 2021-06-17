# Gestor de Usuarios Personal (GUP) 📋
 #### Descripción:                                                                                                                                      
📢 _Manejo de información en tablas basado en un gestor de usuarios con JFrame( JTable, buttons, etc.) con cifrado y base de datos en .txt local hecho en NetBeans Java. (Imagenes al final)_                                                                                                                                                                                       
                                                                                                                                        
📢 _Los datos que son almacenados dentro del sistema son codificados y cifrados en la base de datos, estos se interpretan nuevamente en la carga de datos una vez el sistema inicia._

### =================[Version PreAlpha del proyecto GUP (14-03-21)]======================

- El proyecto consta de varios archivos de los cuales los importantes son:             
    + CargaYalmacenamientoDeObjetos.java --> Es la prueba de crear y almacenar informacion en .txt .          
    + VentanaTabla.java --> Es la prueba de manipular informacion dentro de una JTable en NetBeans.       
    + CargarTable.java --> Es el código del programa PreAlpha de un gestor de usuarios personal.    
      
<i>Algunas clases son a forma de testeo de funciones como "DefaultTableModel", "DataOutputStream" o "FileInputStream", entre otras.</i>
- Esta versión consta con:   
``` 
- Carga y descarga de información.   
- Botones con funciones independientes.    
- Click en tabla para modificar.   
- Campos de texto dinamicos.   
- Pronto subiré la version del programa final. 
``` 
<b>(Advertencia NO se puede utilizar el caracter '+' para rellenar campos debido al algoritmo de guardar/cargar, próximo a mejorar).</b> 

### =================[Versión Alpha del proyecto GUP (30-03-21)]======================

Las clases anteriores fueron <b>remplazadas</b>.    
- El proyecto consta de 4 clases o JFrames.                          
    + ventanaLogin --> Login para acceder.                       
    + ventanaPpal --> Gestór o programa principal.              
    + ventanaInformacion --> Informacion útil para el usuario.             
    + ventanaCreditos --> Créditos y versiones de programas involucrados.
    
Esta versión consta con:                                    
``` 
- Mejoras en el sistema interno.                   
- Mejora en carga y descarga de información.                           
- Mejora en experiencia usuario.                 
- Modo noche.                                                                          
- Contraseña oculta con posibilidad de observar.                       
- Se añadió nueva sección "Plataforma" para reconocer a donde pertenece .                          
- Se añadieron botones llamados "Elementos" que permiten asociar una cuenta a una plataforma.                
- Mayor velocidad y menos consumo de memoria.                    
- Nueva interface.                         
- Crea archivos en la raíz del programa cuando no existan.                     
- Necesidad de rellenar todos los campos para evitar vacíos.                             
- Botones visuales sin texto.                                
- Fluides de información.                                      
``` 
<b>(Advertencia se sigue sin poder utilizar el caracter '+' para rellenar campos).</b>    

### =================[Próxima version prevista para el (??/??/2021)]====================== 

_NOVEDAD: Se permitirá la descarga del mismo para pruebas y testeo._                                                                                               
_ACTUALIZACION: Se vio retrasada la fecha y se posterga, disculpe las molestias._

### ======================[IMAGENES]======================
 #### Login
 
![login](https://user-images.githubusercontent.com/77556113/122333572-c2d28380-cf0e-11eb-8022-d5870bbeb93c.png)
``` 

No requiere de usuario ya que es "Personal", pero si requiere una contraseña/token para mayor seguridad. 

El " token " es UNICO, se genera con caracteres aleatorios y se vincula al usuario que utilice el programa.

Es necesario que el token se almacene o se guarde de forma segura en algun otro medio ya que es unico y con el se accede al sistema.

Tiene la posibilidad de "Cambiar Contraseña" pero para hacerlo es necesario el " token ".

``` 
#### Ventana Principal

![ppal buttons](https://user-images.githubusercontent.com/77556113/122334527-45a80e00-cf10-11eb-8817-714776d2083f.png)

``` 

La tabla desplegada contiene la informacion de correos, usuarios y plataformas.

Los botones son ilustrativos pero posando el mouse sobre ellos obtenemos informacion.

Es posible elegir entre modo dia/noche.

Para revelar las contraseñas es necesario presionar sobre el botón de "visualizar" (ojo al lado de contraseña).

Es posible:
        + Agregar.
        + Editar.
        + Borrar.
        + Guardar.
        
+ Los paneles "Créditos" e "Información" contienen instrucciones que ayudan al usuario a comprender el sistema.

``` 

🔧 _NOVEDADES:Muchas funciones se optimizaron y funcionan de manera correcta, el programa está en estapa "alpha" final. Además el conflicto del caracter '+' ya fue solucionado de manera exitosa, el cifrado y protección de la información se ha duplicado siendo más efectivo para el robo de informacion._ 🔧
