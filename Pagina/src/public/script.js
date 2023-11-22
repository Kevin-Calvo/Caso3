async function consultar() {
    var user = document.getElementById("usuario").getElementsByTagName("tbody")[0];
    user.innerHTML = "";
    var prods = document.getElementById("productos").getElementsByTagName("tbody")[0];
    prods.innerHTML = "";

    var numero = parseInt(document.getElementById("telefono").value);

    var fila = await buscarUser(numero);

    if (fila) {
        var nombre = fila.getElementsByTagName("td")[2].textContent;
        var apellido = fila.getElementsByTagName("td")[1].textContent;
        var agricultor = nombre + " " + apellido;
        console.log(agricultor);
        
        var hayTransacciones = await buscarProd(agricultor);
        var costo = 0;

        if (hayTransacciones) {
            var tabla = document.getElementById("productos").getElementsByTagName("tbody")[0].getElementsByTagName("tr");
            for (var i = 0; i < tabla.length; i++) {
                costo += parseInt(tabla[i].getElementsByTagName("td")[4].textContent);
            }
        }
        
        fila.getElementsByTagName("td")[4].innerHTML = costo;

        var content = document.querySelector(".info");
        content.style.display = "grid";
    }
    else {
        alert("El número telefónico que digitó no se encuentra registrado en el sistema");
        
        var content = document.querySelector(".info");
        content.style.display = "none";
    }
}

async function buscar(coleccion, dato) {
    console.log("Obteniendo datos");
    const response = await fetch('/buscar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `dato=${dato}&coleccion=${coleccion}`
    });

    const data = await response.json();
    console.log(data);
    
    return data;
        
}

async function buscarUser(numTel) {
    var tabla = document.getElementById("usuario");

    try {
        const user = await buscar("Agricultor", parseInt(numTel));
    
        if (Object.keys(user).length) {
            var fila = tabla.getElementsByTagName("tbody")[0].insertRow();
        
            var celda1 = fila.insertCell(0);
            var celda2 = fila.insertCell(1);
            var celda3 = fila.insertCell(2);
            var celda4 = fila.insertCell(3);
            var celda5 = fila.insertCell(4);
            
            celda1.innerHTML = user.identificacion;
            celda2.innerHTML = user.apellido;
            celda3.innerHTML = user.nombre;
            celda4.innerHTML = user.fechaRegistro;
            
            console.log("Datos desplegados");
            return fila;
        }
        else {
            return null;
        }
    } catch (error) {
        console.log("Error al obtener datos");
        return null;
    }
}

async function buscarProd(agricultor) {
    var tabla = document.getElementById("productos").getElementsByTagName("tbody")[0];

    try {
        const cultivos = await buscar("Inventario", agricultor);
        const transacciones = await buscar("Transaccion", agricultor);

        if (cultivos.length > 0 || transacciones.length > 0) {
            if (cultivos.length > 0) {
                for (var i = 0; i < cultivos.length; i++) {
                    const prod = cultivos[i];
                    var fecha = prod.cosecha.substring(0, 10);
    
                    var j = 0;
                    var cuerpo = tabla.getElementsByTagName("tr");
    
                    while (j < cuerpo.length && new Date(fecha) < new Date(cuerpo[j].getElementsByTagName("td")[0].textContent)) {
                        j++;
                    }
    
                    var fila = tabla.insertRow(j);
            
                    var celda1 = fila.insertCell(0);
                    var celda2 = fila.insertCell(1);
                    var celda3 = fila.insertCell(2);
                    var celda4 = fila.insertCell(3);
                    var celda5 = fila.insertCell(4);
    
                    console.log(prod);
                    
                    celda1.innerHTML = fecha;
                    celda2.innerHTML = prod.cultivo;
                    celda3.innerHTML = prod.costo;
                    celda4.innerHTML = prod.cantidad;
                    celda5.innerHTML = prod.costo*prod.cantidad;
                }
    
            }

            if (transacciones.length > 0) {
                for (var i = 0; i < transacciones.length; i++) {
                    const prod = transacciones[i];
                    var date = prod.fecha.substring(0, 10);
    
                    var j = 0;
                    var cuerpo = tabla.getElementsByTagName("tr");
    
                    while (j < cuerpo.length && new Date(date) < new Date(cuerpo[j].getElementsByTagName("td")[0].textContent)) {
                        j++;
                    }
    
                    var fila = tabla.insertRow(j);
            
                    var celda1 = fila.insertCell(0);
                    var celda2 = fila.insertCell(1);
                    var celda3 = fila.insertCell(2);
                    var celda4 = fila.insertCell(3);
                    var celda5 = fila.insertCell(4);
    
                    console.log(prod);
                    
                    celda1.innerHTML = date;
                    celda2.innerHTML = prod.producto;
                    celda3.innerHTML = prod.precioUnidad;
                    celda4.innerHTML = prod.cantidad;
                    celda5.innerHTML = "-" + prod.total;
                }
            }
            
            return true;
        }
        else {
            return false;
        }
    } catch (error) {
        console.log("Error al obtener datos");
        return false;
    }
}
