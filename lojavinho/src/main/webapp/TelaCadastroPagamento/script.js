console.log("O script.js está sendo carregado.");

document.addEventListener('DOMContentLoaded', function () {

  // Máscara para o número do cartão
  document.getElementById('numCartao').addEventListener('input', function (e) {
    let inputValue = e.target.value.replace(/\D/g, '');
    let formattedValue = formatCreditCardNumber(inputValue);
    e.target.value = formattedValue;
  });

  // Validação para o campo Nome no Cartão
  document.getElementById('nomeCartao').addEventListener('input', function (e) {
    let inputValue = e.target.value.replace(/[^a-zA-Z\s]/g, ''); // Remove caracteres que não são letras e espaços
    e.target.value = inputValue;
  });

  // Validação para o campo CVC
  document.getElementById('cvc').addEventListener('input', function (e) {
    let inputValue = e.target.value.replace(/\D/g, '');
    let formattedValue = formatCVC(inputValue);
    e.target.value = formattedValue;
  });

  // Máscara para o campo de data de validade (MM/AAAA)
  document.getElementById('validadeCartao').addEventListener('input', function (e) {
    let inputValue = e.target.value.replace(/\D/g, ''); // Remove caracteres não numéricos
    let formattedValue = formatExpiryDate(inputValue);
    e.target.value = formattedValue;
  });

  function formatCreditCardNumber(value) {
      let formattedValue = value.slice(0, 16).replace(/(\d{4})/g, '$1 ').trim();
      return formattedValue;
    }

  function formatCVC(value) {
    return value.slice(0, 3);
  }

 function formatExpiryDate(value) {
     // Adiciona barras entre os números
     return value.replace(/(\d{2})(\d{0,4})/, '$1/$2').slice(0, 7);
   }


});
