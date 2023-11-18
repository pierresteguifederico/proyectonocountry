


// Variable global para el carrito
const carrito = [];
function mostrarContador(boton) {
    var contador = boton.nextElementSibling;
    contador.style.display = 'block';
    boton.style.display = 'none'; // Ocultar el botón "Añadir al menú"

    var nombreProducto = boton.parentNode.querySelector('h2').textContent;
    var precioProducto = boton.parentNode.querySelector('.precio').textContent;

    // Verificar si el producto ya está en el carrito y actualizar la cantidad en lugar de agregar uno nuevo
    const productoExistente = carrito.find(item => item.nombre === nombreProducto);
    if (productoExistente) {
        productoExistente.cantidad++;
    } else {
        carrito.push({
            nombre: nombreProducto,
            precioUnitario: parseFloat(precioProducto),
            cantidad: 1,
            subtotal: parseFloat(precioProducto),
        });
    }

    console.log(carrito);
    const total = calcularTotal(carrito);
    console.log('Total:', total);
    // Habilitar el botón de "Finalizar Compra" si hay productos en el carrito
    var finalizarCompraBtn = document.getElementById('finalizarCompraBtn');
    finalizarCompraBtn.disabled = carrito.length === 0;
}

function cambiarCantidad(elemento, cambio) {
    var inputCantidad = elemento.parentNode.querySelector('input');
    var cantidad = parseInt(inputCantidad.value) + cambio;

    if (cantidad < 0) {
        cantidad = 0; // No permitir cantidades menores a 0
    }

    // Mostrar el botón "Añadir al menú" si la cantidad es 0
    var boton = inputCantidad.parentNode.previousElementSibling;
    if (cantidad === 0) {
        boton.style.display = 'block';
        elemento.parentNode.style.display = 'none';

        // Eliminar el producto del carrito si la cantidad es 0
        var nombreProducto = boton.parentNode.querySelector('h2').textContent;
        const index = carrito.findIndex(item => item.nombre === nombreProducto);
        if (index !== -1) {
            carrito.splice(index, 1);
        }
    } else {
        boton.style.display = 'none';
        inputCantidad.value = cantidad;

        var nombreProducto = boton.parentNode.querySelector('h2').textContent;
        // Actualiza la cantidad en el carrito
        const productoExistente = carrito.find(item => item.nombre === nombreProducto);
        if (productoExistente) {
            productoExistente.cantidad = cantidad;
            var precioProducto = boton.parentNode.querySelector('.precio').textContent;
            var subtotal = cantidad * parseFloat(precioProducto); // Calcula el subtotal
            productoExistente.subtotal = subtotal;
            const total = calcularTotal(carrito);
            console.log('Total:', total);
        }
    }
}

function calcularTotal(carrito) {
    let total= 0;
    for (const producto of carrito) {
        total += producto.subtotal;
    }
    return total;
}

