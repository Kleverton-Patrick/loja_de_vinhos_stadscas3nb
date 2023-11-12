function formatarCPF(cpf) {
    cpf = cpf.replace(/\D/g, '');
    cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
    return cpf;
}

function atualizarCPFFormatado() {
    const cpfInput = document.getElementById('cpfCliente');
    let cpfValue = cpfInput.value;

    if (cpfValue.length > 14) {
        cpfValue = cpfValue.slice(0, 14);
    }

    cpfInput.value = formatarCPF(cpfValue);
}

const cpfInput = document.getElementById('cpfCliente');
cpfInput.addEventListener('input', atualizarCPFFormatado);
