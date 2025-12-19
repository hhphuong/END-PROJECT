var token = localStorage.getItem("token");
fetch("http://localhost:8080/auth/profile", {
    method: "GET",
    headers: {
        "Authorization": `Bearer ${token}`
    }
})
    .then(async response => {
        return response.json();
    })
    .then(data => {
        localStorage.setItem("user", JSON.stringify(data));
        const fullName = document.getElementById('fullName')
        fullName.innerText = data.name;

        const user = document.getElementById('user');
        user.addEventListener('click', () => {
            window.location.href = `user-detail.html?id=${data.id}`;
        })
    })
    .catch(error => {
        console.log(error);
        window.location.href = 'login.html';
    });

const logo = document.getElementById('logo');
logo.addEventListener('click', () => {
    window.location.href = 'login.html';
})


function generateMenu() {
    const menu = document.getElementById('menu');
    const items = [
        {name: 'Quản lý sản phẩm', link: 'index.html'},
        {name: 'Quản lý loại sản phẩm', link: 'category.html'},
        {name: 'Quản lý người dùng', link: 'user.html'},
    ];

    let itemHtml = ''

    for (let i = 0; i < items.length; i++) {
        itemHtml += `<div class="item" id="${i}">${items[i].name}</div>`
    }

    menu.innerHTML = itemHtml;

    for (let i = 0; i < items.length; i++) {
        const item = document.getElementById(i);
        item.addEventListener('click', () => {
            window.location.href = items[i].link;
        })
    }
}

generateMenu();