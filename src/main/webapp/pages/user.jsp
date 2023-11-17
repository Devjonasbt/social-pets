<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../assets/icones/pngwing.com.png" type="image/svg+xml">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/pages/styles/user.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath() %>/pages/js/user.js" defer></script>
    <title>User Profile</title>
</head>

<body>
<a href="../index.html">
    <button class="back">Voltar</button>
</a>

<div class="profile-container">
    <div class="profile-picture">
        <img id="profile-image" src="<%= request.getContextPath() %>/assets/images/homem-retrato-rindo.jpg" alt="Profile Picture">
        <input type="file" id="image-upload" accept="image/*" onchange="previewImage(event)">
    </div>

    <div class="profile-info">
        <p><strong>ID:</strong> <span id="user-id">123</span></p>
        <p><strong>Name:</strong> <span id="user-name">John Doe</span></p>
        <p><strong>Email:</strong> <span id="user-email">john.doe@example.com</span></p>
        <p><strong>Phone:</strong> <span id="user-phone">(123) 456-7890</span></p>
        <p><strong>Address:</strong> <span id="user-address">123 Main St, Cityville</span></p>
    </div>
</div>

<div id="carouselExampleInterval" class="carousel" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item" data-bs-interval="10000">
            <img src="<%= request.getContextPath() %>../assets/images/brinquedosPets.jpg" class="d-block w-100" alt="Brinquedos para Pets">
            <div class="carousel-text">
                <h3>Brinquedos variados</h3>
                <p>Encontre o brinquedo perfeito para seu pet!</p>
            </div>
        </div>
        <!-- Add other carousel items as needed -->
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</body>
</html>