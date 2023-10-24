
    const carousel = document.querySelector('.carousel');
    const images = document.querySelectorAll('.carousel img');
    let currentIndex = 0;
    let intervalId;

    function startCarousel() {
        intervalId = setInterval(() => {
            currentIndex = (currentIndex + 1) % images.length;
            updateCarousel();
        }, 3000); // Altere o valor (em milissegundos) para ajustar a velocidade do carrossel
    }

    function stopCarousel() {
        clearInterval(intervalId);
    }

    function updateCarousel() {
        const translateX = -currentIndex * 100;
        carousel.style.transform = `translateX(${translateX}%)`;
    }

    // Iniciar o carrossel quando a página carregar
    startCarousel();

    // Pausar o carrossel quando o mouse estiver sobre o carrossel
    carousel.addEventListener('mouseenter', stopCarousel);

    // Continuar o carrossel quando o mouse sair do carrossel
    carousel.addEventListener('mouseleave', startCarousel);
