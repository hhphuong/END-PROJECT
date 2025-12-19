const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get("id");

const test = document.getElementById("test")
test.innerText = "findbyid user = " + id