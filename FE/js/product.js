function getAllProducts() {
    const token = localStorage.getItem("token");
    fetch("http://localhost:8080/user/product", {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
        .then(async response => response.json())
        .then(data => {
            const dataTable = document.getElementById("data-table");
            let html = "";

            data.forEach((product, index) => {
                html += `
                    <tr>
                        <td>${index + 1}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>
                            <button onclick="gotoEdit(${product.id})">Sửa</button>
                            <button onclick="deleteProduct(${product.id})">Xóa</button>
                        </td>
                    </tr>
                `;
            });

            dataTable.innerHTML = html;
        })
        .catch(error => {
            console.log(error);
        });
}

function gotoEdit(id) {
    window.location.href = `product-detail.html?id=${id}`;
}

getAllProducts();
