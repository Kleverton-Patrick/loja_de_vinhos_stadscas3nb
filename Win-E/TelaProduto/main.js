const selectButtons = document.querySelectorAll(".select-button");
selectButtons.forEach((button, index) => {
    button.addEventListener("click", () => {
        let mensagem = '';

        switch (index) {
            case 0:
                mensagem = 'A Sugestão da casa é de vinho seco';
                break;
            case 1:
                mensagem = 'A Sugestão da casa é de vinho suave';
                break;
            case 2:
                mensagem = 'A Sugestão da casa é de vinho branco';
                break;
                case 3:
                mensagem = 'A Sugestão da casa é de vinho esse msm';
                break;
            default:
                mensagem = 'Card não reconhecido';
        }

        alert(mensagem);
    });
});
