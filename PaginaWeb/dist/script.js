function consultar() {
  var numero = document.getElementById("telefono").value;
  
  var content = document.querySelector('.info');
  content.style.display = 'grid';
}

function ocultar() {
  var cultivos = document.querySelector('.cultivos');
  var pedidos = document.querySelector('.pedidos');
  
  cultivos.style.display = 'none';
  pedidos.style.display = 'none';
}

function mostrarPedidos() {
  var pedidos = document.querySelector('.pedidos');
  
  ocultar();
  pedidos.style.display = 'table';
}

function mostrarCultivos() {
  var cultivos = document.querySelector('.cultivos');
  
  ocultar();
  cultivos.style.display = 'table';
}