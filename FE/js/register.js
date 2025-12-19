const loginForm = document.getElementById('register-form');

loginForm.addEventListener('submit', function (e) {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, email, password })
    })
        .then(async response => {
            if (!response.ok) {
                const errorText = await response.text();
                const errorMessage = document.getElementById("error-message");
                errorMessage.innerText = errorText;
                return;
            }

            return response.text();
        })
        .then(data => {
            localStorage.setItem("token", data);
            window.location.href = 'index.html';
        })
        .catch(error => {
            console.log(error);
        });
});
