document.addEventListener('DOMContentLoaded', function() {
    fetch('/api/products') // Cambia esta URL por la ruta correcta de tu API
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(products => {
            const list = document.getElementById('products-list');
            products.forEach(product => {
                const item = document.createElement('li');
                item.innerHTML = `
                    <h2>${product.nombre}</h2>
                    <p>Precio: $${product.precio}</p>
                    <p>Descripción: ${product.descripcion}</p>
                    <p>Marca: ${product.marca}</p>
                `;
                list.appendChild(item);
            });
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
});
