# rm-front-u
Con rm-front-u añade interactividad a tus GUI desarrolladas en java, ademas añade slider u otros componentes interactivos para tus interfaces. En su primera version v1.0.0.0 incluye sliders automaticos y desplazamientos para panales.

rm-front-u te permitira realizar interfaces mucho mas interactivas con java, sin necesidad de aplciar JavaFX.
¿Cuantas veces no nos ha pasado que desarrollamos una interfaces y no nos convece? sentimos que le falta ese toque de html con css.

Estas pequeñas clases nos brindaran ese apoyo.

<h4>Importante:</h4>
rm-front-u esta desarrollodo con la version de Java 11

<h3>¿Que podremos encontrar con rm-fron-u?</h3>
<p>
  Para su primera version v.1.0.0.1 rm-front-u incluye:
</p>
<ul>
  <li><a href="#DX">Desplazamientos en X</a></li>
  <li><a href="#DY"> Desplazamientos en Y</a></li>
  <li><a href="#SA">Slider Automatico</a></li>
</ul>

<h1>¿Como funciona?</h1>

<p>Puedes descargar este repositorio y utilizar las clases de tu preferencia.
</p>

<h2 id="DX">La clase displacementX</h2>

<p>Esta pequeña clase nos permitira desplazar nuestro componente(JPane) en torno al eje X ya sea de derecha a izaquierda.</p>
<p>Algo importante a tener en cuenta es que esta funcionalidad por el momento no afecta al sistema de layout que utilizes por lo que deberas de manejar esos aspectos individualmente y que ademas esta diseñada para responder a eventos por botonoes por lo que deberas incluir un ActionListener a tu boton.</p>

<h4>Tipos de desplazamiento</h4>
DisplacementX cuenta con 4 tipos de desplazamiento:

<ul>
  <li><strong>Tipo 1:</strong> Te permite mover tus componentes con respecto al eje X negativo sin afectar el tamaño del componente. Dicho de otra manera te permite ocultar el componente.</li>
  <li><strong>Tipo 2:</strong> Te permite mover tus componentes con respecto al eje X positivo sin afectar el tamaño del componente. Dicho de otra manera te permite mostrar el componente.</li>
  <li><strong>Tipo 3:</strong> Te permite mover tus componentes con respecto al eje X negativo pero aumentando el tamaño en Ancho tomando en cuenta la cantidad de desplazamiento. Dicho de otra forma este tpo de dezplazamiento te permite abarcar el espacio sobrante que algun otro componente con un dezplazamiento de tipo 1 pudo haber dejado. </li>
  <li><strong>Tipo 4:</strong> Te permite mover tus componentes con respecto al eje X positivo pero disminuyendo el tamaño en Ancho tomando en cuenta la cantidad de desplazamiento. Dicho de otra forma este tpo de dezplazamiento regresa al estado original el componente si es que orimero tuvo un desplazamiento de tipo 3.</li>
</ul>

<h5>Instancia y parametros</h5>

<p>
  Esta clase recibe 7 parametros:
  <ul>
    <li>JPanel: El panel al que nosotros deseamos incorporar la interactividad</li>
    <li>XL: La catidad de desplzamiento que deseemos darle. Acepta valores negativos y positivos</li>
    <li>initialXL: La posicion inicial donde se encuentra nuestro componente</li>
    <li>intiialYL: La posicion inicial en "Y" donde se encuentra nuestro componente. Respeta su poscion </li>
    <li>deltaWidth: La cantidad de crecimiento que deseemos que nuestro panel aumente o disminuya (Tener en cuenta que este valor debe ser proporcional con XL). Si usas tipo 1 o 2, Deberas de incorporar como valor 0</li>
    <li>time: Define el tiempo que desees que dure el desplazamiento, por defecto puedes dejarlo en 5, este parametro esta en funcion de milisegundos</li>
    <li>typeDisplacement: Define el tipo de desplzamiento que desees ejecutar</li>
  </ul>
</p>

<p>
  Para llamar añadir la interactividad basta con colocar la siguiente linea de codigo:
  
  new displacementX(Panel, XL, initialXL, intiialYL, deltaWidth, time, typeDisplacement);
  
  <h5>Ejemplos</h5><br>
   @Override<br>
   public void actionPerformed(ActionEvent e) {<br>
        if (e.getSource().equals(btn) && state == 1){<br>
            new rmDisplacementX(menuPanel, -100, 0, 0, 0, 5, 1);<br>
            new rmDisplacementX(workPanel, 100, 200, 0, 100, 5,3);<br>
            state = 0;<br>
        }else if(e.getSource().equals(btn) && state == 0){<br>
            new rmDisplacementX(menuPanel, 0, -100, 0, 0, 5, 2);<br>
            new rmDisplacementX(workPanel, 200, 100, 0, 100, 5, 4);<br>
            state = 1;<br>
        }<br>
   }<br>
</p>

Para tener una mejor vision del funcionamiento puedes basarte en el archivo ExampleDisplacementXY que se encuentra la carpeta src/

<h2 id="DY">La clase displacementY</h2>

<p>Esta clase sigue las mismas bases que su antecesor DisplacementX por lo que cuentan con ambas caracteristicas</p>
<p>Algo importante a tener en cuenta es que esta funcionalidad por el momento no afecta al sistema de layout que utilizes por lo que deberas de manejar esos aspectos individualmente y que ademas esta diseñada para responder a eventos por botonoes por lo que deberas incluir un ActionListener a tu boton.</p>

<h4>Tipos de desplazamiento</h4>
DisplacementX cuenta con 4 tipos de desplazamiento:

