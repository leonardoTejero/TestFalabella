
#language: es

Característica: Agregar producto al carrito

  @AgregarAlCarrito
  Escenario: Agregar producto al carrito exitosamente
    Dado que el usuario ingresa a la pagina de falabella
    Cuando el usuario hace una busqueda de producto y lo selecciona
    Y modifica la cantidad del producto y lo agrega al carrito
    Entonces el usuario ve el mismo nombre y cantidad del producto seleccionado en el carrito


