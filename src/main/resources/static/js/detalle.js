$(document).ready(function () {
  $("#photoForm").submit(function (event) {
    event.preventDefault();

    var cantidad = parseInt($("#cantidad").val());
    var precioUnitario = parseFloat($("#precioUnitario").val());
    var precioTotal = cantidad * precioUnitario;

    var data = {
      fk_id_pedido: 1, // valores de prueba
      fk_id_producto: 2, // valores de prueba
      cantidad: cantidad,
      precioTotal: precioTotal,
      precio_envio: 0, // valores de prueba
    };

    $.ajax({
      type: "POST",
      url: "/detallepedido/guardarDetallePedido",
      data: JSON.stringify(data),
      contentType: "application/json",
      success: function (response) {
        console.log("Datos enviados con éxito: " + response);
      },
      error: function (error) {
        console.log("Error al enviar los datos: " + error);
      },
    });
  });
});