<ul>
  <li><strong>Tipo 1:</strong> Te permite mover tus componentes con respecto al eje Y negativo sin afectar el tamaño del componente. Dicho de otra manera te permite ocultar el componente.</li>
  <li><strong>Tipo 2:</strong> Te permite mover tus componentes con respecto al eje Y positivo sin afectar el tamaño del componente. Dicho de otra manera te permite mostrar el componente.</li>
  <li><strong>Tipo 3:</strong> Te permite mover tus componentes con respecto al eje Y negativo pero aumentando el tamaño en Ancho tomando en cuenta la cantidad de desplazamiento. Dicho de otra forma este tpo de dezplazamiento te permite abarcar el espacio sobrante que algun otro componente con un dezplazamiento de tipo 1 pudo haber dejado. </li>
  <li><strong>Tipo 4:</strong> Te permite mover tus componentes con respecto al eje Y positivo pero disminuyendo el tamaño en Ancho tomando en cuenta la cantidad de desplazamiento. Dicho de otra forma este tpo de dezplazamiento regresa al estado original el componente si es que orimero tuvo un desplazamiento de tipo 3.</li>
</ul>

<h5>Instancia y parametros</h5>

<p>
  Esta clase recibe 7 parametros:
  <ul>
    <li>JPanel: El panel al que nosotros deseamos incorporar la interactividad</li>
    <li>YL: La catidad de desplzamiento que deseemos darle. Acepta valores negativos y positivos</li>
    <li>initialXL: La posicion inicial en "X" donde se encuentra nuestro componente. Respeta su posicion</li>
    <li>intiialYL: La posicion inicial en "Y" donde se encuentra nuestro componente </li>
    <li>deltaHeigth: La cantidad de crecimiento que deseemos que nuestro panel aumente o disminuya (Tener en cuenta que este valor debe ser proporcional con YL). Si usas tipo 1 o 2, Deberas de incorporar como valor 0</li>
    <li>time: Define el tiempo que desees que dure el desplazamiento, por defecto puedes dejarlo en 5, este parametro esta en funcion de milisegundos</li>
    <li>typeDisplacement: Define el tipo de desplzamiento que desees ejecutar</li>
  </ul>
</p>

<p>
  Para llamar añadir la interactividad basta con colocar la siguiente linea de codigo:
  
  new displacementY(Panel, YL, initialXL, intiialYL, deltaHeigth, time, typeDisplacement);
  
  <h5>Ejemplos</h5><br>
   @Override<br>
   public void actionPerformed(ActionEvent e) {<br>
        if (e.getSource().equals(btn) && state == 1){<br>
            new rmDisplacementY(workPanel, 100,200,0,0,5,2);<br>
            state = 0;<br>
        }else if(e.getSource().equals(btn) && state == 0){<br>
            new rmDisplacementY(workPanel, 0,200,100,0,5,1);<br>
            state = 1;<br>
        }<br>
   }<br>
</p>

Para tener una mejor vision del funcionamiento puedes basarte en el archivo ExampleDisplacementXY que se encuentra la carpeta src/

<h2 id="SA">La clase rmSliderAutomatic</h2>

<p>
Con esta clase nosotros tendremos un Slider Automatico como los que encontramos en las paginas web, la manera de implementarlo es muy sencilla.<br>

Esta clase lo primero que necesita es el JPanel el cual contendra todos los elementos a mostrar. Cuando nosotros instanciemos la clase lo primero que deberemos de pasar como parametro es JPanel.

JPanel Slide = new JPanel();
rmSliderAutomatic Slider = new rmSliderAutomatic(Slide);

De este modo nuestro slider ya esta casi listo, lo unico que necitaremos ahora es configurarlo. para ello utilizaremos el metodo confiSlide() que nos permitira definir los intervalos de movimiento y tiempo. La funcion recibe 6 paramatros:

<ul>
  <li>duration: Define el tiempo que dura el dezplazamiento de A a B y de B a C</li>
  <li>sleep: Define el tiempo que deseeas que el elemento a mostrar quede visible</li>
  <li>width: Define el ancho de tu Slider</li>
  <li>elements: Define la cantidad de elementos que tendra el slider (La calse tiene soporte para 2 o 3 elementos como maximo)</li>
  <li>XL: Define la posicion de los elementos de tu Slide en X</li>
  <li>YL: Define la posicion de los elementos de tu Slide en Y</li>
</ul>

Una vez dicho esto podemos proceder con un ejemplo:

JPanel Slide = new JPanel();
JPanel Panel1 = new JPanel();
JPanel Panel2 = new JPanel();
JPanel Panel3 = new JPanel();

rmSliderAutomatic Slider = new rmSliderAutomatic(Slide);

public void initComponents(){<br>
  Slider.setSize(2100, 250);//Suponiendo que el JFrame mide 700 pixeles tu panel debera tener 2 o 3 veces su tamaño en ancho segun los elementos a agregar<br>
  Slider.setLocation(0,0);<br>
  Slider.setLayout(null);<br>
  
  Panel1.setSize(700, 250);<br>
  Panel1.setLocation(0, 250);<br>
  Panel2.setSize(700, 250);<br>
  Panel2.setLocation(700, 250);<br>
  Panel3.setSize(700, 250);<br>
  Panel3.setLocation(1400, 250);<br>
  
  Slider.add(Panel1);<br>
  Slider.add(Panel2);<br>
  Slider.add(Panel3);<br>

  Slider.configSlide(5, 400, 700, 3, 0, 0);<br>
  this.add(Slider);<br>
}<br>

Puedes ver este ejemplo en accion ejecutando el archivo ExampleSliderAutomatic que se encuntra en la carpeta src/

</p>
