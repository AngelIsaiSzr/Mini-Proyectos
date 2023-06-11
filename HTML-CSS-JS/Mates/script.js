// Selecciona el botón del menú y el menú desplegable
const botonMenu = document.querySelector('.boton-menu');
const opcionesMenu = document.querySelector('.opciones-menu');

// Función para mostrar u ocultar el menú de navegación
function toggleMenu() {
  if (opcionesMenu.style.display === 'block') {
    opcionesMenu.style.display = 'none';
  } else {
    opcionesMenu.style.display = 'block';
  }
}

// Agrega un event listener al documento
// para cerrar el menú cuando se haga clic en cualquier lugar fuera del menú
document.addEventListener('click', function(event) {
  // Verifica si se hizo clic fuera del menú desplegable o del botón del menú
  if (!opcionesMenu.contains(event.target) && !botonMenu.contains(event.target)) {
    opcionesMenu.style.display = 'none';
  }
});
// Función para mostrar una sección específica y ocultar las demás
function mostrarSeccion(id) {
  const secciones = document.querySelectorAll('section');
  for (let i = 0; i < secciones.length; i++) {
    if (secciones[i].id === id + '-seccion') {
      secciones[i].style.display = 'block';
    } else {
      secciones[i].style.display = 'none';
    }
  }
}

// Establecer la sección "inicio" como la sección predeterminada
mostrarSeccion('inicio');

// Función para mostrar la tabla de multiplicar
function mostrarTabla() {
  const tabla = parseInt(document.getElementById("tabla").value);
  const resultado = document.getElementById("tabla-resultado");
  const error = document.getElementById("tabla-error");
  if (!isNaN(tabla)) {
    error.innerHTML = "";
    let resultadoTabla = "";
    for (let i = 1; i <= 10; i++) {
      resultadoTabla += `${tabla} x ${i} = ${tabla * i}<br>`;
    }
    resultado.innerHTML = resultadoTabla;
  } else {
    resultado.innerHTML = "Error: debe ingresar un número válido";
  }
}

// Función para realizar una operación matemática
function operar(operacion) {
  const num1 = parseFloat(document.getElementById("num1").value);
  const num2 = parseFloat(document.getElementById("num2").value);
  const resultado = document.getElementById("resultado");
  if (!isNaN(num1) && !isNaN(num2)) {
    let resultadoOperacion;
    switch (operacion) {
      case "+":
        resultadoOperacion = num1 + num2;
        break;
      case "-":
        resultadoOperacion = num1 - num2;
        break;
      case "*":
        resultadoOperacion = num1 * num2;
        break;
      case "/":
        if (num2 === 0) {
          resultadoOperacion = "Error: división por cero";
        } else {
          resultadoOperacion = num1 / num2;
        }
        break;
    }
    resultado.innerHTML = resultadoOperacion;
  } else {
    resultado.innerHTML = "Error: debe ingresar dos números válidos";
  }
}

// Funciones para realizar operaciones matemáticas específicas
function sumar() {
  operar("+");
}

function restar() {
  operar("-");
}

function multiplicar() {
  operar("*");
}

function dividir() {
  operar("/");
}

// Función para convertir unidades de medida
function convertir() {
  // Obtener valores de los elementos del DOM
  const unidadOrigen = document.getElementById("unidad-origen").value;
  const unidadDestino = document.getElementById("unidad-destino").value;
  const valor = document.getElementById("valor").value;

  // Verificar que las unidades seleccionadas son válidas y diferentes
  if (unidadOrigen === unidadDestino) {
    document.getElementById("conversor-resultado").innerHTML = "Error: seleccione unidades diferentes";
    return;
  } else if (!["metros", "kilometros", "pies", "millas"].includes(unidadOrigen) || !["metros", "kilometros", "pies", "millas"].includes(unidadDestino)) {
    document.getElementById("conversor-resultado").innerHTML = "Error: seleccione unidades válidas";
    return;
  }

  // Verificar que se haya ingresado un número
  if (isNaN(valor) || valor === "") {
    document.getElementById("conversor-resultado").innerHTML = "Error: debe ingresar un número válido";
    return;
  }

  // Convertir el valor a la unidad de origen (metros)
  let valorEnMetros = 0;
  switch (unidadOrigen) {
    case "metros":
      valorEnMetros = valor;
      break;
    case "kilometros":
      valorEnMetros = valor * 1000;
      break;
    case "pies":
      valorEnMetros = valor / 3.2808;
      break;
    case "millas":
      valorEnMetros = valor * 1609.344;
      break;
  }

  // Convertir el valor en metros a la unidad de destino
  let resultado = 0;
  switch (unidadDestino) {
    case "metros":
      resultado = valorEnMetros;
      break;
    case "kilometros":
      resultado = valorEnMetros / 1000;
      break;
    case "pies":
      resultado = valorEnMetros * 3.2808;
      break;
    case "millas":
      resultado = valorEnMetros / 1609.344;
      break;
  }

  // Mostrar el resultado en el elemento del DOM correspondiente
  document.getElementById("conversor-resultado").innerHTML = resultado.toFixed(2);
}

