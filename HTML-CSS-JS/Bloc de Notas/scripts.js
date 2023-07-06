// Funcion para guardar la nota del localStorage
function guardar() {
    let texto = document.getElementById("notas").value;
    localStorage.setItem("nota", texto);
    alert("Nota Guardada!")
}

// Funcion para borrar la nota del localStorage
function borrar() {
    let texto = "";
    localStorage.setItem("nota", texto);
    alert("Nota Borrada!")
    document.getElementById("notas").value = texto;
}

// Obtener la nota almacenado en el localStorage
let texto = localStorage.getItem("nota");

// Establece el valor del textarea con el valor de la nota almacenada
document.getElementById("notas").value = texto;