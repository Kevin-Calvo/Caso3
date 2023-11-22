function consultar() {
    var numero = document.getElementById("telefono").value;
  
    const existe = mostrarUser(numero);
  
    if (existe) {
      var content = document.querySelector('.info');
      content.style.display = 'grid';
    }
    else {
      console.log("El número que digitó no está registrado");
    }
    
  }

  function mostrarUser(numTel) {
    var tabla = document.getElementById("usuario");
    const user = obtenerObjeto("Agricultor", numTel);
    
    if (user) {
      var fila = tabla.insertRow();
  
      var celda1 = fila.insertCell(0);
      var celda2 = fila.insertCell(1);
      var celda3 = fila.insertCell(2);
      var celda4 = fila.insertCell(3);
      var celda5 = fila.insertCell(4);
      
      celda1.innerHTML = user.identificacion;
      celda2.innerHTML = user.apellido;
      celda3.innerHTML = user.nombre;
      celda4.innerHTML = user.fechaRegistro;
  
      return true;
    }
    else {
      return false;
    }
    
  }