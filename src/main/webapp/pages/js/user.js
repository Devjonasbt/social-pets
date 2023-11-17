function previewImage(event) {
    var input = event.target;

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            document.getElementById('profile-image').src = e.target.result;
        };

        reader.readAsDataURL(input.files[0]);
    }
}

// Aqui você pode adicionar lógica para carregar as informações do usuário, por exemplo, de um servidor.
document.getElementById('user-id').textContent = '123';
document.getElementById('user-name').textContent = 'John Doe';
document.getElementById('user-email').textContent = 'john.doe@example.com';
document.getElementById('user-phone').textContent = '(123) 456-7890';
document.getElementById('user-address').textContent = '123 Main St, Cityville';
