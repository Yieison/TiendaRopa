document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/api/productos')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('products-list');
            data.forEach(product => {
                const item = document.createElement('li');
                item.textContent = `Nombre: ${product.nombre}, Precio: ${product.precio}, Descripción: ${product.descripcion}, Marca: ${product.marca}`;
                list.appendChild(item);
            });
        })
        .catch(error => console.error('Error al cargar los productos:', error));
});
