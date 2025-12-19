const loginForm = document.getElementById('login-form');

loginForm.addEventListener('submit', function (e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({email, password})
    })
        .then(async response => {
            if (!response.ok) {
                const errorMessage = document.getElementById("error-message");
                errorMessage.innerText = "Tài khoản hoặc mật khẩu không chính xác!";
                throw new Error("Login failed");
            }

            return response.text();
        })
        .then(token => {
            localStorage.setItem("token", token);
            window.location.href = 'index.html';
        })
        .catch(error => {
            console.log(error);
        });

});
