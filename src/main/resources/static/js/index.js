window.onload = function() {
    const alertElement = document.getElementById('alertMessage');
    const successAlert = document.getElementById('alertSuccess');
    const errorAlert = document.getElementById('alertError');
    const excluirMessage = document.getElementById('messageExcluir');
    const editarMessage = document.getElementById('successMessage');

    if (editarMessage) {
        setTimeout(() => {
            editarMessage.style.display = 'none';
        }, 5000);
    }

    if (excluirMessage) {
        setTimeout(() => {
            excluirMessage.style.display = 'none';
        }, 5000);
    }

    if (errorAlert) {
        setTimeout(() => {
            errorAlert.style.display = 'none';
        }, 5000);
    }

    if (successAlert) {
        setTimeout(() => {
            successAlert.style.display = 'none';
        }, 5000);
    }

    if (alertElement) {
        const messageText = alertElement.textContent || alertElement.innerText;
        if (messageText.includes("sucesso")) {
            alertElement.classList.add("alert-success");
            alertElement.classList.remove("alert-danger");
        } else {
            alertElement.classList.add("alert-danger");
            alertElement.classList.remove("alert-success");
        }

        setTimeout(function() {
            alertElement.style.transition = "opacity 0.5s ease";
            alertElement.style.opacity = "0";
            setTimeout(() => alertElement.remove(), 500);
        }, 5000);
    }
}