// Variables para el cronómetro
let tiempoInicio = 0;
let intervalo = null;
let tiempoPasado = 0;

// Función para iniciar el cronómetro
function iniciarCronometro() {
  tiempoInicio = Date.now() - tiempoPasado;
  intervalo = setInterval(function() {
    let tiempoActual = Date.now();
    tiempoPasado = tiempoActual - tiempoInicio;
    actualizarTiempo(tiempoPasado);
  }, 10);
}

// Función para detener el cronómetro
function detenerCronometro() {
  clearInterval(intervalo);
}

// Función para reiniciar el cronómetro
function reiniciarCronometro() {
  clearInterval(intervalo);
  tiempoPasado = 0;
  actualizarTiempo(tiempoPasado);
  document.getElementById("tiempo-transcurrido").innerHTML = "00:00:00";
}

// Función para actualizar el tiempo mostrado por el cronómetro
function actualizarTiempo(tiempo) {
  let horas = Math.floor(tiempo / 3600000);
  let minutos = Math.floor((tiempo % 3600000) / 60000);
  let segundos = Math.floor((tiempo % 60000) / 1000);
  let centesimas = Math.floor(tiempo % 1000 / 10);
  let tiempoFormateado = (horas < 10 ? "0" : "") + horas + ":" +
    (minutos < 10 ? "0" : "") + minutos + ":" +
    (segundos < 10 ? "0" : "") + segundos + "." +
    (centesimas < 10 ? "0" : "") + centesimas;
  document.getElementById("tiempo-transcurrido").innerHTML = tiempoFormateado;
}

// Variables para el temporizador
var intervalId;
var segundosTotales;
var segundosRestantes;

// Función para iniciar el temporizador
function iniciarTemporizador() {
  // Obtiene el número de segundos ingresado por el usuario y lo convierte a un entero
  segundosTotales = parseInt(document.getElementById("temporizador-input").value);
  segundosRestantes = segundosTotales;

  // Verifica si el número ingresado es válido
  if (isNaN(segundosTotales) || segundosTotales < 1 || segundosTotales > 3600) {
    // Muestra un mensaje de error si el número no es válido
    document.getElementById("temporizador-resultado").innerHTML = "Ingrese un número válido entre 1 y 3600";
    return;
  }

  // Oculta cualquier mensaje de error existente y muestra un mensaje de que el temporizador se iniciará pronto
  document.getElementById("temporizador-resultado").innerHTML = "";
  document.getElementById("temporizador-resultado").innerHTML = "El temporizador se iniciará en breve...";

  // Establece un intervalo que llama a la función actualizarTemporizador() cada segundo
  intervalId = setInterval(actualizarTemporizador, 1000);
}

// Función para detener el temporizador
function detenerTemporizador() {
  if (!intervalId) {
    // El temporizador no se ha iniciado todavía, muestra un mensaje de error
    document.getElementById("temporizador-resultado").innerHTML = "El temporizador no se ha iniciado todavía.";
    return;
  }

  // Detiene el intervalo y borra cualquier mensaje mostrado en el resultado del temporizador
  clearInterval(intervalId);
  document.getElementById("temporizador-resultado").innerHTML = "";
}

// Función para actualizar el temporizador cada segundo
function actualizarTemporizador() {
  // Si el tiempo se ha agotado, detiene el temporizador y muestra un mensaje indicando que el tiempo ha terminado
  if (segundosRestantes <= 0) {
    detenerTemporizador();
    document.getElementById("temporizador-resultado").innerHTML = "¡Tiempo terminado!";
    return;
  }

  // Calcula los minutos y segundos restantes
  var minutos = Math.floor(segundosRestantes / 60);
  var segundos = segundosRestantes % 60;

  // Crea una cadena de texto que muestra el tiempo restante en minutos y segundos
  var tiempoMostrado = minutos + "m " + segundos + "s";

  // Muestra el tiempo restante en el resultado del temporizador y disminuye los segundos restantes en uno
  document.getElementById("temporizador-resultado").innerHTML = tiempoMostrado;
  segundosRestantes--;
}

// Función para manejar el envío de un formulario
function enviado(event) {
  event.preventDefault(); // Evita que se envíe el formulario automáticamente

  // Verifica si los campos requeridos están completos
  if (document.getElementById("nombre").value && document.getElementById("email").value.includes("@") && document.getElementById("mensaje").value) {
    // Si todos los campos requeridos están completos, muestra el mensaje de alerta y redirige a otra página
    alert('Enviado Correctamente!');
    window.location.href = 'index.html';
  } else if (document.getElementById("nombre").value && document.getElementById("email").value && document.getElementById("mensaje").value) {
    // Si no se a escrito un correo electronico valido, muestra un mensaje de error
    alert('Ingresa un correo electrónico válido!');
  } else {
    // Si no se han completado todos los campos requeridos, muestra un mensaje de error
    alert('Por favor, complete todos los campos requeridos.');
  }
}
