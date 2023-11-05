// Função para formatar o CPF no padrão brasileiro
function formatarCPF(cpf) {
    cpf = cpf.replace(/\D/g, ''); // Remove todos os caracteres não numéricos
    cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4'); // Aplica a formatação ###.###.###-##
    return cpf;
}

// Função para atualizar o campo de CPF formatado
function atualizarCPFFormatado() {
    const cpfInput = document.getElementById('cpfCliente');
    const cpfValue = cpfInput.value;
    cpfInput.value = formatarCPF(cpfValue);
}

// Adicione um ouvinte de evento de input ao campo de CPF
const cpfInput = document.getElementById('cpfCliente');
cpfInput.addEventListener('input', atualizarCPFFormatado);
