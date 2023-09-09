document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.querySelector(".login-card form");

    loginForm.addEventListener("submit", function (e) {
        e.preventDefault();

        // Obtenha os valores do email e senha
        const email = document.getElementById("email").value;
        const senha = document.getElementById("senha").value;

        // Verifique se as credenciais são válidas
        if (email === "email@teste.com" && senha === "123") {
            // Credenciais válidas, redirecione para a tela de produtos
            window.location.href = "http://127.0.0.1:5500/TelaProduto/Produtos.html";
        } else {
            alert("Credenciais inválidas. Por favor, tente novamente.");
        }
    });
});
