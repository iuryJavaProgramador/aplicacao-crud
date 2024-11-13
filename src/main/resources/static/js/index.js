window.onload = function() {
            const alertElement = document.getElementById('alertMessage');

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